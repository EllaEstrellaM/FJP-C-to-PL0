package compiler.instructions_generators;

import compiler.Instruction;
import compiler.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class TernaryAssignmentInstructions {
    public static ArrayList<Instruction> generateInstructions(Symbol s, String cond, String valTrue, String valFalse, int indexToAssignTo, HashMap<String, Symbol> table){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // let if take care of the condition:
        generatedInstructions.addAll(IfInstructions.generateInstructions(cond, table));

        // now follow instructions for assigning when true:
        VarAssignmentInstructions.generateInstructions(s, valTrue, indexToAssignTo, table); // todo find out which value to assign to the symbol

        // now follow instructions for assigning when false:
        VarAssignmentInstructions.generateInstructions(s, valFalse, indexToAssignTo, table);



        return generatedInstructions;
    }
}
