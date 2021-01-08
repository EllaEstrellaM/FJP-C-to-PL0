package compiler.instructions_generators;

import compiler.EInstrSet;
import compiler.ExpressionParser;
import compiler.Instruction;
import compiler.Symbol;
import statementDefMultiLine.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CycleInstructions {
    /**
     * Generates instructions for for cycle (first part).
     * @param cycle instance of forCycle, represents one for cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForInstructions1(forCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - for first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for forcycle - START
        String identifier = cycle.getIdentifierVar(); //name of the variable
        String start = cycle.getExprDecBool1(); //value of the variable in the beginning of the cycle
        String end = cycle.getExprDecBool2(); //value of the variable in the end of the cycle (value after TO)
        //info relevant for forcycle - END

        Symbol identifSym = table.get(identifier); //retrieve identifier data from table
        int identifAddr = identifSym.getAdr();

        ArrayList<Instruction> genInstrExpr = ExpressionParser.solveExpr(start, table, privTable); //define start of the cycle
        generatedInstructions.addAll(genInstrExpr);
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifAddr)); //store start of the cycle on given address

        generatedInstructions.add(new Instruction("JUMP_FOR_START*" + cycle));
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifAddr)); //load actual value of var <- JUMP HERE FROM END
        ArrayList<Instruction> genInstrExpr2 = ExpressionParser.solveExpr(end, table, privTable); //define end of the cycle
        generatedInstructions.addAll(genInstrExpr2);
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 13)); //compare actual value of var with the end of the cycle ; until <=
        generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump to RET
        //CODE INSIDE CYCLE

        return generatedInstructions;
    }

    /**
     * Generates instructions for for cycle (second part).
     * @param cycle instance of forCycle, represents one for cycle
     * @param table table with symbols
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForInstructions2(forCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable){
        System.out.println("Generating CYCLE - for second part");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for forcycle - START
        String identifier = cycle.getIdentifierVar(); //name of the variable
        //info relevant for forcycle - END

        Symbol identifSym = null;
        if(privTable.containsKey(identifier)){
            identifSym = privTable.get(identifier);
        }else if(table.containsKey(identifier)){
            identifSym = table.get(identifier);
        }else{
            //todo error
        }

        int identifAddr = identifSym.getAdr();

        //CODE INSIDE CYCLE
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifAddr)); //now increment value of var - START ; load value of var
        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1)); //increment by +1 ; define
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 2)); //perform oper add ; +
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifAddr)); //now increment value of var - END ; save value of var
        generatedInstructions.add(new Instruction("JUMP_FOR_END*" + cycle)); //now jump to beginning of the cycle

        return generatedInstructions;
    }

    /**
     * Generates instructions for foreach cycle (first part).
     * @param cycle instance of foreachCycle, represents one foreach cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForeachInstructions1(foreachCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - foreach first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for foreachcycle - START
        String identifierItem = cycle.getIdentifierVar1(); //name of variable representing one item in array
        String identifierArray = cycle.getIdentifierVar2(); //name of whole array
        //info relevant for foreachcycle - END

        Symbol identifItemSym = null; //retrieve identifier data from table
        Symbol identifArraySym = null; //retrieve array data from table
        Symbol traverseHlp = table.get("SYSTEM_RESERVED_1"); //go through array, keep current index

        if(privTable.containsKey(identifierItem)){
            identifItemSym = privTable.get(identifierItem);
        }else if(table.containsKey(identifierItem)){
            identifItemSym = table.get(identifierItem);
        }else{
            //todo error
        }

        if(privTable.containsKey(identifierArray)){
            identifArraySym = privTable.get(identifierArray);
        }else if(table.containsKey(identifierArray)){
            identifArraySym = table.get(identifierArray);
        }else{
            //todo error
        }

        int identifItemSymAddr = identifItemSym.getAdr(); //address of identifier representing one item
        int identifArraySymAddr = identifArraySym.getAdr(); //address of array item
        int traverseHlpAddr = traverseHlp.getAdr(); //address of variable which helps us to traverse the array

        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 0)); //define start of the cycle
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, traverseHlpAddr)); //store start of the cycle on given address

        generatedInstructions.add(new Instruction("JUMP_FOREACH_START*" + cycle));
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, traverseHlpAddr)); //load actual value of traversing var <- JUMP HERE FROM END
        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, identifArraySym.getSizeArr())); //define end of the cycle
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 10)); //compare actual value of var with the end of the array ; until <
        generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump to RET
        //load one item from arr to var - START
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifArraySymAddr)); //load start address of the cycle
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, traverseHlpAddr)); //load traversing state of the cycle
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 2)); //perform oper add ; + ; get address of new value (within the cycle)
        generatedInstructions.add(new Instruction(EInstrSet.LDA, 0, 0)); //to top of stack load value from address on top of stack (currently)
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifItemSymAddr)); //store retrieved number to variable
        //now load item on address which is on top of stack???
        //load one item from arr to var - END

        //CODE INSIDE CYCLE
        return generatedInstructions;
    }

    /**
     * Generates instructions for foreach cycle (second part).
     * @param cycle instance of foreachCycle, represents one foreach cycle
     * @param table table with symbols
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForeachInstructions2(foreachCycle cycle, HashMap<String, Symbol> table){
        System.out.println("Generating CYCLE - foreach second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        Symbol traverseHlp = table.get("SYSTEM_RESERVED_1"); //go through array, keep current index
        int traverseHlpAddr = traverseHlp.getAdr(); //address of variable which helps us to traverse the array

        //CODE INSIDE CYCLE
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, traverseHlpAddr)); //now increment value of var - START ; load value of var
        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1)); //increment by +1 ; define
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 2)); //perform oper add ; +
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, traverseHlpAddr)); //now increment value of var - END ; save value of var
        generatedInstructions.add(new Instruction("JUMP_FOREACH_END*" + cycle)); //now jump to beginning of the cycle

        return generatedInstructions;
    }

    /**
     * Generates instructions for while cycle (first part).
     * @param cycle instance of whileCycle, represents one while cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateWhileInstructions1(whileCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - while first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for whilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written after while in between brackets
        //info relevant for whilecycle - END

        generatedInstructions.add(new Instruction(cycle + ""));
        ArrayList<Instruction> genInstrExpr2 = ExpressionParser.solveExpr(condition, table, privTable);
        generatedInstructions.addAll(genInstrExpr2);
        generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump to next
        //CODE INSIDE CYCLE - here increment the var??

        return generatedInstructions;
    }

    /**
     * Generates instructions for while cycle (second part).
     * @param cycle instance of whileCycle, represents one while cycle
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateWhileInstructions2(whileCycle cycle){
        System.out.println("Generating CYCLE - while second part");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //CODE INSIDE CYCLE - here increment the var??
        generatedInstructions.add(new Instruction(cycle + "")); //now jump to beginning of the cycle

        return generatedInstructions;
    }

    /**
     * Generates instructions for do while cycle (first part).
     * @param cycle instance of doWhileCycle, represents one do while cycle
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateDoWhileInstructions1(doWhileCycle cycle, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - dowhile first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();
        //CODE INSIDE CYCLE - here increment the var?? <- JUMP HERE FROM END
        generatedInstructions.add(new Instruction(cycle + ""));
        return generatedInstructions;
    }

    /**
     * Generates instructions for do while cycle (second part).
     * @param cycle instance of doWhileCycle, represents one do while cycle
     * @param table table with symbols
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateDoWhileInstructions2(doWhileCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable){
        System.out.println("Generating CYCLE - dowhile second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for dowhilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after while
        //info relevant for dowhilecycle - END

        //CODE INSIDE CYCLE
        ArrayList<Instruction> genInstrExpr2 = ExpressionParser.solveExpr(condition, table, privTable);
        generatedInstructions.addAll(genInstrExpr2);
        generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump NEXT STATEMENTS (+1)!!!
        generatedInstructions.add(new Instruction(cycle + "")); //now jump to beginning of the cycle

        return generatedInstructions;
    }

    /**
     * Generates instructions for repeat until cycle (first part).
     * @param cycle instance of repeatUntilCycle, represents one repeat until cycle
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateRepeatUntilInstructions1(repeatUntilCycle cycle, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - repeatuntil first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();
        //CODE INSIDE CYCLE - here increment the var?? <- JUMP HERE FROM END
        generatedInstructions.add(new Instruction(cycle + ""));
        return generatedInstructions;
    }

    /**
     * Generates instructions for repeat until cycle (second part).
     * @param cycle instance of repeatUntilCycle, represents one repeat until cycle
     * @param table table with symbols
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateRepeatUntilInstructions2(repeatUntilCycle cycle, HashMap<String, Symbol> table, HashMap<String, Symbol> privTable){
        System.out.println("Generating CYCLE - repeatuntil second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for dowhilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after while
        //info relevant for dowhilecycle - END

        //CODE INSIDE CYCLE
        ArrayList<Instruction> genInstrExpr2 = ExpressionParser.solveExpr(condition, table, privTable);
        generatedInstructions.addAll(genInstrExpr2);
        generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump NEXT STATEMENTS (+1)!!!
        generatedInstructions.add(new Instruction(cycle + "")); //now jump to beginning of the cycle

        return generatedInstructions;
    }
}
