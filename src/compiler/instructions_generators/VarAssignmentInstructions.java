package compiler.instructions_generators;

import compiler.*;
import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class VarAssignmentInstructions {
    // in value there is the whole right side
    public static ArrayList<Instruction> generateInstructions(Symbol s, String value, int indexToAssignTo, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable, boolean assignToSymbol){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        int addr = s.getAdr(); // the address to store the new value to
        int level = s.getLev();
        String actualVal = value;
        //boolean valAtTop = false;
        //int index = -1;
        boolean setInGlob = true;

        if(s.isConst() && s.hasBeenDeclared()){
            // cannot assign to const again - print err
            Error.printConstAssign(s.getName());
        }



        // we can assign only string to a string
        if(s.getType() == ESymbolType.STRING /*&& !ExpressionParser.isNumeric(value) && !ExpressionParser.isExpression(value)*/){
            // it's not a number and it's not an expression - can be var name or string
            // ok assignment to string

            // merge the right side:
            //if(value.contains("+")){
                // concatenating used
                String[] splits = value.split("\\+");
                String result = "";
                ArrayList<String> results = new ArrayList<>(splits.length);
                ArrayList<Integer> results_addrs = new ArrayList<>(splits.length);

                for(int i = 0; i < splits.length; i++){
                    //System.out.println(splits[i]);

                    if(splits[i].charAt(0) == '\"' && splits[i].charAt(splits[i].length() - 1) == '\"'){
                        // literal
                        result += splits[i].substring(1,splits[i].length() - 1);

                        results.add(splits[i].substring(1,splits[i].length() - 1));
                        results_addrs.add(-1);
                    }
                    else{
                        // var name?
                        if(privTable.containsKey(splits[i])) {
                            // there is a var with this name
                            if (privTable.get(splits[i]).getType() == ESymbolType.STRING) {
                                result += privTable.get(splits[i]).getValue();

                                results.add(privTable.get(splits[i]).getValue());
                                results_addrs.add(privTable.get(splits[i]).getAdr());
                                //setInGlob = false;
                            }
                            else{
                                // cannot assign
                                Error.printCannotAssign(s.getName(), splits[i]);
                            }
                        }
                        else if(globTable.containsKey(splits[i])) {
                            // there is a var with this name
                            if (globTable.get(splits[i]).getType() == ESymbolType.STRING) {
                                result += globTable.get(splits[i]).getValue();

                                results.add(globTable.get(splits[i]).getValue());
                                results_addrs.add(globTable.get(splits[i]).getAdr());
                                //setInGlob = true;
                            }
                            else{
                                // cannot assign
                                Error.printCannotAssign(s.getName(), splits[i]);
                            }
                        }
                        else{
                            // no var found
                            Error.printVarNotFound(splits[i]);
                        }
                    }

                }

                System.out.println("result: " + result);
            //}

            // we have the right side merged.
            if(result.length() > s.getValue().length()){
                Error.printStringTooLong(s.getName(), result);
            }

            // else proceed:
            int currInd = 0;
            for(int i = 0; i < results.size(); i++){
                String currResult = results.get(i);
                int currAddr = results_addrs.get(i);

                if(currAddr == -1){
                    // literal
                    for(int j = 0; j < currResult.length(); j++){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)currResult.charAt(j)));
                        generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + currInd));
                        currInd++;
                    }
                }
                else{
                    // already stored string var
                    for(int j = 0; j < currResult.length(); j++){
                        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, currAddr + j));
                        generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + currInd));
                        currInd++;
                    }
                }
            }


            actualVal = result;

            if(assignToSymbol)
                s.setValue(actualVal);
            return generatedInstructions;
        }

        // took care of strings ^^
        // try to parse the value as expression:
        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(value, globTable, privTable);
        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);

                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));
            }
            actualVal = "" + opOrd.get(opOrd.size() - 1).getResult();
            if(opOrd.get(opOrd.size() - 1).isNegateResult()){
                actualVal = "" + opOrd.get(opOrd.size() - 1).getNegatedResult();
            }

            //valAtTop = true;
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol;
            if(retrSymb != null){
                //if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
                    if(retrSymb.getAdr() == -1){
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                            actualVal = retrSymb.getValue(); // ??
                        }
                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                            actualVal = "" + retrSymb.negate();
                        }

                    }
                    else{
                        if(retrSymb.getIndToArray() == -1){
                            if(!retrSymb.isNegateValue()){
                                generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                                actualVal = retrSymb.getValue();
                            }
                            else{
                                generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                                actualVal = "" + retrSymb.negate();
                            }

                        }

                        else{
                            if(retrSymb.getIndToArray() >= s.getSizeArr()){
                                Error.printOutOfBounds(s.getName(), retrSymb.getIndToArray());
                            }

                            if(!retrSymb.isNegateValue()){
                                generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                                actualVal = "" + retrSymb.getArrayElements().get(retrSymb.getIndToArray());
                            }
                            else{
                                generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                                actualVal = "" + retrSymb.negate();
                            }

                        }

                    }
                //}
            }
            else{
                System.out.println("weird");
            }
        }



        System.out.println("actual val being assigned to " + s.getName() + ": " + actualVal);
        // now whatever it is, it should be at the top of the stack
        if(indexToAssignTo == -1){
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr));
            if(assignToSymbol){

                if(globTable.containsKey(s.getName())){
                    globTable.get(s.getName()).setValue(actualVal);
                }
                else if(privTable.containsKey(s.getName())){
                    privTable.get(s.getName()).setValue(actualVal);
                }
                else{
                    Error.printVarNotFound(s.getName());
                }

            }

            //s.setValue(actualVal);
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + indexToAssignTo));
            if(assignToSymbol){
                if(globTable.containsKey(s.getName())){
                    globTable.get(s.getName()).getArrayElements().set(indexToAssignTo, Integer.parseInt(actualVal));
                }
                else if(privTable.containsKey(s.getName())){
                    privTable.get(s.getName()).getArrayElements().set(indexToAssignTo, Integer.parseInt(actualVal));
                }
                else{
                    Error.printVarNotFound(s.getName());
                }

            }

        }


        return generatedInstructions;
    }

}
