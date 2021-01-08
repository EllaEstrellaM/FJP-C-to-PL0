package compiler.instructions_generators;

import compiler.EInstrSet;
import compiler.Instruction;
import compiler.Symbol;
import statementDefMultiLine.*;

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
    public static ArrayList<Instruction> generateForInstructions1(forCycle cycle, HashMap<String, Symbol> table, int innerLevel){
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
        System.out.println("Addr is: " + identifAddr);

        boolean startNum = isNum(start); //check if start value is plain number
        boolean endNum = isNum(end); //check if end value is plain number

        if(startNum && endNum){ //both values are plain numbers
            int startCycle = Integer.valueOf(start);
            int endCycle = Integer.valueOf(end);

            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, startCycle)); //define start of the cycle
            generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifAddr)); //store start of the cycle on given address

            generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifAddr)); //load actual value of var <- JUMP HERE FROM END
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, endCycle)); //define end of the cycle
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 13)); //compare actual value of var with the end of the cycle ; until <=
            generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, -1)); //here we should jump to RET
            //CODE INSIDE CYCLE
        }//NOW CHECK FOR TABLE + EXPRESSIONS...

        return generatedInstructions;
    }

    /**
     * Generates instructions for for cycle (second part).
     * @param cycle instance of forCycle, represents one for cycle
     * @param table table with symbols
     * @param beginCycNum address of instruction to which should be jumped
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForInstructions2(forCycle cycle, HashMap<String, Symbol> table, int beginCycNum){
        System.out.println("Generating CYCLE - for second part");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for forcycle - START
        String identifier = cycle.getIdentifierVar(); //name of the variable
        //info relevant for forcycle - END

        Symbol identifSym = table.get(identifier); //retrieve identifier data from table
        int identifAddr = identifSym.getAdr();

        //CODE INSIDE CYCLE
        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifAddr)); //now increment value of var - START ; load value of var
        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1)); //increment by +1 ; define
        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, 2)); //perform oper add ; +
        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifAddr)); //now increment value of var - END ; save value of var
        generatedInstructions.add(new Instruction(EInstrSet.JMP, 0, beginCycNum)); //now jump to beginning of the cycle????

        return generatedInstructions;
    }

    /**
     * Generates instructions for foreach cycle (first part).
     * @param cycle instance of foreachCycle, represents one foreach cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForeachInstructions1(foreachCycle cycle, HashMap<String, Symbol> table, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - foreach first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for foreachcycle - START
        String identifierItem = cycle.getIdentifierVar1(); //name of variable representing one item in array
        String identifierArray = cycle.getIdentifierVar2(); //name of whole array
        //info relevant for foreachcycle - END

        Symbol identifItemSym = table.get(identifierItem); //retrieve identifier data from table
        Symbol identifArraySym = table.get(identifierArray); //retrieve identifier data from table

        int identifArraySymAddr = identifArraySym.getAdr(); //address where array begins
        int identifItemSymAddr = identifItemSym.getAdr(); //address of the identifier which should represent currently traversed item
        int identifArraySymSize = identifArraySym.getSizeArr(); //get size of the array

        for(int i = 0; i < identifArraySymSize; i++){ //go through items and generate instructions for each step / each item present in arrItems
            generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifArraySymAddr + i)); //base address + count of already traversed items
            generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifItemSymAddr)); //store item retrieved from array to address of first given identifier
            //CODE INSIDE CYCLE ; ok, loaded item from arr to the respective variable address
        }

//        int identifItemSymAddr = identifItemSym.getAdr();
//        int identifArraySymAddr = identifArraySym.getAdr();
//
//        generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, identifArraySymAddr + traverseHlpAddr));
//        generatedInstructions.add(new Instruction(EInstrSet.STO, 0, identifItemSymAddr));
//        identifItemSym.setAdr(identifArraySymAddr + traverseHlpAddr);
//        identifItemSym.setValue(identifItemSymAddr + "");

        return generatedInstructions;
    }

    /**
     * Generates instructions for foreach cycle (second part).
     * @param cycle instance of foreachCycle, represents one foreach cycle
     * @param table table with symbols
     * @param beginCycNum address of instruction to which should be jumped
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateForeachInstructions2(foreachCycle cycle, HashMap<String, Symbol> table, int beginCycNum){
        System.out.println("Generating CYCLE - foreach second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        return generatedInstructions;
    }

    /**
     * Generates instructions for while cycle (first part).
     * @param cycle instance of whileCycle, represents one while cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateWhileInstructions1(whileCycle cycle, HashMap<String, Symbol> table, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - while first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for whilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written after while in between brackets
        //info relevant for whilecycle - END

        //split the condition to get the name of the variable - START
        String[] splitCond = condition.split(" "); //split by space and on first index should be var ; second = operator ; third = number, expression..
        //split the condition to get the name of the variable - END

        Symbol varSam = table.get(splitCond[0]); //retrieve variable data from table
        int varSamAddr = varSam.getAdr();
        System.out.println("Addr while is: " + varSamAddr);

        boolean endNum = isNum(splitCond[2]); //check if end value is plain number

        if(endNum){ //if end is specified by plain number
            int endCycle = Integer.valueOf(splitCond[0]);

            generatedInstructions.add(new Instruction(EInstrSet.LOD, 0, varSamAddr)); //load actual value of var
            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, endCycle)); //define end of the cycle
            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, getInstructionNum(splitCond[1]))); //now generate instruction depending on operator located between variable and number

            generatedInstructions.add(new Instruction(EInstrSet.JMC, 0, 13)); //here we should jump to RET????
            //CODE INSIDE CYCLE - here increment the var??
        }

        return generatedInstructions;
    }

    /**
     * Generates instructions for while cycle (second part).
     * @param cycle instance of whileCycle, represents one while cycle
     * @param table table with symbols
     * @param beginCycNum address of instruction to which should be jumped
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateWhileInstructions2(whileCycle cycle, HashMap<String, Symbol> table, int beginCycNum){
        System.out.println("Generating CYCLE - while second part");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //CODE INSIDE CYCLE - here increment the var??
        generatedInstructions.add(new Instruction(EInstrSet.JMP, 0, 4)); //now jump to beginning of the cycle????

        return generatedInstructions;
    }

    /**
     * Generates instructions for do while cycle (first part).
     * @param cycle instance of doWhileCycle, represents one do while cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateDoWhileInstructions1(doWhileCycle cycle, HashMap<String, Symbol> table, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - dowhile first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for dowhilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after while
        //info relevant for dowhilecycle - END

        return generatedInstructions;
    }

    /**
     * Generates instructions for do while cycle (second part).
     * @param cycle instance of doWhileCycle, represents one do while cycle
     * @param table table with symbols
     * @param beginCycNum address of instruction to which should be jumped
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateDoWhileInstructions2(doWhileCycle cycle, HashMap<String, Symbol> table, int beginCycNum){
        System.out.println("Generating CYCLE - dowhile second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for dowhilecycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after while
        //info relevant for dowhilecycle - END

        return generatedInstructions;
    }

    /**
     * Generates instructions for repeat until cycle (first part).
     * @param cycle instance of repeatUntilCycle, represents one repeat until cycle
     * @param table table with symbols
     * @param innerLevel level - inner statements
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateRepeatUntilInstructions1(repeatUntilCycle cycle, HashMap<String, Symbol> table, int innerLevel){
        cycle.setInnerLevel(innerLevel); //assign level first

        System.out.println("Generating CYCLE - repeatuntil first lvl " + cycle.getInnerLevel());
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for repeatuntilcycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after until
        //info relevant for repeatuntilcycle - END

        return generatedInstructions;
    }

    /**
     * Generates instructions for repeat until cycle (second part).
     * @param cycle instance of repeatUntilCycle, represents one repeat until cycle
     * @param table table with symbols
     * @param beginCycNum address of instruction to which should be jumped
     * @return cycle instructions
     */
    public static ArrayList<Instruction> generateRepeatUntilInstructions2(repeatUntilCycle cycle, HashMap<String, Symbol> table, int beginCycNum){
        System.out.println("Generating CYCLE - repeatuntil second");
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        //info relevant for repeatuntilcycle - START
        String condition = cycle.getExprDecBoolCont(); //conditions written in between brackets after until
        //info relevant for repeatuntilcycle - END

        return generatedInstructions;
    }

    /**
     * Checks whether given String represents one whole number or not.
     * @param representation String which may represent whole number
     * @return true - if String can be interpreted as whole number, else false
     */
    private static boolean isNum(String representation){
        if(representation.matches("-?\\d+")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Takes operator which is present between identifier and number/expression and return number of corresponding instruction.
     * @param operator operator between identifier and number/expression
     * @return number of corresponding instruction
     */
    private static int getInstructionNum(String operator){
        if(operator.equals("==")){ //equals
            return 8;
        }else if(operator.equals("!=")){ //not equals
            return 9;
        }else if(operator.equals(">")){ //gr th
            return 12;
        }else if(operator.equals(">=")){ //gr th / equal
            return 11;
        }else if(operator.equals("<")){ //lw
            return 10;
        }else if(operator.equals("<=")){ //lw eq
            return 13;
        }else{
            return -1;
        }
    }
}
