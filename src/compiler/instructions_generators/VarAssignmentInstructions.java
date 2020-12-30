package compiler.instructions_generators;

import compiler.*;
import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class VarAssignmentInstructions {

    // todo index when we want to change one element in an array / string
    // todo what should we do, when arr1 = arr2 happens? -> point to the same memory?
    public static ArrayList<Instruction> generateInstructions(Symbol s, String value, int index, HashMap<String, Symbol> table){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        int addr = s.getAdr(); // the address to store the new value to
        int level = s.getLev();


        boolean valAtTop = false;
        if(isExpression(value)){
            ArrayList<Operation> operOrder = parseExprDecBool(value, table);

            for(int i = 0; i < operOrder.size(); i++){
                Operation oper = operOrder.get(i);

                ArithmeticExpressionInstructions.generateInstructions(oper);

                //System.out.println("Operation - START");
                //System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
                //System.out.println("Operation - END");
            }
            valAtTop = true;
        }

        // now we should have the result stored at the top of the stack?





        if(s.getType() == ESymbolType.INT){
            // first store the value at the top of the stack:
            // we can be sure the parseInt will be ok, bc it got accepted by the grammar - NO! can be expression^^
            if(!valAtTop)
                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(value)));

            // then write the value to the correct address:
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr)); // todo is the level true?


        }
        else if(s.getType() == ESymbolType.BOOL){
            // todo evaluate epression for bool?
        }
        else if(s.getType() == ESymbolType.ARRAY || s.getType() == ESymbolType.STRING){
            if(value.length() > 1 && !isExpression(value)){
                // we're assigning to the whole thing

                for(int i = 0; i < value.length(); i++){
                    if(!valAtTop) // todo ???
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(i)));

                    // then write the value to the correct address:
                    generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i)); // todo is the level true?
                }

            }
            else if(value.length() == 1){
                // we're changing one element in the array
                if(!valAtTop)
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(0)));

                // then write the value to the correct address:
                generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + index)); // todo is the level true?
            }
        }
//        else if(s.getType() == ESymbolType.STRING){
//            // todo implement
//        }


        // change the value in the symbol table:
        s.setValue(value);

        return generatedInstructions;
    }





    // --- expressions ---
//        ArrayList<valueEvalDecData> operOrder = parseExprDecBool("100*(2+12)/14");
//        for(int i = 0; i < operOrder.size(); i++){
//            valueEvalDecData oper = operOrder.get(i);
//            System.out.println("Operation - START");
//            System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
//            System.out.println("Operation - END");
//        }


    // -- parsing expressions: ---


    private static boolean isExpression(String value){

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
    private static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> table){
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

//    private static int singleOpExprDecBool(char oper, int secondNum, int firstNum){
//        if(oper == '-'){
//            return firstNum - secondNum;
//        }else if(oper == '+'){
//            return firstNum + secondNum;
//        }else if(oper == '*'){
//            return firstNum * secondNum;
//        }else if(oper == '/') {
//            return firstNum / secondNum;
//        }else{
//            return 0;
//        }
//    }


}
