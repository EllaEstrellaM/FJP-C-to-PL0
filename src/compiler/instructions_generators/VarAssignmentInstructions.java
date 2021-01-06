package compiler.instructions_generators;

import compiler.*;
import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class VarAssignmentInstructions {

    // todo index when we want to change one element in an array / string
    // todo what should we do, when arr1 = arr2 happens? -> point to the same memory?
    // in value there is the whole right side
    public static ArrayList<Instruction> generateInstructions(Symbol s, String value, int indexToAssignTo, HashMap<String, Symbol> table){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        int addr = s.getAdr(); // the address to store the new value to
        int level = s.getLev();
        String actualVal = value;
        boolean valAtTop = false;
        //int index = -1;





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
                        if(table.containsKey(splits[i])) {
                            // there is a var with this name
                            if (table.get(splits[i]).getType() == ESymbolType.STRING) {
                                result += table.get(splits[i]).getValue();

                                results.add(table.get(splits[i]).getValue());
                                results_addrs.add(table.get(splits[i]).getAdr());
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
                        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, currAddr + j)); // todo 0?
                        generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + currInd));
                        currInd++;
                    }
                }
            }


//            for(int i = 0; i < result.length(); i++){
//                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)result.charAt(i)));
//                generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i));
//            }
            actualVal = result;


//            if(value.charAt(0) == '\"' && value.charAt(value.length() - 1) == '\"'){
//                // it's a string literal we want to assign to the string variable
//                // check if it's too long:
//                if(value.length() - 2 > s.getValue().length()){
//                    // the string literal is longer than what the string was declared for
//                    Error.printStringTooLong(s.getName(), value);
//                }
//
//                // proceed:
//                for(int i = 1; i < value.length() - 1; i++){
//                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(i)));
//                    generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i - 1));
//                }
//                actualVal = value.substring(1,value.length() - 2); // todo check if correct
//            }
//            else{
//                // it's a var name
//                // check if the var exists:
//                if(table.containsKey(value)){
//                    // there is a var with this name
//                    if(table.get(value).getType() == ESymbolType.STRING){
//                        // it is also a string
//                        // check if it's too long:
//                        if(table.get(value).getSizeArr() > s.getSizeArr()){
//                            // the string is longer than what the string was declared for
//                            Error.printStringTooLong(s.getName(), value);
//                        }
//
//                        // else proceed
//                        for(int i = 0; i < table.get(value).getSizeArr(); i++){
//                            generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, (int)table.get(value).getValue().charAt(i)));
//                            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i));
//                        }
//                        actualVal = table.get(value).getValue();
//                    }
//                    else{
//                        // print cannot assign num to string
//                    }
//                }
//            }

            s.setValue(actualVal);
            return generatedInstructions;
        }

        // took care of strings ^^
        // try to parse the value as expression:
        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(value, table);
        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);
                Symbol os1 = oper.getSymbol1();
                Symbol os2 = oper.getSymbol2();

                // todo is this correct?
                if(os1.isNegateValue()){
                    if(os1.getType() == ESymbolType.ARRAY){
                        os1.setValue("" + os1.getArrayElements().get(os1.getIndToArray()));
                        os1.setValue("" + os1.negate());
                        os1.setAdr(-1);
                        os1.setType(ESymbolType.INT);

                    }
                    else{
                        os1.setValue("" + os1.negate());
                        os1.setAdr(-1);
                        os1.setType(ESymbolType.INT);
                    }
                }
                if(os2.isNegateValue()){
                    if(os2.getType() == ESymbolType.ARRAY){
                        os2.setValue("" + os2.getArrayElements().get(os2.getIndToArray()));
                        os2.setValue("" + os2.negate());
                        os2.setAdr(-1);
                        os2.setType(ESymbolType.INT);

                    }
                    else{
                        os2.setValue("" + os2.negate());
                        os2.setAdr(-1);
                        os2.setType(ESymbolType.INT);
                    }
                }
                if(oper.isNegateResult() || oper.getOperator() == EOperator.OR
                        || oper.getOperator() == EOperator.AND){
                    Symbol newS = new Symbol();
                    newS.setAdr(-1);

                    if(oper.isNegateResult()){
                        newS.setValue("" + oper.getNegatedResult());
                    }
                    else{
                        newS.setValue("" + oper.getResult());
                    }


                    oper = new Operation();
                    oper.setSymbol1(newS);
                    oper.setOperator(null);
                }

                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));

                //System.out.println("Operation - START");
                //System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
                //System.out.println("Operation - END");
            }
            actualVal = "" + opOrd.get(opOrd.size() - 1).getResult(); // todo negation

            valAtTop = true;
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol; // todo negation
            if(retrSymb != null){
                //if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
                    if(retrSymb.getAdr() == -1){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                    }
                    else{
                        if(retrSymb.getIndToArray() == -1){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            actualVal = retrSymb.getValue();
                        }

                        else{
                            if(retrSymb.getIndToArray() >= s.getSizeArr()){
                                Error.printOutOfBounds(s.getName(), retrSymb.getIndToArray());
                            }

                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            actualVal = "" + retrSymb.getArrayElements().get(retrSymb.getIndToArray());
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
            table.get(s.getName()).setValue(actualVal);
            //s.setValue(actualVal);
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + indexToAssignTo));
            table.get(s.getName()).getArrayElements().set(indexToAssignTo, Integer.parseInt(actualVal));
        }




////        else if(ExpressionParser.isExpression(value)){
////
////            if(s.getType() == ESymbolType.STRING){
////                // cannot store expression in a string - the grammar should take care of this though
////                // keep this if here just in case
////                // Error.printSomething?
////            }
////
////            // get the order of operations
////            ArrayList<Operation> operOrder = ExpressionParser.parseExprDecBool(value, table);
////
////            // generate the arithmetic instructions:
////            for(int i = 0; i < operOrder.size(); i++){
////                Operation oper = operOrder.get(i);
////
////                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));
////
////                //System.out.println("Operation - START");
////                //System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
////                //System.out.println("Operation - END");
////            }
////            actualVal = "" + operOrder.get(operOrder.size() - 1).getResult(); // todo negation
////            valAtTop = true;
////        }
//
//
//        // now we should have the result stored at the top of the stack
//        // assigning to an index of an array:
//        if(indexToAssignTo != -1 && s.getType() == ESymbolType.ARRAY){
//            if(!ExpressionParser.isNumeric(value) && !valAtTop){
//                // variable name?
//                if(table.containsKey(value)){
//                    // there is such a var
//                    if(table.get(value).getType() == ESymbolType.INT || table.get(value).getType() == ESymbolType.BOOL){
//                        // just assign it
//                        if(!valAtTop)
//                            generatedInstructions.add(new Instruction(EInstrSet.LOD, table.get(value).getLev(), (int)value.charAt(0)));
//
//                    }
//                    else{
//                        // todo print something
//                    }
//                }
////                else if(!table.containsKey(value) && !ExpressionParser.isNumeric(value) && !valAtTop){
////
////                }
//            }
//            else if(ExpressionParser.isNumeric(value)){
//
//            }
//        }
//        else if(indexToAssignTo == -1 && s.getType() == ESymbolType.ARRAY){
//            // todo allow pole1 = pole2?
//        }
//
////        else if(ExpressionParser.isNumeric(value)){
////            // normal number
////            actualVal = value;
////        }
////        else {
////            // it's not a number, not a string, not an expression
////            if(table.containsKey(value)){
////                // it's a var name in the
////            }
////        }
//
//
//
//
//
//        if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
//            // first store the value at the top of the stack:
//            // we can be sure the parseInt will be ok, bc it got accepted by the grammar - NO! can be expression^^ or var name
//            if(!valAtTop)
//                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(value)));
//            else{
//                if(!ExpressionParser.isNumeric(value)){
//                    // not a number
//                    if(table.containsKey(value)){
//                        // it is in the table
//
//                    }
//                }
//            }
//
//            // then write the value to the correct address:
//            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr)); // todo is the level true?
//
//
//        }
////        else if(s.getType() == ESymbolType.BOOL){
////            // todo evaluate epression for bool?
////        }
//        else if(s.getType() == ESymbolType.ARRAY /*|| s.getType() == ESymbolType.STRING*/){
////            if(value.length() > 1 && !ExpressionParser.isExpression(value)){
////                // we're assigning to the whole thing
////
////                for(int i = 0; i < value.length(); i++){
////                    if(!valAtTop) // todo ???
////                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(i)));
////
////                    // then write the value to the correct address:
////                    generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i)); // todo is the level true?
////                }
////
////            }
////            else if(value.length() == 1){
//                // we're changing one element in the array
//                if(!valAtTop)
//                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(0)));
//
//                // then write the value to the correct address:
//                generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + indexToAssignTo)); // todo is the level true?
//            }
//        //}
////        else if(s.getType() == ESymbolType.STRING){
////            // todo implement
////        }
//
//
//        // change the value in the symbol table:
//        s.setValue(value);





        return generatedInstructions;
    }

}
