package compiler;

import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.IDeclaration;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Compiler {
    private static int stackPointer;
    //private HashSet<Symbol> symbolTable;
    private HashMap<String, Symbol> symbolTable;
    private ParseTree tree;
    private ArrayList<Istatement> statements;

//    public Compiler(ParseTree tree){
//        //symbolTable = new HashSet<Symbol>();
//        symbolTable = new HashMap<String, Symbol>();
//        this.tree = tree;
//    }


    private final int BASE_ADDRESS = 3;

    int declCounter = BASE_ADDRESS;

    public Compiler(ArrayList<Istatement> statements){
        symbolTable = new HashMap<String, Symbol>();
        this.statements = statements;
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

        // fill the symbol table with 'global' things:
        String proc = "global";
        for(Istatement st : statements){
            if(st instanceof IDeclaration){
                resolveDeclaration((IDeclaration) st, proc);
                //declCounter++;
            }
            if(st instanceof ImultiLineStatement){
                resolveMultilineStatement((ImultiLineStatement) st);
            }
            else if(st instanceof IoneLineStatement){

            }
        }


        // the last but not least return instruction
        Instruction lastI = new Instruction(EInstrSet.RET, 0, 0);
        instructions.add(lastI);



        return instructions;
    }

    public static Instruction generateInstruction(EInstrSet instr, int par1, int par2){

        switch (instr){
            case INT:
                stackPointer += par2;
                break;
            case LIT: case LOD:
                stackPointer++;
                break;
            case STO: case OPR: case JMC:
                stackPointer--;
                break;
        }

        Instruction newInstr = new Instruction(instr, par1, par2);
        return newInstr;

    }



    private void resolveOneLineStatement(IoneLineStatement st, ImultiLineStatement parentSt){
        if(st instanceof IDeclaration){
            String inWhichProc = "global";
            if(parentSt != null){
                if(parentSt instanceof procedureDefinition){
                    inWhichProc = ((procedureDefinition) parentSt).getIdentifierVar();
                }
            }

            resolveDeclaration((IDeclaration) st, inWhichProc);
        }
    }

    private void resolveMultilineStatement(ImultiLineStatement st){
//        if(st instanceof procedureDefinition){
//
//        }

        for(int i = 0; i < st.getInnerStatement().size(); i++){
            if(st.getInnerStatement().get(i) instanceof IoneLineStatement){

            }
        }
    }


    /**
     * Adds new symbol to the table
     * @param st
     */
    private void resolveDeclaration(IDeclaration st, String inProc){
        // --- DECLARATIONS START: ---
        Symbol symb = new Symbol();
        String name = null;

        // normal declarations:
        if(st instanceof intDeclaration){
            name = ((intDeclaration) st).getIdentifierVar();
            String value = (((intDeclaration) st).isMinus_sign() ? "-" : "") + ((intDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof boolDeclaration){
            name = ((boolDeclaration) st).getIdentifierVar();
            String value = ((boolDeclaration) st).getBoolVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof stringDeclaration){
            name = ((stringDeclaration) st).getIdentifierVar();
            String value = ((stringDeclaration) st).getStringVal();
            int size = value.length();

            symb.setValue(value);
            symb.setName(name);
            symb.setSizeArr(size);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;

        }
        // arrays declarations:
        else if(st instanceof arrBoolDeclaration){
            name = ((arrBoolDeclaration) st).getIdentifierVar();
            int size = ((arrBoolDeclaration) st).getDecNum();
            //String value = "";

            //symb.setValue(value);
            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+= size;
        }
        else if(st instanceof arrIntDeclaration){
            name = ((arrIntDeclaration) st).getIdentifierVar();
            int size = ((arrIntDeclaration) st).getDecNum();
            //String value = "";

            //symb.setValue(value);
            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+=size;
        }

        // consts declaration:
        else if(st instanceof constBoolDeclaration){
            name = ((constBoolDeclaration) st).getIdentifierVar();
            String value = ((constBoolDeclaration) st).getBoolVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constIntDeclaration){
            name = ((constIntDeclaration) st).getIdentifierVar();
            String value = (((constIntDeclaration) st).isMinus_sign() ? "-" : "") + ((constIntDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constStringDeclaration){
            name = ((constStringDeclaration) st).getIdentifierVar();
            String value = ((constStringDeclaration) st).getStringVal();
            int size = value.length();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;
        }
        else if(st instanceof procedureDefinition){
            name = ((procedureDefinition) st).getIdentifierVar();
            String params = ((procedureDefinition) st).getParameters();

            symb.setName(name);
            symb.setProcParameters(params);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.PROCEDURE);
            symb.setInProcedure(inProc); // todo we probably dont support nested procedures anyway
            declCounter++; // todo???
        }

        symbolTable.put(name, symb);
        // --- DECLARATIONS END ---
    }


}
