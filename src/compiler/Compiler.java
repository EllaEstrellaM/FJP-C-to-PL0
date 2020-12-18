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

        VarDeclarationVisitor vdv = new VarDeclarationVisitor();
        Symbol s = vdv.visit(tree);
        s.printInfo();

        return instructions;
    }
}
