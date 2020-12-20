package compiler.instructions_generators;

import compiler.Operation;
import compiler.EInstrSet;
import compiler.Instruction;

import java.util.ArrayList;

public class IfInstructions {


    public ArrayList<Instruction> generateInstructions(Operation conditionOp){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // condition contains the symbol and the operator

        // store the first number:
        if(conditionOp.getSymbol1().getAdr() == -1){
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(conditionOp.getSymbol1().getValue())));
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, conditionOp.getSymbol1().getLev(), Integer.parseInt(conditionOp.getSymbol1().getValue())));
        }

        // store the second number:
        if(conditionOp.getSymbol1().getAdr() == -1){
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(conditionOp.getSymbol2().getValue())));
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, conditionOp.getSymbol1().getLev(), Integer.parseInt(conditionOp.getSymbol2().getValue())));
        }

        // perform the comparison:
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, conditionOp.getOperator().getInstrCode()));

        // todo decide upon true / not true:
        if(conditionOp.getResult() != 0){
            // true - dont jump anywhere:
        }
        else{
            // jmc when the condition is NOT true
            // todo maybe add this elsewhere when ALL the conditions were evaluated?
            generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -666666)); // todo set the address
        }





        return generatedInstructions;

    }
}
