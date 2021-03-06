package compiler.instructions_generators;

import compiler.*;

import java.util.ArrayList;

/**
 * Performs arithmetic instructions on provided symbols / numbers.
 */
public class ArithmeticExpressionInstructions {
    /**
     * Generates instructions for two specific symbols / numbers.
     * @param op instance of class Operation which contains two numbers and operation, which should be performed
     * @return corresponding instructions
     */
    public static ArrayList<Instruction> generateInstructions(Operation op){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

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
        }

        // checking if the result needs to be negated:
        if(op.isNegateResult()){
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));

        }
        // now there should be the whole result at the top of the stack
        return generatedInstructions;
    }
}
