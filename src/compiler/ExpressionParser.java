package compiler;

import compiler.errors.Error;
import compiler.instructions_generators.ArithmeticExpressionInstructions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Class contains methods which are useful for expression parsing.
 */
public class ExpressionParser {
    public static Symbol retrievedSymbol = null;
    public static boolean setInGlobal = false;

    /**
     * Checks whether value is an expression.
     * @param value string which should be evaluated
     * @return true if expression, else false
     */
    public static boolean isExpression(String value){
        return value.contains("+") || value.contains("-") || value.contains("*") ||
                value.contains("/") || value.contains("%") || value.contains("(") || value.contains(")")
                || value.contains("|") || value.contains("&")
                || value.contains("<") || value.contains("<=") || value.contains(">") || value.contains(">=") || value.contains("==") || value.contains("!=");
    }

    /**
     * Checks whether value is an operator.
     * @param value string which should be evaluated
     * @return true if operator, else false
     */
    private static boolean isOperator(String value){
        return value.equals("+") || value.equals("-") || value.equals("*") ||
                value.equals("/") || value.equals("%")
                || value.equals("|") || value.equals("&")
                || value.equals("<") || value.equals("=") || value.equals(">");
    }

    /**
     * Checks whether value is numeric.
     * @param str string which should be evaluated
     * @return true if numeric, else false
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Checks whether value is true or false.
     * @param str string which should be evaluated
     * @return 1 if true ; 0 if false
     */
    private static int isTrueFalse(String str){
        if(str.equals("true")){
            return 1;
        }
        else if(str.equals("false")){
            return 0;
        }
        return -1;
    }

    /**
     * Returns array of instructions which lead to expression solving.
     * @param expression expression to be evaluated
     * @param globTable global symbol table
     * @param privTable private symbol table
     * @return PL/0 instructions which solve expression
     */
    public static ArrayList<Instruction> solveExpr(String expression, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();
        // perform arithmetics on the condition and let it store the result at the top of the stack:
        // there will be no strings
        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(expression, globTable, privTable);
        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);
                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));
            }
            if(opOrd.get(opOrd.size() - 1).isNegateResult()){

            }
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol;
            if(retrSymb != null){
                if(retrSymb.getAdr() == -1){
                    if(!retrSymb.isNegateValue()){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                    }
                    else{
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                    }

                }
                else{
                    if(retrSymb.getIndToArray() == -1){
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                        }
                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                        }
                    }

                    else{
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                        }
                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                        }

                    }

                }
            }
            else{

            }
        }

        return generatedInstructions;
    }

    /**
     * Parses given expression and returns corresponding PL/0 instructions.
     * @param exprDecBool expression specified by user
     * @param globTable global symbol table
     * @param privTable private symbol table
     * @return PL/0 instructions
     */
    public static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable) {
        ArrayList<Operation> statementOrder = new ArrayList<Operation>();

        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)

        Stack<Symbol> numbers = new Stack<Symbol>(); //stack for retrieved numbers
        Stack<String> opers = new Stack<String>(); //stack for retrieved operators

        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators
            if(!isOperator("" + splitted[i]) && splitted[i] != '(' && splitted[i] != ')' && !(splitted[i] == '!' && splitted[i + 1] == '(') && !(splitted[i] == '!' && splitted[i + 1] == '=')      /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //between 0 - 9 -> number
                String numBuf = "";

                while(i < splitted.length && !isOperator("" + splitted[i]) && splitted[i] != '(' && splitted[i] != ')' && !(splitted[i] == '!' && splitted[i + 1] == '(') && !(splitted[i] == '!' && splitted[i + 1] == '=')      /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //number can be > 1 char
                    numBuf += splitted[i++];

                }

                boolean negateValue = false;
                if(numBuf.length() > 0){
                    if(numBuf.charAt(0) == '!'){
                        negateValue = true;
                        numBuf = numBuf.substring(1);
                    }
                }

                int indToArr = -1;
                if(numBuf.charAt(numBuf.length() - 1) == ']'){
                    // array
                    indToArr = Integer.parseInt(numBuf.substring(numBuf.indexOf("[") + 1, numBuf.indexOf("]")));
                    numBuf = numBuf.substring(0, numBuf.indexOf("["));
                }

                if(privTable.containsKey(numBuf)){ // check the private table first
                    if(privTable.get(numBuf).hasBeenDeclared()){
                        Symbol s = new Symbol(privTable.get(numBuf)); // deep copy of the symbol
                        s.setNegateValue(negateValue);
                        s.setIndToArray(indToArr); // ???

                        numbers.push(s); //push buffer containing whole number to stack
                        setInGlobal = false;
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString());
                    }
                }
                else if(globTable.containsKey(numBuf.toString())){ // then check the global
                    if(globTable.get(numBuf.toString()).hasBeenDeclared()){
                        Symbol s = new Symbol(globTable.get(numBuf)); // deep copy of the symbol
                        s.setNegateValue(negateValue);
                        s.setIndToArray(indToArr);
                        numbers.push(s); //push buffer containing whole number to stack
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString());
                    }
                }
                else{
                    if(isNumeric(numBuf.toString())){
                        Symbol s = new Symbol();
                        s.setValue(numBuf.toString());
                        s.setAdr(-1);
                        s.setNegateValue(negateValue);
                        numbers.push(s);
                    }
                    else if(isTrueFalse(numBuf.toString()) != -1){
                        int value = isTrueFalse(numBuf.toString());
                        Symbol s = new Symbol();
                        s.setValue("" + value);
                        s.setAdr(-1);
                        s.setNegateValue(negateValue);
                        numbers.push(s);
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString());
                    }
                }
                i--;
            }
            else if(splitted[i] == '(' || (splitted[i] == '!' && splitted[i + 1] == '(')){
                if(splitted[i] == '!' && splitted[i + 1] == '('){
                    opers.push("" + splitted[i] + "" + splitted[i + 1]);
                    i++;
                }
                else{
                    opers.push("" + splitted[i]);
                }

            }
            else if(splitted[i] == ')'){
                while(!opers.peek().equals("(") && !opers.peek().equals("!(")){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    String oper = opers.pop();

                    Operation op = new Operation();
                    op.setSymbol1(firstVal);
                    op.setSymbol2(secondVal);
                    op.setOperator(EOperator.getOperFromString("" + oper));
                    statementOrder.add(op);

                    Symbol s = new Symbol();
                    s.setAdr(-1);
                    s.setValue("" + op.getResult());
                    s.setPartialResult(true);
                    numbers.push(s);

                }

                if(opers.peek().equals("!(")){
                    statementOrder.get(statementOrder.size() - 1).setNegateResult(true);
                }
                opers.pop();
            }
            else if(isOperator("" + splitted[i]) || (isOperator("" + splitted[i]) && isOperator("" + splitted[i+1]) ||
                    (splitted[i] == '!' && splitted[i+1] == '='))){ //supported operators

                while (!opers.empty() && checkPrecExprDecBool(splitted[i], opers.peek())){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    String oper = opers.pop();

                    Operation op = new Operation();
                    op.setSymbol1(firstVal);
                    op.setSymbol2(secondVal);
                    op.setOperator(EOperator.getOperFromString("" + oper));
                    statementOrder.add(op);

                    Symbol s = new Symbol();
                    s.setAdr(-1);
                    s.setValue("" + op.getResult());
                    s.setPartialResult(true);
                    numbers.push(s);
                }

                if(isOperator("" + splitted[i + 1])){
                    opers.push("" + splitted[i] + "" + splitted[i+1]);
                    i++;
                }
                else{
                    opers.push("" + splitted[i]);
                }

            }
        }

        while (!opers.empty()){
            Symbol secondVal = numbers.pop();
            Symbol firstVal = numbers.pop();
            String oper = opers.pop();

            Operation op = new Operation();
            op.setSymbol1(firstVal);
            op.setSymbol2(secondVal);
            op.setOperator(EOperator.getOperFromString("" + oper));
            statementOrder.add(op);

            Symbol s = new Symbol();
            s.setAdr(-1);
            s.setValue("" + op.getResult());
            s.setPartialResult(true);
            numbers.push(s);
        }

        if(statementOrder.size() == 0 && numbers.size() == 1){
            // no operation and one symbol
            Symbol s = numbers.pop();

            retrievedSymbol = s;
        }

        return statementOrder;
    }

    /**
     * Checks precedence of two given operators.
     * @param firstOper first operator
     * @param secondOper second operator
     * @return true if operator should be before, else false
     */
    private static boolean checkPrecExprDecBool(char firstOper, String secondOper){
        if(secondOper.equals("(") || secondOper.equals(")") || secondOper.equals("!(")){
            return false;
        }else if((firstOper == '*' || firstOper == '/') && (secondOper.equals("+") || secondOper.equals("-") || secondOper.equals("|") || secondOper.equals("&")
                || secondOper.equals("<") || secondOper.equals("<=") || secondOper.equals(">") || secondOper.equals(">=") || secondOper.equals("==") || secondOper.equals("!="))){
            return false;
        }else{
            return true;
        }
    }

}
