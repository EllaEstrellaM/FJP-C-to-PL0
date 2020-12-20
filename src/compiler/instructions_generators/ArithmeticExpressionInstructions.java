package compiler.instructions_generators;

import compiler.*;

import java.util.ArrayList;

public class ArithmeticExpressionInstructions {

    public ArrayList<Instruction> generateInstructions(Operation op, Symbol symbToStoreTo){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // if symbToStoreTo has address -1, store at top of stack?


        // store the first number:
        if(op.getSymbol1().getAdr() == -1){
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol1().getValue())));
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, op.getSymbol1().getLev(), Integer.parseInt(op.getSymbol1().getValue())));
        }

        // store the second number:
        if(op.getSymbol1().getAdr() == -1){
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(op.getSymbol2().getValue())));
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, op.getSymbol1().getLev(), Integer.parseInt(op.getSymbol2().getValue())));
        }

        // perform the operation:
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, op.getOperator().getInstrCode()));

        int resToStore = op.getResult();

        // then store it in the symbol or in stack
        if(symbToStoreTo.getAdr() == -1){

            // put it to stack
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, resToStore));
        }
        else{
            // todo we dont have to push it to stack at all?
            symbToStoreTo.setValue("" + resToStore);
        }



        return generatedInstructions;

    }

}
