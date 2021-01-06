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
        int res = IfInstructions.resultVal;

        if(res != 0){
            // now follow instructions for assigning when true:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valTrue, indexToAssignTo, table, true));

            // now follow instructions for assigning when false:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valFalse, indexToAssignTo, table, false));
        }
        else {
            // now follow instructions for assigning when true:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valTrue, indexToAssignTo, table, false));

            // now follow instructions for assigning when false:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valFalse, indexToAssignTo, table, true));
        }






        return generatedInstructions;
    }
}
