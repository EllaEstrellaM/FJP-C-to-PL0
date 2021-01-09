package compiler.instructions_generators;

import compiler.EInstrSet;
import compiler.Instruction;
import compiler.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class takes care of generating PL/0 instructions regarding to ternary assignment.
 */
public class TernaryAssignmentInstructions {
    /**
     * Generates instructions for PL/0 ternary assignment.
     * @param st object which represents ternary assignment
     * @param s corresponding table symbol
     * @param cond condition which should be evaluated
     * @param valTrue value assigned if condition is true
     * @param valFalse value assigned if condition is false
     * @param indexToAssignTo index to which value should be assigned
     * @param globTable global symbol table
     * @param privTable private symbol table
     * @return ternary assignment instructions
     */
    public static ArrayList<Instruction> generateInstructions(Object st, Symbol s, String cond, String valTrue, String valFalse, int indexToAssignTo, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // let if take care of the condition:
        generatedInstructions.addAll(IfInstructions.generateInstructions(st, cond, globTable, privTable));
        int res = IfInstructions.resultVal;

        if(res != 0){ // true
            // now follow instructions for assigning when true:
            generatedInstructions.remove(generatedInstructions.size() - 1);
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 0));
            generatedInstructions.add(new Instruction(st + "JMC"));
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valFalse, indexToAssignTo, globTable,privTable, false));
            generatedInstructions.add(new Instruction(st + "JMC"));

            // now follow instructions for assigning when false:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valTrue, indexToAssignTo, globTable, privTable, true));
        }
        else { // false
            // now follow instructions for assigning when true:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valTrue, indexToAssignTo, globTable,privTable, false));
            generatedInstructions.add(new Instruction(st + "JMC"));

            // now follow instructions for assigning when false:
            generatedInstructions.addAll(VarAssignmentInstructions.generateInstructions(s, valFalse, indexToAssignTo, globTable, privTable,true));
        }
        return generatedInstructions;
    }
}
