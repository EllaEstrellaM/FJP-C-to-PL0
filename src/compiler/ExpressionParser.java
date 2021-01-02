package compiler;

import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExpressionParser {


    public static boolean isExpression(String value){

        return value.contains("+") || value.contains("-") || value.contains("*") ||
                value.contains("/") || value.contains("%") || value.contains("(") || value.contains(")")
                || value.contains("|") || value.contains("&") /*|| value.contains("!")*/
                || value.contains("<") || value.contains("<=") || value.contains(">") || value.contains(">=") || value.contains("==") || value.contains("!=");
    }

    private static boolean isOperator(String value){

        return value.equals("+") || value.equals("-") || value.equals("*") ||
                value.equals("/") || value.equals("%") /*|| value.equals("(") || value.equals(")")*/
                || value.contains("|") || value.contains("&") /*|| value.contains("!")*/
                || value.contains("<") || value.contains("=") || value.contains(">") || value.contains("!");
    }

    private static boolean isNumeric(String str) {
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


    // todo bool vars and keywords too?
    public static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> table){
        ArrayList<Operation> statementOrder = new ArrayList<Operation>();

        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)

        Stack<Symbol> numbers = new Stack<Symbol>(); //stack for retrieved numbers
        Stack<String> opers = new Stack<String>(); //stack for retrieved operators

        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators
            if(!isOperator("" + splitted[i]) && splitted[i] != '(' && splitted[i] != ')'      /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //between 0 - 9 -> number
                StringBuffer numBuf = new StringBuffer();

                while(i < splitted.length && !isOperator("" + splitted[i]) /*&& !isOperator("" + splitted[i+1])*/ /*splitted[i] >= '0' && splitted[i] <= '9'*/){ //number can be > 1 char
//                    if(isOperator("" + splitted[i+1])){
//                        numBuf.append(splitted[i]);
//                        numBuf.append(splitted[i + 1]);
//                        i+=2;
//                    }
//                    else{
                        numBuf.append(splitted[i++]);
                    //}

                }

                if(table.containsKey(numBuf.toString())){
                    if(table.get(numBuf.toString()).hasBeenDeclared()){
                        numbers.push(table.get(numBuf.toString())); //push buffer containing whole number to stack
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
                    }

                }
                else{
                    if(isNumeric(numBuf.toString())){
                        Symbol s = new Symbol();
                        s.setValue(numBuf.toString());
                        s.setAdr(-1);
                        numbers.push(s);
                    }
                    else{
                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
                    }

                }
                i--;
            }else if(splitted[i] == '('){
                opers.push("" + splitted[i]);
            }else if(splitted[i] == ')'){
                while(opers.peek().equals("(")){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    String oper = opers.pop();

                    //valueEvalDecData evalSingleOper = new valueEvalDecData();
                    Operation op = new Operation();
                    op.setSymbol1(firstVal);
                    op.setSymbol2(secondVal);
                    op.setOperator(EOperator.getOperFromString("" + oper));
                    statementOrder.add(op);


//                    evalSingleOper.setSecondVal(secondVal);
//                    evalSingleOper.setOper(oper);
//                    evalSingleOper.setFirstVal(firstVal);
//                    statementOrder.add(evalSingleOper);

                    //numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));

                    Symbol s = new Symbol();
                    s.setAdr(-1);
                    s.setValue("" + op.getResult());
                    numbers.push(s);

                }

                opers.pop();
            }else if(isOperator("" + splitted[i]) || (isOperator("" + splitted[i]) && isOperator("" + splitted[i+1]))/*splitted[i] == '+' || splitted[i] == '-' || splitted[i] == '*' || splitted[i] == '/' || splitted[i] == '|' || splitted[i] == '&'*/){ //supported operators
                while (!opers.empty() && checkPrecExprDecBool(splitted[i], opers.peek())){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    String oper = opers.pop();

//                    valueEvalDecData evalSingleOper = new valueEvalDecData();
//                    evalSingleOper.setSecondVal(secondVal);
//                    evalSingleOper.setOper(oper);
//                    evalSingleOper.setFirstVal(firstVal);
//                    statementOrder.add(evalSingleOper);
//
//                    numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));

                    Operation op = new Operation();
                    op.setSymbol1(firstVal);
                    op.setSymbol2(secondVal);
                    op.setOperator(EOperator.getOperFromString("" + oper));
                    statementOrder.add(op);

                    Symbol s = new Symbol();
                    s.setAdr(-1);
                    s.setValue("" + op.getResult());
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

//            valueEvalDecData evalSingleOper = new valueEvalDecData();
//            evalSingleOper.setSecondVal(secondVal);
//            evalSingleOper.setOper(oper);
//            evalSingleOper.setFirstVal(firstVal);
//            statementOrder.add(evalSingleOper);
//
//            numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));

            Operation op = new Operation();
            op.setSymbol1(firstVal);
            op.setSymbol2(secondVal);
            op.setOperator(EOperator.getOperFromString("" + oper));
            statementOrder.add(op);

            Symbol s = new Symbol();
            s.setAdr(-1);
            s.setValue("" + op.getResult());
            numbers.push(s);
        }

        return statementOrder;
    }

    private static boolean checkPrecExprDecBool(char firstOper, String secondOper){
        if(secondOper.equals("(") || secondOper.equals(")")){
            return false;
        }else if((firstOper == '*' || firstOper == '/') && (secondOper.equals("+") || secondOper.equals("-") || secondOper.equals("|") || secondOper.equals("&")
                || secondOper.equals("<") || secondOper.equals("<=") || secondOper.equals(">") || secondOper.equals(">=") || secondOper.equals("==") || secondOper.equals("!="))){
            return false;
        }else{
            return true;
        }
    }

}
