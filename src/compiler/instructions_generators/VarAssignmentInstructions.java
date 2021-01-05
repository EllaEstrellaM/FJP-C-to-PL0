package compiler.instructions_generators;

import compiler.*;
import compiler.errors.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class VarAssignmentInstructions {

    // todo index when we want to change one element in an array / string
    // todo what should we do, when arr1 = arr2 happens? -> point to the same memory?
    // in value there is the whole right side
    public static ArrayList<Instruction> generateInstructions(Symbol s, String value, int indexToAssignTo, HashMap<String, Symbol> table){
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        int addr = s.getAdr(); // the address to store the new value to
        int level = s.getLev();
        String actualVal = value;
        boolean valAtTop = false;
        //int index = -1;





        if(s.isConst() && s.hasBeenDeclared()){
            // cannot assign to const again - print err
            Error.printConstAssign(s.getName());
        }



        // we can assign only string to a string
        if(s.getType() == ESymbolType.STRING && !ExpressionParser.isNumeric(value) && !ExpressionParser.isExpression(value)){
            // it's not a number and it's not an expression - can be var name or string
            // ok assignment to string

            if(value.charAt(0) == '\"' && value.charAt(value.length() - 1) == '\"'){
                // it's a string literal we want to assign to the string variable
                // check if it's too long:
                if(value.length() - 2 > s.getSizeArr()){
                    // the string literal is longer than what the string was declared for
                    Error.printStringTooLong(s.getName(), value);
                }

                // proceed:
                for(int i = 1; i < value.length() - 1; i++){
                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(i)));
                    generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i - 1));
                }
                actualVal = value.substring(1,value.length() - 2); // todo check if correct
            }
            else{
                // it's a var name
                // check if the var exists:
                if(table.containsKey(value)){
                    // there is a var with this name
                    if(table.get(value).getType() == ESymbolType.STRING){
                        // it is also a string
                        // check if it's too long:
                        if(table.get(value).getSizeArr() > s.getSizeArr()){
                            // the string is longer than what the string was declared for
                            Error.printStringTooLong(s.getName(), value);
                        }

                        // else proceed
                        for(int i = 0; i < table.get(value).getSizeArr(); i++){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, (int)table.get(value).getValue().charAt(i)));
                            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i));
                        }
                        actualVal = table.get(value).getValue();
                    }
                    else{
                        // print cannot assign num to string
                    }
                }
            }

            // todo return here + todo concatenating strings
        }

        // took care of strings ^^
        // try to parse the value as expression:
        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(value, table);
        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);

                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));

                //System.out.println("Operation - START");
                //System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
                //System.out.println("Operation - END");
            }
            actualVal = "" + opOrd.get(opOrd.size() - 1).getResult(); // todo negation
            valAtTop = true;
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol;
            if(retrSymb != null){
                //if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
                    if(retrSymb.getAdr() == -1){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                    }
                    else{
                        if(retrSymb.getIndToArray() == -1){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            actualVal = retrSymb.getValue();
                        }

                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            actualVal = "" + retrSymb.getArrayElements().get(retrSymb.getIndToArray());
                        }

                    }
                //}
            }
            else{
                System.out.println("weird");
            }
        }


        // now whatever it is, it should be at the top of the stack
        if(indexToAssignTo == -1){
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr));
            s.setValue(actualVal);
        }
        else{
            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + indexToAssignTo));
            s.getArrayElements().set(indexToAssignTo, Integer.parseInt(actualVal));
        }




////        else if(ExpressionParser.isExpression(value)){
////
////            if(s.getType() == ESymbolType.STRING){
////                // cannot store expression in a string - the grammar should take care of this though
////                // keep this if here just in case
////                // Error.printSomething?
////            }
////
////            // get the order of operations
////            ArrayList<Operation> operOrder = ExpressionParser.parseExprDecBool(value, table);
////
////            // generate the arithmetic instructions:
////            for(int i = 0; i < operOrder.size(); i++){
////                Operation oper = operOrder.get(i);
////
////                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));
////
////                //System.out.println("Operation - START");
////                //System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
////                //System.out.println("Operation - END");
////            }
////            actualVal = "" + operOrder.get(operOrder.size() - 1).getResult(); // todo negation
////            valAtTop = true;
////        }
//
//
//        // now we should have the result stored at the top of the stack
//        // assigning to an index of an array:
//        if(indexToAssignTo != -1 && s.getType() == ESymbolType.ARRAY){
//            if(!ExpressionParser.isNumeric(value) && !valAtTop){
//                // variable name?
//                if(table.containsKey(value)){
//                    // there is such a var
//                    if(table.get(value).getType() == ESymbolType.INT || table.get(value).getType() == ESymbolType.BOOL){
//                        // just assign it
//                        if(!valAtTop)
//                            generatedInstructions.add(new Instruction(EInstrSet.LOD, table.get(value).getLev(), (int)value.charAt(0)));
//
//                    }
//                    else{
//                        // todo print something
//                    }
//                }
////                else if(!table.containsKey(value) && !ExpressionParser.isNumeric(value) && !valAtTop){
////
////                }
//            }
//            else if(ExpressionParser.isNumeric(value)){
//
//            }
//        }
//        else if(indexToAssignTo == -1 && s.getType() == ESymbolType.ARRAY){
//            // todo allow pole1 = pole2?
//        }
//
////        else if(ExpressionParser.isNumeric(value)){
////            // normal number
////            actualVal = value;
////        }
////        else {
////            // it's not a number, not a string, not an expression
////            if(table.containsKey(value)){
////                // it's a var name in the
////            }
////        }
//
//
//
//
//
//        if(s.getType() == ESymbolType.INT || s.getType() == ESymbolType.BOOL){
//            // first store the value at the top of the stack:
//            // we can be sure the parseInt will be ok, bc it got accepted by the grammar - NO! can be expression^^ or var name
//            if(!valAtTop)
//                generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(value)));
//            else{
//                if(!ExpressionParser.isNumeric(value)){
//                    // not a number
//                    if(table.containsKey(value)){
//                        // it is in the table
//
//                    }
//                }
//            }
//
//            // then write the value to the correct address:
//            generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr)); // todo is the level true?
//
//
//        }
////        else if(s.getType() == ESymbolType.BOOL){
////            // todo evaluate epression for bool?
////        }
//        else if(s.getType() == ESymbolType.ARRAY /*|| s.getType() == ESymbolType.STRING*/){
////            if(value.length() > 1 && !ExpressionParser.isExpression(value)){
////                // we're assigning to the whole thing
////
////                for(int i = 0; i < value.length(); i++){
////                    if(!valAtTop) // todo ???
////                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(i)));
////
////                    // then write the value to the correct address:
////                    generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + i)); // todo is the level true?
////                }
////
////            }
////            else if(value.length() == 1){
//                // we're changing one element in the array
//                if(!valAtTop)
//                    generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, (int)value.charAt(0)));
//
//                // then write the value to the correct address:
//                generatedInstructions.add(new Instruction(EInstrSet.STO, level, addr + indexToAssignTo)); // todo is the level true?
//            }
//        //}
////        else if(s.getType() == ESymbolType.STRING){
////            // todo implement
////        }
//
//
//        // change the value in the symbol table:
//        s.setValue(value);





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


//    private static boolean isExpression(String value){
//
//        return value.contains("+") || value.contains("-") || value.contains("*") ||
//                value.contains("/") || value.contains("%") || value.contains("(") || value.contains(")");
//    }
//
//    private static boolean isOperator(String value){
//
//        return value.equals("+") || value.equals("-") || value.equals("*") ||
//                value.equals("/") || value.equals("%") || value.equals("(") || value.equals(")");
//    }
//
//    private static boolean isNumeric(String str) {
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch(NumberFormatException e){
//            return false;
//        }
//    }
//
//
//    // todo bool vars and keywords too?
//    private static ArrayList<Operation> parseExprDecBool(String exprDecBool, HashMap<String, Symbol> table){
//        ArrayList<Operation> statementOrder = new ArrayList<Operation>();
//
//        char[] splitted = exprDecBool.toCharArray(); //split to indiv "letters" (numbers + operators)
//
//        Stack<Symbol> numbers = new Stack<Symbol>(); //stack for retrieved numbers
//        Stack<Character> opers = new Stack<Character>(); //stack for retrieved operators
//
//        for(int i = 0; i < splitted.length; i++){ //go through splitted numbers & operators
//            if(!isOperator("" + splitted[i])/*splitted[i] >= '0' && splitted[i] <= '9'*/){ //between 0 - 9 -> number
//                StringBuffer numBuf = new StringBuffer();
//
//                while(i < splitted.length && !isOperator("" + splitted[i])/*splitted[i] >= '0' && splitted[i] <= '9'*/){ //number can be > 1 char
//                    numBuf.append(splitted[i++]);
//                }
//
//                if(table.containsKey(numBuf.toString())){
//                    if(table.get(numBuf.toString()).hasBeenDeclared()){
//                        numbers.push(table.get(numBuf.toString())); //push buffer containing whole number to stack
//                    }
//                    else{
//                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
//                    }
//
//                }
//                else{
//                    if(isNumeric(numBuf.toString())){
//                        Symbol s = new Symbol();
//                        s.setValue(numBuf.toString());
//                        s.setAdr(-1);
//                        numbers.push(s);
//                    }
//                    else{
//                        Error.printVarNotFound(numBuf.toString()); // todo opravdu?
//                    }
//
//                }
//
//
//
//                i--;
//            }else if(splitted[i] == '('){
//                opers.push(splitted[i]);
//            }else if(splitted[i] == ')'){
//                while(opers.peek() != '('){
//                    Symbol secondVal = numbers.pop();
//                    Symbol firstVal = numbers.pop();
//                    Character oper = opers.pop();
//
//                    //valueEvalDecData evalSingleOper = new valueEvalDecData();
//                    Operation op = new Operation();
//                    op.setSymbol1(firstVal);
//                    op.setSymbol2(secondVal);
//                    op.setOperator(EOperator.getOperFromString("" + oper));
//                    statementOrder.add(op);
//
//
////                    evalSingleOper.setSecondVal(secondVal);
////                    evalSingleOper.setOper(oper);
////                    evalSingleOper.setFirstVal(firstVal);
////                    statementOrder.add(evalSingleOper);
//
//                    //numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
//
//                    Symbol s = new Symbol();
//                    s.setAdr(-1);
//                    s.setValue("" + op.getResult());
//                    numbers.push(s);
//
//                }
//
//                opers.pop();
//            }else if(splitted[i] == '+' || splitted[i] == '-' || splitted[i] == '*' || splitted[i] == '/'){ //supported operators
//                while (!opers.empty() && checkPrecExprDecBool(splitted[i], opers.peek())){
//                    Symbol secondVal = numbers.pop();
//                    Symbol firstVal = numbers.pop();
//                    Character oper = opers.pop();
//
////                    valueEvalDecData evalSingleOper = new valueEvalDecData();
////                    evalSingleOper.setSecondVal(secondVal);
////                    evalSingleOper.setOper(oper);
////                    evalSingleOper.setFirstVal(firstVal);
////                    statementOrder.add(evalSingleOper);
////
////                    numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
//
//                    Operation op = new Operation();
//                    op.setSymbol1(firstVal);
//                    op.setSymbol2(secondVal);
//                    op.setOperator(EOperator.getOperFromString("" + oper));
//                    statementOrder.add(op);
//
//                    Symbol s = new Symbol();
//                    s.setAdr(-1);
//                    s.setValue("" + op.getResult());
//                    numbers.push(s);
//                }
//
//                opers.push(splitted[i]);
//            }
//        }
//
//        while (!opers.empty()){
//            Symbol secondVal = numbers.pop();
//            Symbol firstVal = numbers.pop();
//            Character oper = opers.pop();
//
////            valueEvalDecData evalSingleOper = new valueEvalDecData();
////            evalSingleOper.setSecondVal(secondVal);
////            evalSingleOper.setOper(oper);
////            evalSingleOper.setFirstVal(firstVal);
////            statementOrder.add(evalSingleOper);
////
////            numbers.push(singleOpExprDecBool(oper, secondVal, firstVal));
//
//            Operation op = new Operation();
//            op.setSymbol1(firstVal);
//            op.setSymbol2(secondVal);
//            op.setOperator(EOperator.getOperFromString("" + oper));
//            statementOrder.add(op);
//
//            Symbol s = new Symbol();
//            s.setAdr(-1);
//            s.setValue("" + op.getResult());
//            numbers.push(s);
//        }
//
//        return statementOrder;
//    }
//
//    private static boolean checkPrecExprDecBool(char firstOper, char secondOper){
//        if(secondOper == '(' || secondOper == ')'){
//            return false;
//        }else if((firstOper == '*' || firstOper == '/') && (secondOper == '+' || secondOper == '-')){
//            return false;
//        }else{
//            return true;
//        }
//    }

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
