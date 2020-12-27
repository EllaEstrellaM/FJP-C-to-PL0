import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;
import visitors.VarAssVisitor;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    static String testStr = "if(i == 4){c = 5; d = 4;} newValue = (i == 4) ? 10 : 20; int d = 4; bool test[3]; const string s = \"ahoj\"; cislo = porno;";

    public static void main(String[] args){
        //System.out.println("jajajja");

        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr));
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();
        System.out.println("Got number of statements: " + encounteredStatements.size());
        HashMap<Istatement, EallStatementType> statements = parseStatements(encounteredStatements);
//        String name = parser.start().children.get(0).getText();
//
//        System.out.println(name);
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

        for (Istatement name: statementTypeMap.keySet()){
            String key = name.toString();
            String value = statementTypeMap.get(name).toString();
            System.out.println("Got: " + key + " " + value);
        }

        System.out.println("Then: " + statementTypeMap.get(encounteredStatements.get(0)));

        return statementTypeMap;
    }
}
