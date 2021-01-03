package compiler.instructions_generators;

import compiler.*;
import compiler.Compiler;

import java.util.ArrayList;

public class ArithmeticExpressionInstructions {

    // todo negate value and/or result!!!
    public static ArrayList<Instruction> generateInstructions(Operation op/*, Symbol symbToStoreTo*/){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

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
                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue())));
                //generatedInstructions.add(Compiler.generateInstruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue())));
            }
            else{
                generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr1));
            }
        }

        // store the second number:
        if(!op.getSymbol2().isPartialResult()){
            if(op.getSymbol1().getAdr() == -1){
                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol2().getValue())));
            }
            else{
                generatedInstructions.add(new Instruction(EInstrSet.LOD, op.getSymbol1().getLev(), adr2));
            }
        }

        // perform the operation:
        if(op.getOperator().getInstrCode() != -1){

            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, op.getOperator().getInstrCode()));
        }
        else{
            // todo maybe this needs to be done in a more comlicated way?
            if(op.getOperator() == EOperator.AND){

            }
            else if(op.getOperator() == EOperator.OR){

            }
            else if(op.getOperator() == EOperator.NEG){

            }

            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, op.getResult())); // adding just the result...
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
