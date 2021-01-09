package compiler.instructions_generators;

import compiler.*;
import compiler.errors.Error;
import compiler.errors.VarNotFoundException;
import statementDefMultiLine.ifCondition;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.HashMap;

public class IfInstructions {

    public static int resultVal;

    public static ArrayList<Instruction> generateInstructions(Object ifCond, String cond/*Operation conditionOp*/, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable) {
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();


        // perform arithmetics on the condition and let it store the result at the top of the stack:
        // there will be no strings

        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(cond, globTable, privTable);

        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);
                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));

            }
            resultVal = opOrd.get(opOrd.size() - 1).getResult();
            if(opOrd.get(opOrd.size() - 1).isNegateResult()){
                resultVal = opOrd.get(opOrd.size() - 1).getNegatedResult();
            }
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol; // todo negation!!!!
            if(retrSymb != null){
                //if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
                if(retrSymb.getAdr() == -1){
                    if(!retrSymb.isNegateValue()){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                        resultVal = Integer.parseInt(retrSymb.getValue());
                    }
                    else{
                        // todo negation
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                        resultVal = retrSymb.negate();
                    }

                }
                else{
                    if(retrSymb.getIndToArray() == -1){
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            resultVal = Integer.parseInt(retrSymb.getValue());
                        }
                        else{
                            // todo negation
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                            resultVal = retrSymb.negate();
                        }

                    }

                    else{
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            resultVal = retrSymb.getArrayElements().get(retrSymb.getIndToArray());
                        }
                        else{
                            // todo negation
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                            resultVal = retrSymb.negate();

                        }

                    }

                }
                //}
            }
            else{
                System.out.println("weird");
            }
        }


        // now the result is stored at the top
        //generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 0)); // load 0
        //generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.NOT_EQUAL.getInstrCode())); // compare if ne to 0
        //generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); // todo set addr
        generatedInstructions.add(new Instruction(ifCond + "JMC")); //here we should jump to RET





        return generatedInstructions;

    }

    public static ArrayList<Instruction> generateInstructionsEnd(Object st){
        ArrayList<Instruction> generatedInstructions = new ArrayList<>();


        generatedInstructions.add(new Instruction(st + "JMC"));

        return generatedInstructions;
    }

}
