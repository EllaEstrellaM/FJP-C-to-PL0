package compiler;

import compiler.errors.Error;
import compiler.instructions_generators.IfInstructions;
import compiler.instructions_generators.VarAssignmentInstructions;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Compiler {
    private static int stackPointer;
    //private HashSet<Symbol> symbolTable;
    private HashMap<String, Symbol> globalSymbolTable;
    //private ParseTree tree;
    private ArrayList<Istatement> statements;
    private ArrayList<procedureDefinition> procedureDefinitions;
    ArrayList<Instruction> instructions;


    private final int BASE_ADDRESS = 3;
    int declCounter = BASE_ADDRESS;


    public Compiler(ArrayList<Istatement> statements){
        globalSymbolTable = new HashMap<String, Symbol>();
        this.procedureDefinitions = new ArrayList<>();
        this.statements = statements;

    }

    public ArrayList<Instruction> compile(){
        this.instructions = new ArrayList<Instruction>();

        // this instruction will always be the first one?
        // todo or can the address be other than 1?
        Instruction firstI = new Instruction(EInstrSet.JMP, 0,1);

        // todo then increase the stack 'size' by how much?
        // todo 3 + as_many_as_we_have_variables?
        Instruction secondI = new Instruction(EInstrSet.INT, 0, 3);

        instructions.add(firstI);
        instructions.add(secondI);

        // 1. fill the symbol table with 'global' things:
        String proc = "global";
        for(Istatement st : statements){
            if(st instanceof IDeclaration){
                resolveDeclaration((IDeclaration) st, proc, globalSymbolTable);
                //declCounter++;
            }
//            if(st instanceof ImultiLineStatement){
//                resolveMultilineStatement((ImultiLineStatement) st);
//            }
//            else if(st instanceof IoneLineStatement){
//                ;;
//            }
        }

        HashMap<Istatement, EallStatementType> statementType = parseStatements(statements); //got statement list, ok -> parse them and get its content
        for(int i = 0; i < statements.size(); i++){ //go through retrieved statements
            Istatement statement = statements.get(i); //get one statement

            if(statement instanceof ImultiLineStatement){ //statement is multiline, retrieve its content
                ImultiLineStatement multiStatement = (ImultiLineStatement) statement; //cast to multiline

                if(multiStatement instanceof ifCondition){
                    ifCondition ic = (ifCondition) multiStatement;
                    String value = ic.getExprDecBoolCont();
                    this.instructions.addAll(IfInstructions.generateInstructions(value, globalSymbolTable));
                }

                solvRecurMultiLine(multiStatement);
            }else{ //statement is oneline - generate respective instructions
                generateOneline((IoneLineStatement) statement, statementType);


                if(statement instanceof unknownAssign){
                    unknownAssign ua = (unknownAssign)statement;
                    String ident = ua.getIdentifierVar();
                    String value = ua.getValueVar();

                    if(globalSymbolTable.containsKey(ident)){

                        Symbol s = globalSymbolTable.get(ident);

                        this.instructions.addAll(VarAssignmentInstructions.generateInstructions(s, value, -1, globalSymbolTable));
                    }
                    else{
                        Error.printVarNotFound(ident);
                    }
                }
                else if(statement instanceof unknownArrAssign){
                    unknownArrAssign uaa = (unknownArrAssign) statement;
                    String ident = uaa.getIdentifierVar();
                    String value = uaa.getValueVar();
                    int indexToAssignTo = uaa.getIndexToAssign();


                    if(globalSymbolTable.containsKey(ident)){

                        Symbol s = globalSymbolTable.get(ident);


                        if(indexToAssignTo >= s.getSizeArr()){
                            Error.printOutOfBounds(ident, indexToAssignTo);
                        }


                        this.instructions.addAll(VarAssignmentInstructions.generateInstructions(s, value, indexToAssignTo, globalSymbolTable));
                    }
                    else{
                        Error.printVarNotFound(ident);
                    }
                }
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


    private ArrayList<Instruction> generateInstructionsForProcedure(procedureDefinition pd){
        ArrayList<Instruction> instructions = new ArrayList<>();

        String currProcName = pd.getIdentifierVar();

        for(Istatement pdSt : pd.getInnerStatements()){
            if(pdSt instanceof IDeclaration){
                resolveDeclaration((IDeclaration) pdSt, currProcName, pd.getPrivateSymbolTable()); // todo merge the private and global table?
            }
        }

        return instructions;
    }



    private void resolveOneLineStatement(IoneLineStatement st, String inWhichProc){
        if(st instanceof IDeclaration){

//            if(parentSt != null){
//                if(parentSt instanceof procedureDefinition){
//                    inWhichProc = ((procedureDefinition) parentSt).getIdentifierVar();
//                }
//            }

            //resolveDeclaration((IDeclaration) st, inWhichProc);
        }
    }

//    String currProc = "";
//    private void resolveMultilineStatement(ImultiLineStatement st){
//
//
//        if(st instanceof procedureDefinition){
//            currProc = ((procedureDefinition) st).getIdentifierVar();
//        }
//
//        for(int i = 0; i < st.getInnerStatements().size(); i++){
//            if(st.getInnerStatements().get(i) instanceof IoneLineStatement){
//                resolveOneLineStatement((IoneLineStatement) st.getInnerStatements().get(i), currProc);
//            }
//            else{
//                // recursion?
//                resolveMultilineStatement((ImultiLineStatement) st.getInnerStatements().get(i));
//            }
//        }
//    }


    /**
     * Adds new symbol to the table
     * @param st
     */
    private void resolveDeclaration(IDeclaration st, String inProc, HashMap<String, Symbol> symbolTable){
        Symbol symb = new Symbol();
        String name = null;

        // normal declarations:
        if(st instanceof intDeclaration){
            name = ((intDeclaration) st).getIdentifierVar();
            String value = /*(((intDeclaration) st).isMinus_sign() ? "-" : "") + */((intDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0); // todo ???
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
            symb.setLev(0); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof stringDeclaration){ // todo addresses
            name = ((stringDeclaration) st).getIdentifierVar();
            String value = ((stringDeclaration) st).getStringVal();
            int size = value.length() - 2;

            symb.setValue(value);
            symb.setName(name);
            symb.setSizeArr(size);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0); // todo ???
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
            symb.setLev(0); // todo ???
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
            symb.setLev(0); // todo ???
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
            symb.setLev(0); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constIntDeclaration){
            name = ((constIntDeclaration) st).getIdentifierVar();
            String value = /*(((constIntDeclaration) st).isMinus_sign() ? "-" : "") + */((constIntDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(0); // todo ???
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constStringDeclaration){
            name = ((constStringDeclaration) st).getIdentifierVar();
            String value = ((constStringDeclaration) st).getStringVal();
            int size = value.length() - 2;

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(0); // todo ???
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
            symb.setLev(0); // todo ???
            symb.setType(ESymbolType.PROCEDURE);
            symb.setInProcedure(inProc); // todo we probably dont support nested procedures anyway
            //declCounter++; // todo???

            procedureDefinitions.add((procedureDefinition)st);
        }

        //globalSymbolTable.put(name, symb);

        if(symbolTable.containsKey(name)){
            Error.printMultipleDefines(name);
        }

        symb.setHasBeenDeclared(false);
        symbolTable.put(name, symb);
        if(!(st instanceof arrBoolDeclaration) && !(st instanceof arrIntDeclaration)){
            // array declaration doesn't produce any instructions
            this.instructions.addAll(VarAssignmentInstructions.generateInstructions(symb, symb.getValue(), -1, symbolTable));
        }


        symb.setHasBeenDeclared(true);
    }

    /**
     * Accepts one multiline statement (implements ImultiLineStatement) for which PL0 instructions should be generated. Contains recursive logic to get individual oneline statements.
     * @param statement instance which represents multiline statement (implements ImultiLineStatement)
     */
    private static void solvRecurMultiLine(ImultiLineStatement statement){
        ArrayList<Istatement> innerStatements = statement.getInnerStatements(); //inner statements included in multiline statement
        HashMap<Istatement, EallStatementType> innerStatementType = parseStatements(innerStatements); //type of inner statements included in multiline statement

        for(int j = 0; j < innerStatements.size(); j++){ //go thru inner statements of multiline
            Istatement innerStatement = innerStatements.get(j); //get one inner statement

            if(innerStatement instanceof ImultiLineStatement){//inner statement could be multi -> recursive call to retrieve oneline
                ImultiLineStatement multiStatement = (ImultiLineStatement) innerStatement; //cast to multiline
                solvRecurMultiLine(multiStatement); //recursive call
            }else{//inner statement is oneline -> solve it
                generateOneline((IoneLineStatement) innerStatement, innerStatementType);
            }
        }
    }

    /**
     * Accepts one oneline statement (implements IoneLineStatement) for which we then generate PL0 instructions.
     * @param statement instance which represents oneline statement (implements IoneLineStatement)
     * @param statementType HashMap contains concrete type of oneline statement (ie.STRING_DECLARATION and so on)
     */
    private static void generateOneline(IoneLineStatement statement, HashMap<Istatement, EallStatementType> statementType){
        if(statementType.get(statement) == EallStatementType.ARR_BOOL_ASSIGN){
            System.out.println("Oneline detected - ARR_BOOL_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.ARR_BOOL_DECLARATION){
            System.out.println("Oneline detected - ARR_BOOL_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.ARR_INT_ASSIGN){
            System.out.println("Oneline detected - ARR_INT_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.ARR_INT_DECLARATION){
            System.out.println("Oneline detected - ARR_INT_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.BOOL_ASSIGN){
            System.out.println("Oneline detected - BOOL_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.BOOL_DECLARATION){
            System.out.println("Oneline detected - BOOL_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.CONST_BOOL_DECLARATION){
            System.out.println("Oneline detected - CONST_BOOL_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.CONST_INT_DECLARATION){
            System.out.println("Oneline detected - CONST_INT_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.CONST_STRING_DECLARATION){
            System.out.println("Oneline detected - CONST_STRING_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.INT_ASSIGN){
            System.out.println("Oneline detected - INT_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.INT_DECLARATION){
            System.out.println("Oneline detected - INT_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.PROCEDURE_CALL){
            System.out.println("Oneline detected - PROCEDURE_CALL");
        }else if(statementType.get(statement) == EallStatementType.STRING_ASSIGN){
            System.out.println("Oneline detected - STRING_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.STRING_DECLARATION){
            System.out.println("Oneline detected - STRING_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.UNKNOWN_ARR_ASSIGN){
            System.out.println("Oneline detected - UNKNOWN_ARR_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.UNKNOWN_ASSIGN){
            System.out.println("Oneline detected - UNKNOWN_ASSIGN");
        }else if(statementType.get(statement) == EallStatementType.BOOL_TERNAR_DECLARATION){
            System.out.println("Oneline detected - BOOL_TERNAR_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.INT_TERNAR_DECLARATION){
            System.out.println("Oneline detected - INT_TERNAR_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.STRING_TERNAR_DECLARATION){
            System.out.println("Oneline detected - STRING_TERNAR_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.CONST_ARR_BOOL_DECLARATION){
            System.out.println("Oneline detected - CONST_ARR_BOOL_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.CONST_ARR_INT_DECLARATION){
            System.out.println("Oneline detected - CONST_ARR_INT_DECLARATION");
        }else if(statementType.get(statement) == EallStatementType.TERNAR_ASSIGN){
            System.out.println("Oneline detected - TERNAR_ASSIGN");
        }
    }

    /**
     * Expects ArrayList retrieved from instance of VarAssVisitor, which contains all encountered statements in given code.
     * Returns HashMap in which, key = instance of class which implements Istatement ; value = value from EallStatementType which tells the actual type of key
     * @param encounteredStatements list of statements retrieved from VarAssVisitor
     * @return HashMap, where key = instance of class which implements Istatement ; value = value from EallStatementType which tells the actual type of key
     */
    private static HashMap<Istatement, EallStatementType> parseStatements(ArrayList<Istatement> encounteredStatements){
        HashMap<Istatement, EallStatementType> statementTypeMap = new HashMap<Istatement, EallStatementType>();

        for(int i = 0; i < encounteredStatements.size(); i++){ //go through all statements
            Istatement statement = encounteredStatements.get(i); //get one statement

            if(statement instanceof IoneLineStatement){ //kind of oneline statement
                if(statement instanceof arrBoolAssign){
                    statementTypeMap.put(statement, EallStatementType.ARR_BOOL_ASSIGN);
                }else if(statement instanceof arrBoolDeclaration){
                    statementTypeMap.put(statement, EallStatementType.ARR_BOOL_DECLARATION);
                }else if(statement instanceof arrIntAssign){
                    statementTypeMap.put(statement, EallStatementType.ARR_INT_ASSIGN);
                }else if(statement instanceof arrIntDeclaration){
                    statementTypeMap.put(statement, EallStatementType.ARR_INT_DECLARATION);
                }else if(statement instanceof boolAssign){
                    statementTypeMap.put(statement, EallStatementType.BOOL_ASSIGN);
                }else if(statement instanceof boolDeclaration){
                    statementTypeMap.put(statement, EallStatementType.BOOL_DECLARATION);
                }else if(statement instanceof constBoolDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_BOOL_DECLARATION);
                }else if(statement instanceof constIntDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_INT_DECLARATION);
                }else if(statement instanceof constStringDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_STRING_DECLARATION);
                }else if(statement instanceof intAssign){
                    statementTypeMap.put(statement, EallStatementType.INT_ASSIGN);
                }else if(statement instanceof intDeclaration){
                    statementTypeMap.put(statement, EallStatementType.INT_DECLARATION);
                }else if(statement instanceof procedureCall){
                    statementTypeMap.put(statement, EallStatementType.PROCEDURE_CALL);
                }else if(statement instanceof stringAssign){
                    statementTypeMap.put(statement, EallStatementType.STRING_ASSIGN);
                }else if(statement instanceof stringDeclaration){
                    statementTypeMap.put(statement, EallStatementType.STRING_DECLARATION);
                }else if(statement instanceof unknownArrAssign){
                    statementTypeMap.put(statement, EallStatementType.UNKNOWN_ARR_ASSIGN);
                }else if(statement instanceof unknownAssign){
                    statementTypeMap.put(statement, EallStatementType.UNKNOWN_ASSIGN);
                }else if(statement instanceof boolTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.BOOL_TERNAR_DECLARATION);
                }else if(statement instanceof intTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.INT_TERNAR_DECLARATION);
                }else if(statement instanceof stringTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.STRING_TERNAR_DECLARATION);
                }else if(statement instanceof constArrBoolDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_ARR_BOOL_DECLARATION);
                }else if(statement instanceof constArrIntDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_ARR_INT_DECLARATION);
                }else if(statement instanceof ternarAssign){
                    statementTypeMap.put(statement, EallStatementType.TERNAR_ASSIGN);
                }
            }else if(statement instanceof ImultiLineStatement){ //kind of multiline statement
                if(statement instanceof doWhileCycle){
                    statementTypeMap.put(statement, EallStatementType.DO_WHILE_CYCLE);
                }else if(statement instanceof forCycle){
                    statementTypeMap.put(statement, EallStatementType.FOR_CYCLE);
                }else if(statement instanceof foreachCycle){
                    statementTypeMap.put(statement, EallStatementType.FOREACH_CYCLE);
                }else if(statement instanceof ifCondition){
                    statementTypeMap.put(statement, EallStatementType.IF_CONDITION);
                }else if(statement instanceof procedureDefinition){
                    statementTypeMap.put(statement, EallStatementType.PROCEDURE_DEFINITION);
                }else if(statement instanceof repeatUntilCycle){
                    statementTypeMap.put(statement, EallStatementType.REPEAT_UNTIL_CYCLE);
                }else if(statement instanceof whileCycle){
                    statementTypeMap.put(statement, EallStatementType.WHILE_CYCLE);
                }
            }
        }

        return statementTypeMap;
    }



    private void printSymbolTable(HashMap<String, Symbol> table){

    }
}
