package compiler;

import compiler.errors.Error;
import compiler.errors.VarNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExpressionParser {

    public static Symbol retrievedSymbol = null;
    public static boolean setInGlobal = false;


    public static boolean isExpression(String value){

        return value.contains("+") || value.contains("-") || value.contains("*") ||
                value.contains("/") || value.contains("%") || value.contains("(") || value.contains(")")
                || value.contains("|") || value.contains("&") /*|| value.contains("!")*/
                || value.contains("<") || value.contains("<=") || value.contains(">") || value.contains(">=") || value.contains("==") || value.contains("!=")
                /*|| value.contains("!")*/;
    }

    private static boolean isOperator(String value){

        return value.equals("+") || value.equals("-") || value.equals("*") ||
                value.equals("/") || value.equals("%") /*|| value.equals("(") || value.equals(")")*/
                || value.equals("|") || value.equals("&") /*|| value.contains("!")*/
                || value.equals("<") || value.equals("=") || value.equals(">") /*|| value.equals("!")*/;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static int isTrueFalse(String str){
        if(str.equals("true")){
            return 1;
        }
        else if(str.equals("false")){
            return 0;
        }
        return -1;
    }


    public static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable) {
        ArrayList<Operation> statementOrder = new ArrayList<Operation>();

        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)

        Stack<Symbol> numbers = new Stack<Symbol>(); //stack for retrieved numbers
        Stack<String> opers = new Stack<String>(); //stack for retrieved operators

        boolean isOper = false;

        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators

//            if(splitted[i] == '!' && splitted[i+1] != '='){
//
//            }
//            else{
//
//            }
//            isOper = false;
//            if(){
//
//            }

            if(!isOperator("" + splitted[i]) && splitted[i] != '(' && splitted[i] != ')' && !(splitted[i] == '!' && splitted[i + 1] == '(') && !(splitted[i] == '!' && splitted[i + 1] == '=')      /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //between 0 - 9 -> number
                //StringBuffer numBuf = new StringBuffer();
                String numBuf = "";

                while(i < splitted.length && !isOperator("" + splitted[i]) && splitted[i] != '(' && splitted[i] != ')' && !(splitted[i] == '!' && splitted[i + 1] == '(') && !(splitted[i] == '!' && splitted[i + 1] == '=')      /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //number can be > 1 char

                    //numBuf.append(splitted[i++]);
                    numBuf += splitted[i++];

                }

                boolean negateValue = false;
                if(numBuf.length() > 0){
                    if(numBuf.charAt(0) == '!'){
                        negateValue = true;
                        //numBuf = numBuf.replace(0,1,"");
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

                        //globTable.get(numBuf.toString()).setNegateValue(negateValue);
                        s.setNegateValue(negateValue);

                        //globTable.get(numBuf.toString()).setIndToArray(indToArr); // ???
                        s.setIndToArray(indToArr); // ???

                        //numbers.push(globTable.get(numBuf.toString())); //push buffer containing whole number to stack
                        numbers.push(s); //push buffer containing whole number to stack
                        setInGlobal = false;
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
                        //throw new VarNotFoundException(numBuf);
                    }
                }
                else if(globTable.containsKey(numBuf.toString())){ // then check the global

                    if(globTable.get(numBuf.toString()).hasBeenDeclared()){

                        Symbol s = new Symbol(globTable.get(numBuf)); // deep copy of the symbol

                        //globTable.get(numBuf.toString()).setNegateValue(negateValue);
                        s.setNegateValue(negateValue);

                        //globTable.get(numBuf.toString()).setIndToArray(indToArr); // ???
                        s.setIndToArray(indToArr); // ???

                        //numbers.push(globTable.get(numBuf.toString())); //push buffer containing whole number to stack
                        numbers.push(s); //push buffer containing whole number to stack
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
                        //throw new VarNotFoundException(numBuf);
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
                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
                        //throw new VarNotFoundException(numBuf);
                    }

                }
                i--;
            }
            else if(splitted[i] == '(' || (splitted[i] == '!' && splitted[i + 1] == '(')){
//                if(i - 1 >= 0){
//                    if(splitted[i - 1] == '!'){
//                        opers.push("" + splitted[i-1]);
//                    }
//                }
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
                    statementOrder.get(statementOrder.size() - 1).setNegateResult(true); // todo out of bounds
                }
                opers.pop();
                // negate result of this operation if ! before opening parentheses
            }
            else if(isOperator("" + splitted[i]) || (isOperator("" + splitted[i]) && isOperator("" + splitted[i+1]) ||
                    (splitted[i] == '!' && splitted[i+1] == '='))/*splitted[i] == '+' || splitted[i] == '-' || splitted[i] == '*' || splitted[i] == '/' || splitted[i] == '|' || splitted[i] == '&'*/){ //supported operators

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
            Symbol ret = new Symbol();

            retrievedSymbol = s;

            // not a stirng
//            if(s.getType() == ESymbolType.ARRAY){
//                if(s.getIndToArray() != -1){
//                    if(s.getIndToArray() >= s.getSizeArr()){
//                        // todo print out of bounds
//                    }
//                    else{
//                        ret.setAdr(-1);
//                        ret.setPartialResult(false);
//                        ret.setValue("" + s.getArrayElements().get(s.getIndToArray()));
//
//                        //retrievedSymbol = s.getArrayElements().get(s.getIndToArray());
//                    }
//                }
//                else{
//                    // todo allow pole1 = pole2?
//                }
//            }
//            else if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
//
//            }

        }

        return statementOrder;
    }

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
