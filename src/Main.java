import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;
import visitors.VarAssVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class Main {
    static String testStr = "int s = 456 + 852 * 123 * 123; procedure proc(string s, int r, bool s){int r = 4;} if(i == 4){int c = 5; for(o = 1 to 10){int g = 4;} string s = \"ahoj\"; bool tr = true;} newValue = (i == 4) ? 10 : 20; if(r == 8){c = 4;}int d = 4; bool test[3]; const string s = \"ahoj\"; cislo = porno;";

    public static void main(String[] args){
      
        //Compiler compiler = new Compiler(tree);
        //compiler.compile();

        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr));
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();
        System.out.println("Got number of statements: " + encounteredStatements.size());
        HashMap<Istatement, EallStatementType> statements = parseStatements(encounteredStatements);

        ArrayList<valueEvalDecData> operOrder = parseExprDecBool("100*(2+12)/14");
        for(int i = 0; i < operOrder.size(); i++){
            valueEvalDecData oper = operOrder.get(i);
            System.out.println("Operation - START");
            System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
            System.out.println("Operation - END");
        }

        //got statement list, ok -> parse multiline statements and get its content
        for(int i = 0; i < encounteredStatements.size(); i++){
            Istatement statement = encounteredStatements.get(i); //get one statement

            if(statement instanceof ImultiLineStatement){ //statement is multiline, retrieve its content
                if(statement instanceof procedureDefinition){
                    System.out.println("Got prooc definition! - START");
                    procedureDefinition procDef = (procedureDefinition) statement;

                    System.out.println("Name " + procDef.getIdentifierVar());
                    System.out.println("Params " + procDef.getParameters());
                    System.out.println("Params " + procDef.getOperationType());
                    System.out.println("Got prooc definition! - END");
                }

                ImultiLineStatement multiStatement = (ImultiLineStatement) statement; //cast to multiline
                ArrayList<Istatement> innerStatements = multiStatement.getInnerStatement(); //inner statements included in multiline statement

                System.out.println("Inside: " +statement + " - START");

                HashMap<Istatement, EallStatementType> innerStatementsMap = parseInnerMultiStatement((ImultiLineStatement) statement);

                for(int j = 0; j < innerStatements.size(); j++){
                    System.out.println("Got: " + innerStatementsMap.get(innerStatements.get(j)));
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
    }

    private static ArrayList<valueEvalDecData> parseExprDecBool(String exprDecBool){
        ArrayList<valueEvalDecData> statementOrder = new ArrayList<valueEvalDecData>();

        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)

        Stack<Integer> numbers = new Stack<Integer>(); //stack for retrieved numbers
        Stack<Character> opers = new Stack<Character>(); //stack for retrieved operators

        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators
            if(splitted[i] >= '0' && splitted[i] <= '9'){ //between 0 - 9 -> number
                StringBuffer numBuf = new StringBuffer();

                while(i < splitted.length && splitted[i] >= '0' && splitted[i] <= '9'){ //number can be > 1 char
                    numBuf.append(splitted[i++]);
                }
                numbers.push(Integer.parseInt(numBuf.toString())); //push buffer containing whole number to stack
                i--;
            }else if(splitted[i] == '('){
                opers.push(splitted[i]);
            }else if(splitted[i] == ')'){
                while(opers.peek() != '('){
                    int secondVal = numbers.pop();
                    int firstVal = numbers.pop();
                    Character oper = opers.pop();

                    valueEvalDecData evalSingleOper = new valueEvalDecData();
                    evalSingleOper.setSecondVal(secondVal);
                    evalSingleOper.setOper(oper);
                    evalSingleOper.setFirstVal(firstVal);
                    statementOrder.add(evalSingleOper);

                    numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
                }

                opers.pop();
            }else if(splitted[i] == '+' || splitted[i] == '-' || splitted[i] == '*' || splitted[i] == '/'){ //supported operators
                while (!opers.empty() && checkPrecExprDecBool(splitted[i], opers.peek())){
                    int secondVal = numbers.pop();
                    int firstVal = numbers.pop();
                    Character oper = opers.pop();

                    valueEvalDecData evalSingleOper = new valueEvalDecData();
                    evalSingleOper.setSecondVal(secondVal);
                    evalSingleOper.setOper(oper);
                    evalSingleOper.setFirstVal(firstVal);
                    statementOrder.add(evalSingleOper);

                    numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
                }

                opers.push(splitted[i]);
            }
        }

        while (!opers.empty()){
            int secondVal = numbers.pop();
            int firstVal = numbers.pop();
            Character oper = opers.pop();

            valueEvalDecData evalSingleOper = new valueEvalDecData();
            evalSingleOper.setSecondVal(secondVal);
            evalSingleOper.setOper(oper);
            evalSingleOper.setFirstVal(firstVal);
            statementOrder.add(evalSingleOper);

            numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
        }

        return statementOrder;
    }

    private static boolean checkPrecExprDecBool(char firstOper, char secondOper){
        if(secondOper == '(' || secondOper == ')'){
            return false;
        }else if((firstOper == '*' || firstOper == '/') && (secondOper == '+' || secondOper == '-')){
            return false;
        }else{
            return true;
        }
    }

    private static int singleOpExprDecBool(char oper, int secondNum, int firstNum){
        if(oper == '-'){
            return firstNum - secondNum;
        }else if(oper == '+'){
            return firstNum + secondNum;
        }else if(oper == '*'){
            return firstNum * secondNum;
        }else if(oper == '/') {
            return firstNum / secondNum;
        }else{
            return 0;
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

        ArrayList<Istatement> innerStatements = multiLineStatement.getInnerStatement();

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
}