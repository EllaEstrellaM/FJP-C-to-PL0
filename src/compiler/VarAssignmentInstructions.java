package compiler;

import java.util.ArrayList;

public class VarAssignmentInstructions {

    // todo index when we want to change one element in an array / string
    // todo what should we do, when arr1 = arr2 happens? -> point to the same memory?
    public ArrayList<Instruction> generateInstructions(Symbol s, String value, int index){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        int addr = s.getAdr(); // the address to store the new value to
        int level = s.getLev();

        if(s.getType() == ESymbolType.BOOL || s.getType() == ESymbolType.INT){
            // first store the value at the top of the stack:
            // we can be sure the parseInt will be ok, bc it got accepted by the grammar
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(value)));

            // then write the value to the correct address:
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr)); // todo is the level true?


        }
        else if(s.getType() == ESymbolType.ARRAY){
            // todo implement
        }
        else if(s.getType() == ESymbolType.STRING){
            // todo implement
        }


        // change the value in the symbol table:
        s.setValue(value);

        return generatedInstructions;
    }


}
