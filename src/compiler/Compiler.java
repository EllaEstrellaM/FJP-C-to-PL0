package compiler;

import compiler.errors.Error;
import compiler.instructions_generators.CycleInstructions;
import compiler.instructions_generators.IfInstructions;
import compiler.instructions_generators.TernaryAssignmentInstructions;
import compiler.instructions_generators.VarAssignmentInstructions;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Compiler translates given statements into PL/0 instructions.
 */
public class Compiler {
    private HashMap<String, Symbol> globalSymbolTable;
    private ArrayList<Istatement> statements;
    private ArrayList<procedureDefinition> procedureDefinitions;

    ArrayList<Instruction> instructions;

    private final int BASE_ADDRESS = 3;
    public static int declCounter = 3;

    private int innerCounter;

    /**
     * Constructor takes reference to Java objects for which instructions should be generated.
     * @param statements List with all desired statements
     */
    public Compiler(ArrayList<Istatement> statements){
        globalSymbolTable = new HashMap<String, Symbol>();
        this.procedureDefinitions = new ArrayList<>();
        this.statements = statements;
        this.innerCounter = 0;
    }

    /**
     * Returns array of generated PL/0 instructions.
     * @return array of PL/0 instructions
     */
    public ArrayList<Instruction> compile(){
        this.instructions = new ArrayList<Instruction>();

        // this instruction will always be the first one
        Instruction firstI = new Instruction(EInstrSet.JMP, 0,1);
        Instruction secondI = new Instruction(EInstrSet.INT, 0, BASE_ADDRESS);

        instructions.add(firstI);
        instructions.add(secondI);

        // 1. fill the symbol table with 'global' things:
        String proc = "global";
        for(Istatement st : statements){
            if(st instanceof IDeclaration){
                resolveDeclaration((IDeclaration) st, proc, globalSymbolTable, this.instructions);
            }
        }

        // todo check which procedures will even be called?

        for(int i = 0; i < procedureDefinitions.size(); i++){ //go through procedure definitions
            procedureDefinition procedure = procedureDefinitions.get(i); //get one procedure from the list
//            // add a tag to show where the procedure starts
//            procedure.getInstructions().add(new Instruction("" + procedure));

            ArrayList<Istatement> statements = procedure.getInnerStatements(); //get statements which are present in procedure

            HashMap<Istatement, EallStatementType> statementType = parseStatements(statements); //got outer statement list, ok -> parse them and get its content
            String currProc = procedure.getIdentifierVar();


            for(int j = 0; j < statements.size(); j++){ //go through statements present in the procedure
                Istatement statement = statements.get(j); //get one statement present in the procedure

                innerCounter = 0;
                if(statement instanceof ImultiLineStatement){ //statement is multiline, retrieve its content
                    ImultiLineStatement multiStatement = (ImultiLineStatement) statement; //cast to multiline

                    if(statement instanceof ifCondition){
                        ifCondition ic = (ifCondition) statement;
                        String value = ic.getExprDecBoolCont();
                        procedure.getInstructions().addAll(IfInstructions.generateInstructions((Istatement) statement, value, globalSymbolTable, procedure.getPrivateSymbolTable()));
                    }
                    //generate FIRST part of the cycle (before inner statements) + HERE ASSIGN INNER LEVEL
                    else if(statement instanceof doWhileCycle){ //check for cycles - START
                        procedure.getInstructions().addAll(CycleInstructions.generateDoWhileInstructions1((doWhileCycle) statement, innerCounter));
                    }else if(statement instanceof forCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateForInstructions1((forCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                    }else if(statement instanceof foreachCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateForeachInstructions1((foreachCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                    }else if(statement instanceof repeatUntilCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateRepeatUntilInstructions1((repeatUntilCycle) statement, innerCounter));
                    }else if(statement instanceof whileCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateWhileInstructions1((whileCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                    } //check for cycles - END

                    solvRecurMultiLine(multiStatement, procedure);

                    //generate SECOND part of the cycle (after inner statements)
                    if(statement instanceof ifCondition){
                        procedure.getInstructions().addAll(IfInstructions.generateInstructionsEnd((Istatement) statement));
                    }
                    else if(statement instanceof doWhileCycle){ //check for cycles - START
                        procedure.getInstructions().addAll(CycleInstructions.generateDoWhileInstructions2((doWhileCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable())); //no instruction generated in first part
                    }else if(statement instanceof forCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateForInstructions2((forCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable())); //jump to 3. inst from first part
                    }else if(statement instanceof foreachCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateForeachInstructions2((foreachCycle) statement, globalSymbolTable)); //jump to 3. inst from first part
                    }else if(statement instanceof repeatUntilCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateRepeatUntilInstructions2((repeatUntilCycle) statement, globalSymbolTable, procedure.getPrivateSymbolTable())); //no instruction generated in first part
                    }else if(statement instanceof whileCycle){
                        procedure.getInstructions().addAll(CycleInstructions.generateWhileInstructions2((whileCycle) statement)); //jump to 3. inst from first part
                    } //check for cycles - END
                }else{ //statement is oneline - generate respective instructions
                    generateOneline((IoneLineStatement) statement, statementType, innerCounter);

                    if(statement instanceof IDeclaration){
                        resolveDeclaration((IDeclaration) statement, currProc, procedure.getPrivateSymbolTable(), procedure.getInstructions());
                    }

                    else if(statement instanceof unknownAssign){
                        unknownAssign ua = (unknownAssign)statement;
                        String ident = ua.getIdentifierVar();
                        String value = ua.getValueVar();

                        if(procedure.getPrivateSymbolTable().containsKey(ident)){ // look in the local table first
                            Symbol s = procedure.getPrivateSymbolTable().get(ident);

                            procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, -1, globalSymbolTable, procedure.getPrivateSymbolTable(), true, true));
                        }
                        else if(globalSymbolTable.containsKey(ident)){
                            Symbol s = globalSymbolTable.get(ident);
                            procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, -1, globalSymbolTable,procedure.getPrivateSymbolTable(), true, true));
                        }
                        else{
                            Error.printVarNotFound(ident);
                        }
                    }
                    else if(statement instanceof unknownArrAssign){
                        unknownArrAssign uaa = (unknownArrAssign) statement;
                        String ident = uaa.getIdentifierVar();
                        String value = uaa.getValueVar();
                        int indexToAssignTo = uaa.getIndexToAssign();

                        if(procedure.getPrivateSymbolTable().containsKey(ident)){
                            Symbol s = procedure.getPrivateSymbolTable().get(ident);

                            if(indexToAssignTo >= s.getSizeArr()){
                                Error.printOutOfBounds(ident, indexToAssignTo);
                            }
                            procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, indexToAssignTo, globalSymbolTable, procedure.getPrivateSymbolTable(), true, true));
                        }
                        else if(globalSymbolTable.containsKey(ident)){
                            Symbol s = globalSymbolTable.get(ident);
                            if(indexToAssignTo >= s.getSizeArr()){
                                Error.printOutOfBounds(ident, indexToAssignTo);
                            }
                            procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, indexToAssignTo, globalSymbolTable,procedure.getPrivateSymbolTable(), true, true));
                        }
                        else{
                            Error.printVarNotFound(ident);
                        }
                    }
                    else if(statement instanceof ternarAssign){
                        ternarAssign ta = (ternarAssign) statement;
                        String ident = ta.getIdentifierVar();
                        String cond = ta.getExprDecBoolCont();
                        String trueVal = ta.getExprDecBoolTrueVal();
                        String falseVal = ta.getExprDecBoolFalseVal();

                        if(procedure.getPrivateSymbolTable().containsKey(ident)){
                            Symbol s = procedure.getPrivateSymbolTable().get(ident);
                            procedure.getInstructions().addAll(TernaryAssignmentInstructions.generateInstructions(statement, s, cond, trueVal, falseVal, -1, globalSymbolTable, procedure.getPrivateSymbolTable()));
                        }

                        else if(globalSymbolTable.containsKey(ident)){
                            Symbol s = globalSymbolTable.get(ident);
                            procedure.getInstructions().addAll(TernaryAssignmentInstructions.generateInstructions(statement, s, cond, trueVal, falseVal, -1, globalSymbolTable, procedure.getPrivateSymbolTable()));
                        }
                        else{
                            Error.printVarNotFound(ident);
                        }
                    }
                    else if(statement instanceof procedureCall){
                        procedureCall pc = (procedureCall) statement;
                        String name = pc.getIdentifierVar();
                        // only in global
                        if(globalSymbolTable.containsKey(name)){
                            // we know such a procedure
                            // check if number of arguments match
                            procedureDefinition calledProc = null;
                            for(procedureDefinition p : procedureDefinitions){
                                if(p.getIdentifierVar().equals(name)){
                                    calledProc = p;
                                    break;
                                }
                            }

                            if(calledProc == null){
                                break;
                            }

                            if(pc.getIndivArguments().size() != calledProc.getArgs().size()){
                                Error.printUnmatchingArgs(calledProc.getIdentifierVar());
                            }
                            else {
                                for(int k = 0; k < calledProc.getArgs().size(); k++){
                                    Symbol s = calledProc.getArgs().get(k);
                                    String valInArg = pc.getIndivArguments().get(k);
                                    procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, valInArg, -1, globalSymbolTable, /*calledProc*/procedure.getPrivateSymbolTable(), true, false));
                                }



                                if(procedure.getIdentifierVar().equals(calledProc.getIdentifierVar())){
                                    // same name - recursion

                                    // add a tag to show where the procedure starts
                                    if(procedure.getInstructions().size() > 0){
                                        procedure.getInstructions().get(0).jmpRecurTag = "" + procedure;
                                        //procedure.getInstructions().add(new Instruction("recursion " + calledProc));

                                        Instruction newIn = new Instruction(EInstrSet.JMP, 0, -1);
                                        newIn.jmpRecurTag = "recursion " + calledProc;
                                        procedure.getInstructions().add(newIn);
                                    }
                                    else{
                                        Instruction newIn = new Instruction(EInstrSet.JMP, 0, -1);
                                        newIn.jmpRecurTag = "recursion here " + calledProc;
                                        procedure.getInstructions().add(newIn);
                                        //procedure.getInstructions().add(new Instruction("recursion here " + calledProc));
                                    }



                                }
                                else{
                                    // and add the called procedure's instructions to the current procedure's instructions:
                                    procedure.getInstructions().addAll(calledProc.getInstructions());
                                }
                            }

                        }
                        else{
                            Error.printVarNotFound(name);
                        }
                    }
                }
            }
        }

        // find main: todo it should be the last procedure def in the file
        boolean mainFound = false;
        for(procedureDefinition pd : procedureDefinitions){
            if(pd.getIdentifierVar().equals("main")){
                instructions.addAll(pd.getInstructions());
                mainFound = true;
            }
        }
        if(!mainFound){
            Error.printInvalidMain(true, false);
        }

        // the last but not least return instruction
        Instruction lastI = new Instruction(EInstrSet.RET, 0, 0);
        instructions.add(lastI);



//        ArrayList<Instruction> newInstructions = new ArrayList<>();
//        // remove tags for procedure starts
//        for(int i = 0; i < instructions.size(); i++){
//            Instruction currI = instructions.get(i);
//            String tag = null;
//            if(currI.getInstruction() == null && currI.getJmpAddr().contains("procedureDefinition") && !currI.getJmpAddr().contains("recursion")){
//                // tag to jump to => i + 1
//                tag = currI.getJmpAddr();
//                //String tagToSearch = "recursion " + tag;
//
//                instructions.get(i + 1).jmpRecurTag = tag;
//
////                for(int j = i + i; j < instructions.size(); j++){
////                    if(instructions.get(j).getInstruction() == null && instructions.get(j).getJmpAddr().equals(tagToSearch)){
////                        // found it
////                        instructions.get(i + 1).jmpRecurTag = tag;
////                    }
////                }
//            }
//            else{
//                newInstructions.add(currI);
//            }
//        }
//
////        for(int i = newInstructions.size() - 1; i >= 0; i--){
////            Instruction currI = newInstructions.get(i);
////            if(currI.getInstruction() == null && currI.getJmpAddr().contains("recursion")){
////
////            }
////        }





//        System.out.println("---------------------------");
//        for(Instruction i : newInstructions ){
//            System.out.println(i);
//        }



        ArrayList<Integer> startInstJMP = new ArrayList<>(); //original - where to JMP
        ArrayList<Integer> endInstrJMP = new ArrayList<>(); //original - where to JMP

        ArrayList<Integer> startInstJMC = new ArrayList<>(); //where to JMC
        ArrayList<Integer> endInstrJMC = new ArrayList<>(); //where to JMC

        ArrayList<Integer> all = new ArrayList<>(); //NUMBERS of tagged instructions
        ArrayList<Instruction> instructs = new ArrayList<>(); //list of tagged instructions

        for(int i = 0; i < instructions.size(); i++){ //go through generated instructions
            Instruction instr = instructions.get(i);

            if(instr.getInstruction() == null){ //found tagged instruction
//                if(instr.getJmpAddr().contains("PROC_START"))
//                    continue;
                all.add(i);
                instructs.add(instr);
            }
        }

        ArrayList<Instruction> copiedInstr = new ArrayList<>();

        for (Instruction in : instructions){
            copiedInstr.add(new Instruction(in));
        }


        for(int i = 0; i < instructs.size(); i++){ //find matching tagged instruction
            Instruction firstOcc = instructs.get(i);
            String firstOccIdent = firstOcc.getJmpAddr(); //get first occ

            for(int j = i + 1; j < instructs.size(); j++){
                Instruction secOcc = instructs.get(j);
                String secOccIdent = secOcc.getJmpAddr();

                if(firstOccIdent.equals(secOccIdent)){ //found second occ
                    //check whether JMP or JMC
                    if(!firstOcc.getJmpAddr().contains("JMC")){ //JMP addr
                        startInstJMP.add(all.get(i));
                        endInstrJMP.add(all.get(j));
                        Instruction endIns = instructions.get(all.get(j));
                        endIns.setAddress(all.get(i) - removedFromList(copiedInstr, all.get(i)));
                        endIns.setInstruction(EInstrSet.JMP);
                        endIns.setLevel(0);
                    }else{ //JMC addr
                        startInstJMC.add(all.get(i));
                        endInstrJMC.add(all.get(j));

                        Instruction startIns = instructions.get(all.get(i));
                        startIns.setAddress(all.get(j) - removedFromList(copiedInstr, all.get(j)));
                        startIns.setInstruction(EInstrSet.JMC);
                        startIns.setLevel(0);
                    }
                }
            }
        }

        ArrayList<Instruction> instructionsEdit = new ArrayList<>();

        for(int i = 0; i < instructions.size(); i++) {
            if (!startInstJMP.contains(i) && !endInstrJMC.contains(i) && instructions.get(i).getInstruction() != null) {
                instructionsEdit.add(instructions.get(i));
            }
        }

        // addresses setting for cycles and ifs is done
        // now take care of recursive calls:


//        for(Instruction i : instructionsEdit){
//            System.out.println(i);
//        }


        for(int i = instructionsEdit.size() - 1; i >= 0; i --){
            Instruction currI = instructionsEdit.get(i);
            if(currI.jmpRecurTag.contains("recursion")){
                // something to change to jmp

                if(currI.jmpRecurTag.contains("recursion here")){
                    currI.setAddress(i);
                }
                else{
                    // go up and get the address:
                    // get the right tag:
                    String tag = currI.jmpRecurTag.substring("recursion ".length());
                    for(int j = i - 1; j >= 0; j --){
                        if(instructionsEdit.get(j).jmpRecurTag.equals(tag)){
                            // this is the address
                            currI.setAddress(j);
                        }
                    }
                }




            }
        }


        return instructionsEdit;
    }

    /**
     * Tells how many items were already removed from the instructions list.
     * @param instructions List which contains already generated instructions
     * @param toNum to which index we should check
     * @return number of already removed items
     */
    public static int removedFromList(ArrayList<Instruction> instructions, int toNum){
        int count = 0;

        HashMap<String, Integer> occurHM = new HashMap<>();

        for(int i = 0; i < toNum; i++){ //go through all
            Instruction instr = instructions.get(i);

            if(instr.getInstruction() == null){ //tagged one

                if(!instr.getJmpAddr().contains("JMC")){ //JMP
                    if(!occurHM.containsKey(instr.getJmpAddr())){ //first occ JMP
                        count++;
                        occurHM.put(instr.getJmpAddr(), 1);
                    }else{ //second occ JMP
                        occurHM.put(instr.getJmpAddr(), 1);
                    }
                }else{ //JMC
                    if(!occurHM.containsKey(instr.getJmpAddr())){
                        occurHM.put(instr.getJmpAddr(), 1);
                    }else{
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Adds new symbol to the table.
     */
    private void resolveDeclaration(IDeclaration st, String inProc, HashMap<String, Symbol> symbolTable, ArrayList<Instruction> instrs){
        Symbol symb = new Symbol();
        String name = null;
        String ternaryCond = null;
        String ternaryTrueVal = null;
        String ternaryFalseVal = null;
        int intWhat = -2;

        // normal declarations:
        if(st instanceof intDeclaration){
            name = ((intDeclaration) st).getIdentifierVar();
            String value = ((intDeclaration) st).getDecVal();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;
        }
        else if(st instanceof boolDeclaration){
            name = ((boolDeclaration) st).getIdentifierVar();
            String value = ((boolDeclaration) st).getBoolVal();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;
        }
        else if(st instanceof stringDeclaration){
            name = ((stringDeclaration) st).getIdentifierVar();
            String value = ((stringDeclaration) st).getStringVal();
            int size = value.length() - 2;

            symb.setValue(value);
            symb.setName(name);
            symb.setSizeArr(size);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;
            intWhat = size;

        }
        // arrays declarations:
        else if(st instanceof arrBoolDeclaration){
            name = ((arrBoolDeclaration) st).getIdentifierVar();
            int size = ((arrBoolDeclaration) st).getDecNum();

            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+= size;
            intWhat = size;
        }
        else if(st instanceof arrIntDeclaration){
            name = ((arrIntDeclaration) st).getIdentifierVar();
            int size = ((arrIntDeclaration) st).getDecNum();

            symb.setSizeArr(size);
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.ARRAY);
            symb.setInProcedure(inProc);
            declCounter+=size;
            intWhat = size;
        }

        // consts declaration:
        else if(st instanceof constBoolDeclaration){
            name = ((constBoolDeclaration) st).getIdentifierVar();
            String value = ((constBoolDeclaration) st).getBoolVal();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;
        }
        else if(st instanceof constIntDeclaration){
            name = ((constIntDeclaration) st).getIdentifierVar();
            String value = ((constIntDeclaration) st).getDecVal();

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;
        }
        else if(st instanceof constStringDeclaration){
            name = ((constStringDeclaration) st).getIdentifierVar();
            String value = ((constStringDeclaration) st).getStringVal();
            int size = value.length() - 2;

            symb.setValue(value);
            symb.setName(name);
            symb.setConst(true);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.STRING);
            symb.setInProcedure(inProc);
            declCounter+=size;
            intWhat = size;
        }

        // ternary declarations:
        else if(st instanceof boolTernarDeclaration){
            name = ((boolTernarDeclaration)st).getIdentifierVar();
            ternaryCond = ((boolTernarDeclaration)st).getExprDecBoolCont();
            ternaryTrueVal = ((boolTernarDeclaration)st).getExprDecBoolTrueVal();
            ternaryFalseVal = ((boolTernarDeclaration)st).getExprDecBoolFalseVal();
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.BOOL);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;

        }
        else if(st instanceof intTernarDeclaration){
            name = ((intTernarDeclaration)st).getIdentifierVar();
            ternaryCond = ((intTernarDeclaration)st).getExprDecBoolCont();
            ternaryTrueVal = ((intTernarDeclaration)st).getExprDecBoolTrueVal();
            ternaryFalseVal = ((intTernarDeclaration)st).getExprDecBoolFalseVal();
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
            declCounter++;
            intWhat = 1;
        }
        else if(st instanceof stringTernarDeclaration){
            name = ((stringTernarDeclaration)st).getIdentifierVar();
            ternaryCond = ((stringTernarDeclaration)st).getExprDecBoolCont();
            ternaryTrueVal = ((stringTernarDeclaration)st).getExprDecBoolTrueVal();
            ternaryFalseVal = ((stringTernarDeclaration)st).getExprDecBoolFalseVal();
            symb.setName(name);
            symb.setConst(false);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.INT);
            symb.setInProcedure(inProc);
        }

        // procedure definition:
        else if(st instanceof procedureDefinition){
            name = ((procedureDefinition) st).getIdentifierVar();
            String params = ((procedureDefinition) st).getParameters();

            symb.setName(name);
            symb.setProcParameters(params);
            symb.setAdr(declCounter);
            symb.setLev(0);
            symb.setType(ESymbolType.PROCEDURE);
            symb.setInProcedure(inProc);

            // prepare addresses for arguments and store them in the private table
            ArrayList<Symbol> args = ((procedureDefinition)st).getIndivParameters();
            // we dont know the values yet, but we will store it in the table and in the list of args:
            for(int i = 0; i < ((procedureDefinition)st).getIndivParameters().size(); i++){
                args.get(i).setAdr(declCounter);
                declCounter++;
                ((procedureDefinition)st).getPrivateSymbolTable().put(args.get(i).getName(), args.get(i));
                ((procedureDefinition)st).getArgs().add(args.get(i)); // adding the same instance to both
                args.get(i).setHasBeenDeclared(true);
            }

            // prepare the space in the stack:
            if(((procedureDefinition)st).getIndivParameters().size() > 0)
                instrs.add(new Instruction(EInstrSet.INT, 0, ((procedureDefinition)st).getIndivParameters().size()));

            procedureDefinitions.add((procedureDefinition)st);

            symb.setHasBeenDeclared(true);
            symbolTable.put(name, symb);

            return;
        }

        if(symbolTable.containsKey(name)){
            Error.printMultipleDefines(name);
        }

        symb.setHasBeenDeclared(false);
        symbolTable.put(name, symb);

        if(st instanceof boolTernarDeclaration || st instanceof intTernarDeclaration || st instanceof stringTernarDeclaration){
            int ins = instrs.size();
            instrs.addAll(TernaryAssignmentInstructions.generateInstructions(st, symb, ternaryCond, ternaryTrueVal, ternaryFalseVal, -1, globalSymbolTable, symbolTable));
            // value is set in ternary assignment instructions

            if(st instanceof stringTernarDeclaration){
                declCounter += symb.getValue().length();
                intWhat = symb.getValue().length();
            }
            instrs.add(ins, new Instruction(EInstrSet.INT, 0, intWhat));
        }
        else{
            if(!(st instanceof procedureDefinition))
                instrs.add(new Instruction(EInstrSet.INT, 0, intWhat));
            if(!(st instanceof arrBoolDeclaration) && !(st instanceof arrIntDeclaration)){
                // array declaration doesn't produce any instructions
                instrs.addAll(VarAssignmentInstructions.generateInstructions(symb, symb.getValue(), -1, globalSymbolTable, symbolTable, true, true));

                symb.setHasBeenDeclared(true);

                // multi?
                if(((IoneLineStatement)st).getIdentifierMulti().size() > 0){
                    IoneLineStatement oneLine = ((IoneLineStatement)st);
                    ArrayList<String> idents = oneLine.getIdentifierMulti();

                    for(int i = 0; i < idents.size(); i++){
                        if(st instanceof stringDeclaration || st instanceof constStringDeclaration){
                            Symbol newS = new Symbol(symb);
                            newS.setName(idents.get(i));
                            newS.setAdr(declCounter);
                            newS.setHasBeenDeclared(true);
                            declCounter+=symb.getValue().length();

                            instrs.add(new Instruction(EInstrSet.INT, 0, symb.getValue().length()));

                            for(int j = 0; j < symb.getValue().length(); j++){
                                instrs.add(new Instruction(EInstrSet.LOD, 0, symb.getAdr() + j));
                                instrs.add(new Instruction(EInstrSet.STO, 0, newS.getAdr() + j));
                            }
                            symbolTable.put(newS.getName(), newS);
                        }
                        else{
                            Symbol newS = new Symbol(symb);
                            newS.setName(idents.get(i));
                            newS.setAdr(declCounter);
                            newS.setHasBeenDeclared(true);
                            declCounter++;

                            instrs.add(new Instruction(EInstrSet.INT, 0, 1));
                            instrs.add(new Instruction(EInstrSet.LOD, 0, symb.getAdr()));
                            instrs.add(new Instruction(EInstrSet.STO, 0, newS.getAdr()));

                            symbolTable.put(newS.getName(), newS);
                        }
                    }
                }
            }
        }

        symb.setHasBeenDeclared(true);
    }

    /**
     * Accepts one multiline statement (implements ImultiLineStatement) for which PL0 instructions should be generated. Contains recursive logic to get individual oneline statements.
     * @param procedure reference to procedure which contains the specific statement
     * @param statement instance which represents multiline statement (implements ImultiLineStatement)
     */
    private void solvRecurMultiLine(ImultiLineStatement statement, procedureDefinition procedure){
        ArrayList<Istatement> innerStatements = statement.getInnerStatements(); //inner statements included in multiline statement

        for(int j = 0; j < innerStatements.size(); j++){ //go thru inner statements of multiline
            Istatement innerStatement = innerStatements.get(j); //get one inner statement

            if(innerStatement instanceof ImultiLineStatement){//inner statement could be multi -> recursive call to retrieve oneline
                ImultiLineStatement multiStatement = (ImultiLineStatement) innerStatement; //cast to multiline

                innerCounter += 1;

                if(innerStatement instanceof ifCondition){
                    ifCondition ic = (ifCondition) innerStatement;
                    String value = ic.getExprDecBoolCont();
                    procedure.getInstructions().addAll(IfInstructions.generateInstructions((Istatement) innerStatement, value, globalSymbolTable, procedure.getPrivateSymbolTable()));
                }
                //generate FIRST part of the cycle (before inner statements) + HERE ASSIGN INNER LEVEL
                else if(innerStatement instanceof doWhileCycle){ //check for cycles - START
                    procedure.getInstructions().addAll(CycleInstructions.generateDoWhileInstructions1((doWhileCycle) innerStatement, innerCounter));
                }else if(innerStatement instanceof forCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateForInstructions1((forCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                }else if(innerStatement instanceof foreachCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateForeachInstructions1((foreachCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                }else if(innerStatement instanceof repeatUntilCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateRepeatUntilInstructions1((repeatUntilCycle) innerStatement, innerCounter));
                }else if(innerStatement instanceof whileCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateWhileInstructions1((whileCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable(), innerCounter));
                } //check for cycles - END
                solvRecurMultiLine(multiStatement, procedure); //recursive call
                //generate SECOND part of the cycle (after inner statements)
                if(innerStatement instanceof ifCondition){
                    procedure.getInstructions().addAll(IfInstructions.generateInstructionsEnd((Istatement) innerStatement));
                }
                else if(innerStatement instanceof doWhileCycle){ //check for cycles - START
                    procedure.getInstructions().addAll(CycleInstructions.generateDoWhileInstructions2((doWhileCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable())); //no instruction generated in first part
                }else if(innerStatement instanceof forCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateForInstructions2((forCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable())); //jump to 3. inst from first part
                }else if(innerStatement instanceof foreachCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateForeachInstructions2((foreachCycle) innerStatement, globalSymbolTable)); //jump to 3. inst from first part
                }else if(innerStatement instanceof repeatUntilCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateRepeatUntilInstructions2((repeatUntilCycle) innerStatement, globalSymbolTable, procedure.getPrivateSymbolTable())); //no instruction generated in first part
                }else if(innerStatement instanceof whileCycle){
                    procedure.getInstructions().addAll(CycleInstructions.generateWhileInstructions2((whileCycle) innerStatement)); //jump to 3. inst from first part
                } //check for cycles - END

                innerCounter -= 1;
            }else{ //statement is oneline - generate respective instructions
                if(innerStatement instanceof IDeclaration){
                    resolveDeclaration((IDeclaration) innerStatement, procedure.getIdentifierVar(), procedure.getPrivateSymbolTable(), procedure.getInstructions());
                }
                else if(innerStatement instanceof unknownAssign){
                    unknownAssign ua = (unknownAssign)innerStatement;
                    String ident = ua.getIdentifierVar();
                    String value = ua.getValueVar();

                    if(procedure.getPrivateSymbolTable().containsKey(ident)){ // look in the local table first
                        Symbol s = procedure.getPrivateSymbolTable().get(ident);

                        procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, -1, globalSymbolTable, procedure.getPrivateSymbolTable(), true, true));
                    }
                    else if(globalSymbolTable.containsKey(ident)){
                        Symbol s = globalSymbolTable.get(ident);
                        procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, -1, globalSymbolTable,procedure.getPrivateSymbolTable(), true, true));
                    }
                    else{
                        Error.printVarNotFound(ident);
                    }
                }
                else if(innerStatement instanceof unknownArrAssign){
                    unknownArrAssign uaa = (unknownArrAssign) innerStatement;
                    String ident = uaa.getIdentifierVar();
                    String value = uaa.getValueVar();
                    int indexToAssignTo = uaa.getIndexToAssign();

                    if(procedure.getPrivateSymbolTable().containsKey(ident)){
                        Symbol s = procedure.getPrivateSymbolTable().get(ident);

                        if(indexToAssignTo >= s.getSizeArr()){
                            Error.printOutOfBounds(ident, indexToAssignTo);
                        }
                        procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, indexToAssignTo, globalSymbolTable, procedure.getPrivateSymbolTable(), true, true));
                    }
                    else if(globalSymbolTable.containsKey(ident)){
                        Symbol s = globalSymbolTable.get(ident);
                        if(indexToAssignTo >= s.getSizeArr()){
                            Error.printOutOfBounds(ident, indexToAssignTo);
                        }
                        procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, value, indexToAssignTo, globalSymbolTable,procedure.getPrivateSymbolTable(), true, true));
                    }
                    else{
                        Error.printVarNotFound(ident);
                    }
                }
                else if(innerStatement instanceof ternarAssign){
                    ternarAssign ta = (ternarAssign) innerStatement;
                    String ident = ta.getIdentifierVar();
                    String cond = ta.getExprDecBoolCont();
                    String trueVal = ta.getExprDecBoolTrueVal();
                    String falseVal = ta.getExprDecBoolFalseVal();

                    if(procedure.getPrivateSymbolTable().containsKey(ident)){
                        Symbol s = procedure.getPrivateSymbolTable().get(ident);
                        procedure.getInstructions().addAll(TernaryAssignmentInstructions.generateInstructions(innerStatement, s, cond, trueVal, falseVal, -1, globalSymbolTable, procedure.getPrivateSymbolTable()));
                    }
                    else if(globalSymbolTable.containsKey(ident)){
                        Symbol s = globalSymbolTable.get(ident);
                        procedure.getInstructions().addAll(TernaryAssignmentInstructions.generateInstructions(innerStatement, s, cond, trueVal, falseVal, -1, globalSymbolTable, procedure.getPrivateSymbolTable()));
                    }
                    else{
                        Error.printVarNotFound(ident);
                    }
                }
                else if(innerStatement instanceof procedureCall){
                    procedureCall pc = (procedureCall) innerStatement;
                    String name = pc.getIdentifierVar();

                    // only in global
                    if(globalSymbolTable.containsKey(name)){
                        // we know such a procedure
                        // check if number of arguments match
                        procedureDefinition calledProc = null;
                        for(procedureDefinition p : procedureDefinitions){
                            if(p.getIdentifierVar().equals(name)){
                                calledProc = p;
                                break;
                            }
                        }

                        if(calledProc == null){
                            break;
                        }

                        if(pc.getIndivArguments().size() != calledProc.getArgs().size()){
                            Error.printUnmatchingArgs(calledProc.getIdentifierVar());
                        }
                        else {
                            for(int k = 0; k < calledProc.getArgs().size(); k++){
                                Symbol s = calledProc.getArgs().get(k);
                                String valInArg = pc.getIndivArguments().get(k);
                                procedure.getInstructions().addAll(VarAssignmentInstructions.generateInstructions(s, valInArg, -1, globalSymbolTable, procedure.getPrivateSymbolTable(), true, false));
                            }

                            // and add the called procedure's instructions to the current procedure's instructions:
                            //procedure.getInstructions().addAll(calledProc.getInstructions());


                            if(procedure.getIdentifierVar().equals(calledProc.getIdentifierVar())){
                                // same name - recursion

                                // add a tag to show where the procedure starts
                                if(procedure.getInstructions().size() > 0){
                                    procedure.getInstructions().get(0).jmpRecurTag = "" + procedure;
                                    //procedure.getInstructions().add(new Instruction("recursion " + calledProc));

                                    Instruction newIn = new Instruction(EInstrSet.JMP, 0, -1);
                                    newIn.jmpRecurTag = "recursion " + calledProc;
                                    procedure.getInstructions().add(newIn);
                                }
                                else{
                                    Instruction newIn = new Instruction(EInstrSet.JMP, 0, -1);
                                    newIn.jmpRecurTag = "recursion here " + calledProc;
                                    procedure.getInstructions().add(newIn);
                                    //procedure.getInstructions().add(new Instruction("recursion here " + calledProc));
                                }



                            }
                            else{
                                // and add the called procedure's instructions to the current procedure's instructions:
                                procedure.getInstructions().addAll(calledProc.getInstructions());
                            }


                        }
                    }
                    else{
                        Error.printVarNotFound(name);
                    }
                }
            }
        }
    }

    /**
     * Accepts one oneline statement (implements IoneLineStatement) to which we then assign inner level.
     * @param statement instance which represents oneline statement (implements IoneLineStatement)
     * @param statementType HashMap contains concrete type of oneline statement (ie.STRING_DECLARATION and so on)
     * @param innerLevel level - inner statements
     */
    private static void generateOneline(IoneLineStatement statement, HashMap<Istatement, EallStatementType> statementType, int innerLevel){
        ((Istatement)statement).setInnerLevel(innerLevel); //assign level first
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
                }else if(statement instanceof boolTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.BOOL_TERNAR_DECLARATION);
                }else if(statement instanceof intTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.INT_TERNAR_DECLARATION);
                }else if(statement instanceof stringTernarDeclaration){
                    statementTypeMap.put(statement, EallStatementType.STRING_TERNAR_DECLARATION);
                }else if(statement instanceof constArrBoolDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_ARR_BOOL_DECLARATION);
                }else if(statement instanceof constArrIntDeclaration){
                    statementTypeMap.put(statement, EallStatementType.CONST_ARR_INT_DECLARATION);
                }else if(statement instanceof ternarAssign){
                    statementTypeMap.put(statement, EallStatementType.TERNAR_ASSIGN);
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
