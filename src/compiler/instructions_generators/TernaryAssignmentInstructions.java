package compiler.instructions_generators;

import compiler.EInstrSet;
import compiler.Instruction;
import compiler.Symbol;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.HashMap;

public class TernaryAssignmentInstructions {
    public static ArrayList<Instruction> generateInstructions(Object st, Symbol s, String cond, String valTrue, String valFalse, int indexToAssignTo, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // let if take care of the condition:
        generatedInstructions.addAll(IfInstructions.generateInstructions(st, cond, globTable, privTable));
        int res = IfInstructions.resultVal;

        if(res != 0){ // true
            //generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 0));
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


        // pokud podminka byla pravdiva
        // OPR ...
        // JMC 20
        // ....
        // 20 ...
// JMC skace kdyz nepravda!



        return generatedInstructions;
    }
}
