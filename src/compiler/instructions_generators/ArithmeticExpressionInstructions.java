package compiler.instructions_generators;

import compiler.*;
import compiler.Compiler;

import java.util.ArrayList;

public class ArithmeticExpressionInstructions {

    public static ArrayList<Instruction> generateInstructions(Operation op/*, Symbol symbToStoreTo*/){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();




//        if(op.getOperator() == null){
//            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue()))); // adding just the result...
//            return generatedInstructions;
//        }




        // if symbToStoreTo has address -1, use LIT

        // get the correct addresses:
        int adr1 = -1;
        if(op.getSymbol1().getType() == ESymbolType.ARRAY){
            adr1 = op.getSymbol1().getAdr() + op.getSymbol1().getIndToArray();
        }
        else{
            adr1 = op.getSymbol1().getAdr();
        }


        int adr2 = -1;
        if(op.getSymbol2().getType() == ESymbolType.ARRAY){
            adr2 = op.getSymbol2().getAdr() + op.getSymbol2().getIndToArray();
        }
        else{
            adr2 = op.getSymbol2().getAdr();
        }



        // store the first number:
        if(!op.getSymbol1().isPartialResult()){


            if(op.getSymbol1().getAdr() == -1){
                if(!op.getSymbol1().isNegateValue()){
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue())));
                }
                else{
                    // todo negation
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue())));
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                }

            }
            else{
                if(!op.getSymbol1().isNegateValue()){
                    generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr1));
                }
                else{
                    // todo negation
                    generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr1));
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                }

            }
        }

        // store the second number:
        if(!op.getSymbol2().isPartialResult()){
            if(op.getSymbol2().getAdr() == -1){
                if(!op.getSymbol2().isNegateValue()){
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol2().getValue())));
                }
                else{
                    // todo negation
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol2().getValue())));
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                }

            }
            else{
                if(!op.getSymbol2().isNegateValue()){
                    generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr2));
                }
                else{
                    // todo negation
                    generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr2));
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                    generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                }

            }
        }

        // perform the operation:
        if(op.getOperator().getInstrCode() != -1){

            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, op.getOperator().getInstrCode()));
        }
        else{
            // todo maybe this needs to be done in a more complicated way?
            if(op.getOperator() == EOperator.AND){
                // sum of last 2 values must be 2 (both are 1)
                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 2));
                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.EQUAL.getInstrCode()));
            }
            else if(op.getOperator() == EOperator.OR){
                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 0));
                generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.NOT_EQUAL.getInstrCode()));
            }
//            else if(op.getOperator() == EOperator.NEG){
//
//            }

            //generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, op.getResult())); // adding just the result...
        }


        // checking if the result needs to be negated:
        if(op.isNegateResult()){
            // todo negate result
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));

        }






        //int resToStore = op.getResult();
        //generatedInstructions.add(new Instruction(EInstrSet.STO, 0, resToStore)); // todo

        // then store it in the symbol or in stack
//        if(symbToStoreTo.getAdr() == -1){
//
//            // put it to stack
//            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, resToStore));
//        }
//        else{
//            // todo we dont have to push it to stack at all?
//            symbToStoreTo.setValue("" + resToStore);
//        }


        // now there should be the whole result at the top of the stack
        return generatedInstructions;

    }

}
