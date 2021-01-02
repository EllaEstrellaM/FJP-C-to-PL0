import compiler.Compiler;
import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;
import visitors.VarAssVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;


public class Main {
    static String testStr = "const bool pole[29]; bool s = (c < 25) ? true : false; string g = (c < 25) ? \"truuu\" : \"faaals\"; g = (c < 25) ? \"asstrue\" : \"assfalse\"; string testStr = existing;callProc(iAmArgs); int i = exVal; const string ahoj = existuje; int pokus[20]; bool test[4]; while(i < 4 or c > 9){r = 4;} repeat{c = 7;}until(d == 8 or v == 6); procedure proc(int intPar, int intArr[2], string stringPar, string stringArr[4], bool boolPar, string boolArr[3]){innerAssProc = 4;} foreach(i : pole){c = 4;} do{int c = 5;}while(i < 4 and i == 8); if(i == 4 and c == 8){int c = 5; for(o = 1 to 10){if(i == 7){bool r = true;}int g = 4;} string s = \"ahoj\"; bool tr = true;}";
    static String test2 = "int ahoj = 3;";

    public static void main(String[] args){

        String testFile = "test3.txt";
        String filesPath = "testFiles";
        String path = filesPath + File.separator + testFile;

        String content = loadContents(path);

        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr)); //content
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));

        ParseTree tree = null;
        tree = parser.start();

        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();
        System.out.println("Got number of statements: " + encounteredStatements.size());
        HashMap<Istatement, EallStatementType> statements = parseStatements(encounteredStatements);

        // --- expressions ---
//        ArrayList<valueEvalDecData> operOrder = parseExprDecBool("100*(2+12)/14");
//        for(int i = 0; i < operOrder.size(); i++){
//            valueEvalDecData oper = operOrder.get(i);
//            System.out.println("Operation - START");
//            System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
//            System.out.println("Operation - END");
//        }

        //got statement list, ok -> parse multiline statements and get its content
        for(int i = 0; i < encounteredStatements.size(); i++){
            Istatement statement = encounteredStatements.get(i); //get one statement

            if(statement instanceof ImultiLineStatement){ //statement is multiline, retrieve its content
                ImultiLineStatement multiStatement = (ImultiLineStatement) statement; //cast to multiline
                ArrayList<Istatement> innerStatements = multiStatement.getInnerStatements(); //inner statements included in multiline statement

                System.out.println("Inside: " +statement + " - START");

                HashMap<Istatement, EallStatementType> innerStatementsMap = parseInnerMultiStatement((ImultiLineStatement) statement);

                for(int j = 0; j < innerStatements.size(); j++){
                    System.out.println("Got: " + innerStatementsMap.get(innerStatements.get(j)));

                    if(innerStatements.get(j) instanceof forCycle){
                        System.out.println("For instance with " + ((forCycle)((forCycle) innerStatements.get(j))).getIdentifierVar());
                        forCycle forCycle = (forCycle) innerStatements.get(j); //cast to multiline

                        ArrayList<Istatement> innerStatementsd = forCycle.getInnerStatements(); //inner statements included in multiline statement
                        HashMap<Istatement, EallStatementType> innerStatementsMapd = parseInnerMultiStatement((ImultiLineStatement) forCycle);
                        System.out.println("Size is: " + innerStatementsd.size());
                        for(int k = 0; k < innerStatementsd.size(); k++){
                            System.out.println("Got INSIDE FOR: " + innerStatementsMapd.get(innerStatementsd.get(k)));
                        }
                    }
                }

                System.out.println("Inside: " +statement + " - END");
            }
            if(statement instanceof intDeclaration){
                System.out.println("Got int declaration! - START");
                intDeclaration intDec = (intDeclaration) statement;
                System.out.println("Dec val: " + intDec.getDecVal());

                System.out.println("Got int declaration! - END");
            }

        }

        Compiler compiler = new Compiler(encounteredStatements);
        compiler.compile();
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

    /**
     * Takes multiline statement reference and returns HashMap with its content.
     * @param multiLineStatement instance of class which implements ImultiLineStatement
     * @return HashMap in which key = instance of class which implements Istatement ; value = value from EallStatementType which tells the actual type of key
     */
    private static HashMap<Istatement, EallStatementType> parseInnerMultiStatement(ImultiLineStatement multiLineStatement){
        HashMap<Istatement, EallStatementType> statementTypeMap = new HashMap<Istatement, EallStatementType>();

        ArrayList<Istatement> innerStatements = multiLineStatement.getInnerStatements();

        for(int i = 0; i < innerStatements.size(); i++){ //go through inner statements
            Istatement statement = innerStatements.get(i); //get one inner statement

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



    private static String loadContents(String filePath)
    {

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }


}