package statementDefMultiLine;

import compiler.ESymbolType;
import compiler.Instruction;
import compiler.Symbol;
import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.HashMap;

public class procedureDefinition implements Istatement, ImultiLineStatement, IDeclaration {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW procedure
    String parameters; //contains parameters (content in brackets after procedure name)
    /* relevant statement info to keep - END */

    private HashMap<String, Symbol> privateSymbolTable;
    private ArrayList<Symbol> args;
    private ArrayList<Instruction> instructions;

    public procedureDefinition(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();
        innerLevel = 0;

        identifierVar = "";
        parameters = "";

        privateSymbolTable = new HashMap<>();
        args = new ArrayList<>();
        instructions = new ArrayList<>();
    }

    public ArrayList<Symbol> getIndivParameters(){
        String[] splits = parameters.split(",");
        ArrayList<Symbol> as = new ArrayList<>();

//        if(splits.length == 1 && splits[0].equals("")){
//            return null; // todo?
//        }

        System.out.println("params:");
        for(int i = 0; i < splits.length; i++){
            System.out.println(splits[i]);

            Symbol s = new Symbol();
            if(splits[i].startsWith("int ")){
                s.setType(ESymbolType.INT);
                s.setName(splits[i].substring(4));
                as.add(s);
            }
            else if(splits[i].startsWith("bool ")){
                s.setType(ESymbolType.BOOL);
                s.setName(splits[i].substring(5));
                as.add(s);
            }
//            else if(splits[i].startsWith("string ")){
//                s.setType(ESymbolType.BOOL);
//                s.setName(splits[i].substring(7));
//            }


        }

        return as;
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.PROCEDURE_DEFINITION;
    }

    @Override
    public EmultiLineStatementType getOperationType() {
        return operationType;
    }

    @Override
    public void setWholeContent(String content) {
        this.wholeContent = content;
    }

    @Override
    public String getWholeContent() {
        return this.wholeContent;
    }

    @Override
    public void addInnerStatement(Istatement statement) {
        this.innerStatementsList.add(statement);
    }

    @Override
    public ArrayList<Istatement> getInnerStatements() {
        return innerStatementsList;
    }

    public String getIdentifierVar() {
        return identifierVar;
    }

    public void setIdentifierVar(String identifierVar) {
        this.identifierVar = identifierVar;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public HashMap<String, Symbol> getPrivateSymbolTable() {
        return privateSymbolTable;
    }

    public void setPrivateSymbolTable(HashMap<String, Symbol> privateSymbolTable) {
        this.privateSymbolTable = privateSymbolTable;
    }

    public void addToLocalSymbolTable(String key, Symbol symbol){
        this.privateSymbolTable.put(key, symbol);
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public void setInnerLevel(int level) {
        this.innerLevel = level;
    }

    @Override
    public int getInnerLevel() {
        return innerLevel;
    }

    public ArrayList<Symbol> getArgs() {
        return args;
    }
}
