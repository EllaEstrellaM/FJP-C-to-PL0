package compiler;

import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.IDeclaration;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Compiler {
    private static int stackPointer;
    //private HashSet<Symbol> symbolTable;
    private HashMap<String, Symbol> globalSymbolTable;
    private ParseTree tree;
    private ArrayList<Istatement> statements;
    private ArrayList<procedureDefinition> procedureDefinitions;

//    public Compiler(ParseTree tree){
//        //symbolTable = new HashSet<Symbol>();
//        symbolTable = new HashMap<String, Symbol>();
//        this.tree = tree;
//    }


    private final int BASE_ADDRESS = 3;

    int declCounter = BASE_ADDRESS;

    public Compiler(ArrayList<Istatement> statements){
        globalSymbolTable = new HashMap<String, Symbol>();
        this.procedureDefinitions = new ArrayList<>();
        this.statements = statements;
    }

    public ArrayList<Instruction> compile(){
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();

        // this instruction will always be the first one?
        // todo or can the address be other than 1?
        Instruction firstI = new Instruction(EInstrSet.JMP, 0,1);

        // todo then increase the stack 'size' by how much?
        // todo 3 + as_many_as_we_have_variables?
        Instruction secondI = new Instruction(EInstrSet.INT, 0, 3);

        instructions.add(firstI);
        instructions.add(secondI);

        // 1. fill the symbol table with 'global' things:
        String proc = "global";
        for(Istatement st : statements){
            if(st instanceof IDeclaration){
                resolveDeclaration((IDeclaration) st, proc, globalSymbolTable);
                //declCounter++;
            }
//            if(st instanceof ImultiLineStatement){
//                resolveMultilineStatement((ImultiLineStatement) st);
//            }
//            else if(st instanceof IoneLineStatement){
//                ;;
//            }
        }

        // 2. take care of procedures:
        for(procedureDefinition pd : procedureDefinitions){


        }


        // the last but not least return instruction
        Instruction lastI = new Instruction(EInstrSet.RET, 0, 0);
        instructions.add(lastI);



        return instructions;
    }

    public static Instruction generateInstruction(EInstrSet instr, int par1, int par2){

        switch (instr){
            case INT:
                stackPointer += par2;
                break;
            case LIT: case LOD:
                stackPointer++;
                break;
            case STO: case OPR: case JMC:
                stackPointer--;
                break;
        }

        Instruction newInstr = new Instruction(instr, par1, par2);
        return newInstr;

    }


    private void generateInstructionsForProcedure(){

    }



    private void resolveOneLineStatement(IoneLineStatement st, String inWhichProc){
        if(st instanceof IDeclaration){

//            if(parentSt != null){
//                if(parentSt instanceof procedureDefinition){
//                    inWhichProc = ((procedureDefinition) parentSt).getIdentifierVar();
//                }
//            }

            //resolveDeclaration((IDeclaration) st, inWhichProc);
        }
    }

    String currProc = "";
    private void resolveMultilineStatement(ImultiLineStatement st){


        if(st instanceof procedureDefinition){
            currProc = ((procedureDefinition) st).getIdentifierVar();
        }

        for(int i = 0; i < st.getInnerStatement().size(); i++){
            if(st.getInnerStatement().get(i) instanceof IoneLineStatement){
                resolveOneLineStatement((IoneLineStatement) st.getInnerStatement().get(i), currProc);
            }
            else{
                // recursion?
                resolveMultilineStatement((ImultiLineStatement) st.getInnerStatement().get(i));
            }
        }
    }


    /**
     * Adds new symbol to the table
     * @param st
     */
    private void resolveDeclaration(IDeclaration st, String inProc, HashMap<String, Symbol> symbolTable){
        // --- DECLARATIONS START: ---
        Symbol symb = new Symbol();
        String name = null;

        // normal declarations:
        if(st instanceof intDeclaration){
            name = ((intDeclaration) st).getIdentifierVar();
            String value = (((intDeclaration) st).isMinus_sign() ? "-" : "") + ((intDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof boolDeclaration){
            name = ((boolDeclaration) st).getIdentifierVar();
            String value = ((boolDeclaration) st).getBoolVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof stringDeclaration){
            name = ((stringDeclaration) st).getIdentifierVar();
            String value = ((stringDeclaration) st).getStringVal();
            int size = value.length();

            symb.setValue(value);
            symb.setName(name);
            symb.setSizeArr(size);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;

        }
        // arrays declarations:
        else if(st instanceof arrBoolDeclaration){
            name = ((arrBoolDeclaration) st).getIdentifierVar();
            int size = ((arrBoolDeclaration) st).getDecNum();
            //String value = "";

            //symb.setValue(value);
            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+= size;
        }
        else if(st instanceof arrIntDeclaration){
            name = ((arrIntDeclaration) st).getIdentifierVar();
            int size = ((arrIntDeclaration) st).getDecNum();
            //String value = "";

            //symb.setValue(value);
            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+=size;
        }

        // consts declaration:
        else if(st instanceof constBoolDeclaration){
            name = ((constBoolDeclaration) st).getIdentifierVar();
            String value = ((constBoolDeclaration) st).getBoolVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constIntDeclaration){
            name = ((constIntDeclaration) st).getIdentifierVar();
            String value = (((constIntDeclaration) st).isMinus_sign() ? "-" : "") + ((constIntDeclaration) st).getDecVal();


            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
        }
        else if(st instanceof constStringDeclaration){
            name = ((constStringDeclaration) st).getIdentifierVar();
            String value = ((constStringDeclaration) st).getStringVal();
            int size = value.length();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;
        }
        else if(st instanceof procedureDefinition){
            name = ((procedureDefinition) st).getIdentifierVar();
            String params = ((procedureDefinition) st).getParameters();

            symb.setName(name);
            symb.setProcParameters(params);
            symb.setAdr(declCounter);
            symb.setLev(1); // todo ???
            symb.setType(ESymbolType.PROCEDURE);
            symb.setInProcedure(inProc); // todo we probably dont support nested procedures anyway
            declCounter++; // todo???

            procedureDefinitions.add((procedureDefinition)st);
        }

        //globalSymbolTable.put(name, symb);
        symbolTable.put(name, symb);
        // --- DECLARATIONS END ---
    }











    // -- parsing expressions: ---
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


}
