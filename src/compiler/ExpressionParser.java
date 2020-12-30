package compiler;

import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExpressionParser {


    public static boolean isExpression(String value){

        return value.contains("+") || value.contains("-") || value.contains("*") ||
                value.contains("/") || value.contains("%") || value.contains("(") || value.contains(")");
    }

    private static boolean isOperator(String value){

        return value.equals("+") || value.equals("-") || value.equals("*") ||
                value.equals("/") || value.equals("%") || value.equals("(") || value.equals(")");
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    // todo bool vars and keywords too?
    public static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> table){
        ArrayList<Operation> statementOrder = new ArrayList<Operation>();

        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)

        Stack<Symbol> numbers = new Stack<Symbol>(); //stack for retrieved numbers
        Stack<Character> opers = new Stack<Character>(); //stack for retrieved operators

        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators
            if(!isOperator("" + splitted[i])/*splitted[i] >= '0' && splitted[i] <= '9'*/){ //between 0 - 9 -> number
                StringBuffer numBuf = new StringBuffer();

                while(i < splitted.length && !isOperator("" + splitted[i])/*splitted[i] >= '0' && splitted[i] <= '9'*/){ //number can be > 1 char
                    numBuf.append(splitted[i++]);
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
                opers.push(splitted[i]);
            }else if(splitted[i] == ')'){
                while(opers.peek() != '('){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    Character oper = opers.pop();

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
            }else if(splitted[i] == '+' || splitted[i] == '-' || splitted[i] == '*' || splitted[i] == '/'){ //supported operators
                while (!opers.empty() && checkPrecExprDecBool(splitted[i], opers.peek())){
                    Symbol secondVal = numbers.pop();
                    Symbol firstVal = numbers.pop();
                    Character oper = opers.pop();

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

                opers.push(splitted[i]);
            }
        }

        while (!opers.empty()){
            Symbol secondVal = numbers.pop();
            Symbol firstVal = numbers.pop();
            Character oper = opers.pop();

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

    private static boolean checkPrecExprDecBool(char firstOper, char secondOper){
        if(secondOper == '(' || secondOper == ')'){
            return false;
        }else if((firstOper == '*' || firstOper == '/') && (secondOper == '+' || secondOper == '-')){
            return false;
        }else{
            return true;
        }
    }

}
