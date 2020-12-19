package compiler;

import org.antlr.v4.runtime.tree.ParseTree;
import visitors.VarDeclarationVisitor;

import java.util.ArrayList;
import java.util.HashSet;

public class Compiler {
    private int stackPointer;
    private HashSet<Symbol> symbolTable;
    private ParseTree tree;

    public Compiler(ParseTree tree){
        symbolTable = new HashSet<Symbol>();
        this.tree = tree;
    }

    public ArrayList<Instruction> compile(){
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();

        // this instruction will always be the first one?
        // todo or can the address be other than 1?
        Instruction firstI = new Instruction(EInstrSet.JMP, 0,1);

        // todo then increase the stack 'size' by how much?
        // todo 3 + as_many_as_we_have_variables?
        Instruction secondI = new Instruction(EInstrSet.INT, 0, 3);

        instructions.add(firstI);
        instructions.add(secondI);

        VarDeclarationVisitor vdv = new VarDeclarationVisitor();
        Symbol s = vdv.visit(tree); // todo - returns null
        //s.printInfo();

        // the last but not least return instruction
        Instruction lastI = new Instruction(EInstrSet.RET, 0, 0);
        instructions.add(lastI);


        return instructions;
    }


}
