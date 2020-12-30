package visitors;

import generated.ourCBaseVisitor;
import generated.ourCParser;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.List;

public class VarAssVisitor extends ourCBaseVisitor {
    ArrayList<Istatement> encounteredStatements; //list of ALL recognized statements (oneline + multiline)
    ArrayList<ImultiLineStatement> encounteredMultiStatements; //list of encountered MULTIstatements

    ArrayList<Integer> toPutInsideArr; //on each index holds number of one-line statements which should be added into respective multi-line "ArrayList<Istatement> innerStatementsList"

    boolean visitedTernDecl; //true when ternar_declaration was visited ; reset to false when visit ternar_assignment
    String ternDecType; //contains type of delcared value - string, bool or int

    public ArrayList<Istatement> getEncounteredStatements() {
        return encounteredStatements;
    }

    /**
     * Adds given statements to ArrayList<Istatement> encounteredStatements or binds the statement to multiline statement which is already present in the mentioned array.
     * @param statement statements (implements Istatement), which should be added to statement list
     */
    void addStatement(Istatement statement){
        ImultiLineStatement nonFilledMultiStatement = findMultiStatementToAssign();

        if(nonFilledMultiStatement != null){ //not null -> assign new statement to already existing one
            nonFilledMultiStatement.addInnerStatement(statement);
        }else{ //null -> statement is NOT inside any multistatement, stands alone ; put to ArrayList<Istatement> encounteredStatements
            encounteredStatements.add(statement);
        }
    }

    /**
     * Finds multiline element to which newly encountered statement should be assigned (ArrayList<Istatement> innerStatementsList).
     * @return instance of ImultiLineStatement which represents wanted multiline statement to which new statements should be assigned
     */
    ImultiLineStatement findMultiStatementToAssign(){
        ImultiLineStatement toReturn = null; //instance of ImultiLineStatement which should be returned

        for(int i = encounteredMultiStatements.size() - 1; i >= 0; i--){ //got list of multiline statements, go from end and find last one which value in toPutInsideArr is != 0
            ImultiLineStatement multiStatement = encounteredMultiStatements.get(i); //get one multistatement

            if(toPutInsideArr.get(i) != 0){ //OK, got target, value -1 ; return
                toPutInsideArr.set(i, toPutInsideArr.get(i) - 1);
                toReturn = multiStatement;
                break;
            }
        }

        return toReturn;
    }

    public VarAssVisitor(){
        encounteredStatements = new ArrayList<Istatement>();
        encounteredMultiStatements = new ArrayList<ImultiLineStatement>();
        toPutInsideArr = new ArrayList<Integer>(); //how many statements (ie. code_blocks should be attached to last multistatement)
        visitedTernDecl = false;
        ternDecType = "";
    }

    /* visited on int assign, string assign, bool assign, arr int assign, arr bool assign, int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration,
    const int declaration, const bool declaration, const string declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition,
    ternar assign */
    @Override
    public Object visitCode_block(ourCParser.Code_blockContext ctx) {
        if(ctx.CON_IF() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //if statement
            /* relevant statement info to keep - START */
            String exprDecBoolCont; //conditions written in between brackets after while
            /* relevant statement info to keep - END */

            if(ctx.expr_dec_bool() != null){
                ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool().get(0);
                exprDecBoolCont = treeItem1.getText();

                ifCondition ifCond = new ifCondition();
                ifCond.setExprDecBoolCont(exprDecBoolCont);
                addStatement(ifCond);
                encounteredMultiStatements.add((ImultiLineStatement) ifCond);

                System.out.println("If statement created with " + exprDecBoolCont);
            }
        }else if(ctx.CYC_DO() != null && ctx.CYC_WHILE() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //do-while cycle
            /* relevant statement info to keep - START */
            String exprDecBoolCont; //conditions written in between brackets after while
            /* relevant statement info to keep - END */

            if(ctx.expr_dec_bool() != null){
                ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool().get(0);
                exprDecBoolCont = treeItem1.getText();

                doWhileCycle doWhileCyc = new doWhileCycle();
                doWhileCyc.setExprDecBoolCont(exprDecBoolCont);
                addStatement(doWhileCyc);
                encounteredMultiStatements.add((ImultiLineStatement) doWhileCyc);

                System.out.println("Do while cycle created with " + exprDecBoolCont);
            }
        }else if(ctx.CYC_FOR() != null && ctx.TO() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //for cycle
            /* relevant statement info to keep - START */
            String identifierVar;//name of the variable, from which will cycle begin
            String exprDecBool1;//value of the variable in the beginning of the cycle
            String exprDecBool2;//value of the variable in the end of the cycle (value after TO)
            /* relevant statement info to keep - END */

            if(ctx.identifier_var() != null && ctx.expr_dec_bool() != null){
                ourCParser.Identifier_varContext treeItem1 = ctx.identifier_var().get(0);
                identifierVar = treeItem1.getText();

                List<ourCParser.Expr_dec_boolContext> treeItem2 = ctx.expr_dec_bool();

                exprDecBool1 = treeItem2.get(0).getText();
                exprDecBool2 = treeItem2.get(1).getText();

                forCycle forCyc = new forCycle();
                forCyc.setIdentifierVar(identifierVar);
                forCyc.setExprDecBool1(exprDecBool1);
                forCyc.setExprDecBool2(exprDecBool2);

                addStatement(forCyc);
                encounteredMultiStatements.add((ImultiLineStatement) forCyc);

                System.out.println("For cycle created with start: " + exprDecBool1 + " and end: " + exprDecBool2 + ", variable name is: " + identifierVar);
            }
        }else if(ctx.CYC_FOREACH() != null && ctx.COLON() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //foreach cycle
            /* relevant statement info to keep - START */
            String identifierVar1;//name of the variable, which will be taken in count (represents one value in array)
            String identifierVar2;//name of the array, which will be traversed
            /* relevant statement info to keep - END */

            if(ctx.identifier_var() != null){
                List<ourCParser.Identifier_varContext> treeItem1 = ctx.identifier_var();

                identifierVar1 = treeItem1.get(0).getText();
                identifierVar2 = treeItem1.get(1).getText();

                foreachCycle forEachCyc = new foreachCycle();
                forEachCyc.setIdentifierVar1(identifierVar1);
                forEachCyc.setIdentifierVar2(identifierVar2);

               addStatement(forEachCyc);
               encounteredMultiStatements.add((ImultiLineStatement) forEachCyc);

                System.out.println("Foreach cycle created with ident1: " + identifierVar1 + ", ident2: " + identifierVar2);
            }
        }else if(ctx.CYC_REPEAT() != null && ctx.CYC_UNTIL() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //repeat-until cycle
            /* relevant statement info to keep - START */
            String exprDecBoolCont; //conditions written in between brackets after until
            /* relevant statement info to keep - END */

            if(ctx.expr_dec_bool() != null){
                ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool().get(0);
                exprDecBoolCont = treeItem1.getText();

                repeatUntilCycle repeatUntilCyc = new repeatUntilCycle();
                repeatUntilCyc.setExprDecBoolCont(exprDecBoolCont);
                addStatement(repeatUntilCyc);
                encounteredMultiStatements.add((ImultiLineStatement) repeatUntilCyc);

                System.out.println("Repeat until cycle created with " + exprDecBoolCont);
            }
        }else if(ctx.CYC_WHILE() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //while cycle
            /* relevant statement info to keep - START */
            String exprDecBoolCont; //conditions written in between brackets after while
            /* relevant statement info to keep - END */

            if(ctx.expr_dec_bool() != null){
                ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool().get(0);
                exprDecBoolCont = treeItem1.getText();

                whileCycle whileCyc = new whileCycle();
                whileCyc.setExprDecBoolCont(exprDecBoolCont);
                addStatement(whileCyc);
                encounteredMultiStatements.add((ImultiLineStatement) whileCyc);

                System.out.println("While cycle created with " + exprDecBoolCont);
            }
        }

        return super.visitCode_block(ctx);
    }

    /* visited on arr int assign, arr bool assign */
    @Override
    public Object visitArr_assignment(ourCParser.Arr_assignmentContext ctx) {
        /* info relevant to variable assign - START */
        String assignVarName; //name of the variable
        boolean assignVarMinusSign = false; //true if minus sign is present; else false ; used just on int assign...
        String assignVarValue; //newly assigned value of the variable (bool or int)
        int indexToInsert; //to which index value should be inserted
        /* info relevant to variable assign - END */

        assignVarName = ctx.identifier_var().getText();
        indexToInsert = Integer.valueOf(ctx.DEC_NUM().getText());

        if(ctx.expr_dec_bool() != null){ //target is boolean or int
            ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool();

            assignVarValue = treeItem1.getText();
            if(treeItem1.OP_MINUS() != null){ //minus sign present
                assignVarMinusSign = true;
            }else{ //plus or no sign present in assignment...
                assignVarMinusSign = false;
            }
        }else{
            assignVarValue = ""; //should NEVER occur...
            indexToInsert = 0;
        }

        unknownArrAssign unkArrAssign = new unknownArrAssign();
        unkArrAssign.setIdentifierVar(assignVarName);
        unkArrAssign.setMinusSign(assignVarMinusSign);
        unkArrAssign.setValueVar(assignVarValue);
        unkArrAssign.setIndexToAssign(indexToInsert);

        System.out.println("Array assignment created\n" + unkArrAssign.getIdentifierVar() + ", " + unkArrAssign.isMinusSign() + ", " + unkArrAssign.getValueVar() + ", " + unkArrAssign.getIndexToAssign());
        addStatement(unkArrAssign);

        return super.visitArr_assignment(ctx);
    }

    /* visited on int assign, string assign, bool assign, if condition, do-while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition */
    @Override
    public Object visitVar_assignment(ourCParser.Var_assignmentContext ctx) {
        /* info relevant to variable assign - START */
        String assignVarName; //name of the variable
        boolean assignVarMinusSign = false; //true if minus sign is present; else false ; used just on int assign...
        String assignVarValue; //newly assigned value of the  variable (int, bool or string) -> convert after...
        /* info relevant to variable assign - END */

        assignVarName = ctx.identifier_var().getText();

        if(ctx.expr_dec_bool() != null){ //target is boolean or int
            ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool();

            assignVarValue = treeItem1.getText();
            if(treeItem1.OP_MINUS() != null){ //minus sign present
                assignVarMinusSign = true;
            }else{ //plus or no sign present in assignment...
                assignVarMinusSign = false;
            }
        }else if(ctx.expr_string() != null){ //target is string
            System.out.println("targeting string");
            ourCParser.Expr_stringContext treeItem1 = ctx.expr_string();

            assignVarValue = treeItem1.getText();
        }else{
            assignVarValue = ""; //should NEVER occur...
        }

        unknownAssign unkAssign = new unknownAssign();
        unkAssign.setIdentifierVar(assignVarName);
        unkAssign.setMinusSign(assignVarMinusSign);
        unkAssign.setValueVar(assignVarValue);

        System.out.println("Var assignment created\n" + unkAssign.getIdentifierVar() + ", " + unkAssign.isMinusSign() + ", " + unkAssign.getValueVar());
        addStatement(unkAssign);

        return super.visitVar_assignment(ctx);
    }

    /* visited on int assign, string assign, bool assign, arr int assign, arr bool assign, int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration,
    const int declaration, const bool declaration, const string declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition,
     ternar assign */
    @Override
    public Object visitIdentifier_var(ourCParser.Identifier_varContext ctx) {
        return super.visitIdentifier_var(ctx);
    }

    /* visited on int assign, bool assign, arr bool assign, arr int assign, int declaration, bool declaration, const int declaration, const bool declaration, if condition, do-while cycle,
    * while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition, ternar assign */
    @Override
    public Object visitExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx) {
        return super.visitExpr_dec_bool(ctx);
    }

    /* visited on int assign, arr int assign, int declaration, const int declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle,
    procedure definition */
    @Override
    public Object visitDec_val(ourCParser.Dec_valContext ctx) {
        return super.visitDec_val(ctx);
    }

    /* visited on int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration, const int declaration, const bool declaration, const string declaration,
    * while cycle */
    @Override
    public Object visitVar_declaration(ourCParser.Var_declarationContext ctx) {
        return super.visitVar_declaration(ctx);
    }

    /* visited on arr int declaration, arr bool declaration */
    @Override
    public Object visitArray_var_dec(ourCParser.Array_var_decContext ctx) {
        return super.visitArray_var_dec(ctx);
    }

    /* visited on string assign, string declaration, const string declaration */
    @Override
    public Object visitString_val(ourCParser.String_valContext ctx) {
        return super.visitString_val(ctx);
    }

    /* visited on bool assign, arr bool assign, bool declaration, const bool declaration */
    @Override
    public Object visitBool_val(ourCParser.Bool_valContext ctx) {
        return super.visitBool_val(ctx);
    }

    /* visited on bool declaration, const bool declaration */
    @Override
    public Object visitBool_var_dec(ourCParser.Bool_var_decContext ctx) {
        return super.visitBool_var_dec(ctx);
    }

    /* visited on string declaration, const string declaration */
    @Override
    public Object visitString_var_dec(ourCParser.String_var_decContext ctx) {
        return super.visitString_var_dec(ctx);
    }

    /* visited on int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration, while cycle */
    @Override
    public Object visitVar_non_const_dec_command(ourCParser.Var_non_const_dec_commandContext ctx) {
        /* info relevant to variable declaration - START */
        String declVarName; //name of the NEW variable
        boolean declVarMinusSign; //true if minus sign is present; else false
        String declVarValue; //value of the NEW variable (int, bool or string) -> convert after...
        /* info relevant to variable declaration - END */

        /* info relevant to array declaration - START */
        String declArrName; //name of the NEW array
        int declArrsize; //size of the NEW array
        /* info relevant to array declaration - END */

        if(ctx.decimal_var_dec() != null){ //decimal value
            ourCParser.Decimal_var_decContext treeItem1 = ctx.decimal_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the variable

            if(treeItem1.sign_whole_num() != null){ //plus or minus sign
                if(treeItem1.sign_whole_num().getText().equals("+")){
                    declVarMinusSign = false;
                }else{
                    declVarMinusSign = true;
                }
            }else{
                declVarMinusSign = false;
            }

            intDeclaration intDeclar = new intDeclaration();
            intDeclar.setIdentifierVar(declVarName);
            intDeclar.setMinus_sign(declVarMinusSign);
            intDeclar.setDecVal(declVarValue);
            System.out.println("INT declaration \n" + intDeclar.getIdentifierVar() + ", " + intDeclar.isMinus_sign() + ", " + intDeclar.getDecVal());

            addStatement(intDeclar);
        }else if(ctx.bool_var_dec() != null){ //bool value
            ourCParser.Bool_var_decContext treeItem1 = ctx.bool_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of BOOL the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the BOOL variable

            boolDeclaration boolDeclar = new boolDeclaration();
            boolDeclar.setIdentifierVar(declVarName);
            boolDeclar.setBoolVal(declVarValue);
            System.out.println("BOOL declaration\n" + boolDeclar.getIdentifierVar() + ", " + boolDeclar.getBoolVal());
            addStatement(boolDeclar);
        }else if(ctx.string_var_dec() != null){ //string value
            ourCParser.String_var_decContext treeItem1 = ctx.string_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of STRING the variable
            declVarValue = treeItem1.expr_string().getText(); //value of the STRING variable

            stringDeclaration stringDeclar = new stringDeclaration();
            stringDeclar.setIdentifierVar(declVarName);
            stringDeclar.setStringVal(declVarValue);
            System.out.println("STRING declaration\n" + stringDeclar.getIdentifierVar() + ", " + stringDeclar.getStringVal());
            addStatement(stringDeclar);
        }else if(ctx.array_var_dec() != null){
            ourCParser.Array_var_decContext treeItem1 = ctx.array_var_dec();

            declArrName = treeItem1.identifier_var().IDENT().getText();
            declArrsize = Integer.valueOf(treeItem1.DEC_NUM().getText());

            if(ctx.array_var_dec().INT() != null){ //want to declare int array
                arrIntDeclaration arrIntDeclar = new arrIntDeclaration();
                arrIntDeclar.setIdentifierVar(declArrName);
                arrIntDeclar.setDecNum(declArrsize);
                System.out.println("INT ARR declaration\n" + arrIntDeclar.getIdentifierVar() + ", " + arrIntDeclar.getDecNum());
                addStatement(arrIntDeclar);
            }else{ //want to declare bool array
                arrBoolDeclaration arrBoolDeclar = new arrBoolDeclaration();
                arrBoolDeclar.setIdentifierVar(declArrName);
                arrBoolDeclar.setDecNum(declArrsize);
                System.out.println("BOOL ARR declaration: " + arrBoolDeclar.getIdentifierVar() + ", " + arrBoolDeclar.getDecNum());
                addStatement(arrBoolDeclar);
            }
        }else{
            //error, tbd
        }
        return super.visitVar_non_const_dec_command(ctx);
    }

    /* visited on const int declaration, const bool declaration, const string declaration */
    @Override
    public Object visitVar_const_dec_command(ourCParser.Var_const_dec_commandContext ctx) {
        /* info relevant to variable declaration - START */
        String declVarName; //name of the NEW const variable
        boolean declVarMinusSign; //true if minus sign is present; else false
        String declVarValue; //value of the NEW const variable (int, bool or string) -> convert after...
        /* info relevant to variable declaration - END */

        /* info relevant to array declaration - START */
        String declArrName; //name of the NEW array
        int declArrsize; //size of the NEW array
        /* info relevant to array declaration - END */

        if(ctx.decimal_var_dec() != null){ //decimal value
            ourCParser.Decimal_var_decContext treeItem1 = ctx.decimal_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of the const variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the const variable

            if(treeItem1.sign_whole_num() != null){ //plus or minus sign
                if(treeItem1.sign_whole_num().getText().equals("+")){
                    declVarMinusSign = false;
                }else{
                    declVarMinusSign = true;
                }
            }else{
                declVarMinusSign = false;
            }

            constIntDeclaration constIntDeclar = new constIntDeclaration();
            constIntDeclar.setIdentifierVar(declVarName);
            constIntDeclar.setMinus_sign(declVarMinusSign);
            constIntDeclar.setDecVal(declVarValue);
            System.out.println("INT const declaration \n" + constIntDeclar.getIdentifierVar() + ", " + constIntDeclar.isMinus_sign() + ", " + constIntDeclar.getDecVal());
            addStatement(constIntDeclar);
        }else if(ctx.bool_var_dec() != null){ //bool value
            ourCParser.Bool_var_decContext treeItem1 = ctx.bool_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of BOOL the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the BOOL variable

            constBoolDeclaration constBoolDeclar = new constBoolDeclaration();
            constBoolDeclar.setIdentifierVar(declVarName);
            constBoolDeclar.setBoolVal(declVarValue);
            System.out.println("BOOL const declaration\n" + constBoolDeclar.getIdentifierVar() + ", " + constBoolDeclar.getBoolVal());
            addStatement(constBoolDeclar);
        }else if(ctx.string_var_dec() != null){ //string value
            ourCParser.String_var_decContext treeItem1 = ctx.string_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of STRING the variable
            declVarValue = treeItem1.expr_string().getText(); //value of the STRING variable

            constStringDeclaration constStringDeclar = new constStringDeclaration();
            constStringDeclar.setIdentifierVar(declVarName);
            constStringDeclar.setStringVal(declVarValue);
            System.out.println("STRING const declaration\n" + constStringDeclar.getIdentifierVar() + ", " + constStringDeclar.getStringVal());
            addStatement(constStringDeclar);
        }else if(ctx.array_var_dec() != null){
            ourCParser.Array_var_decContext treeItem1 = ctx.array_var_dec();

            declArrName = treeItem1.identifier_var().IDENT().getText();
            declArrsize = Integer.valueOf(treeItem1.DEC_NUM().getText());

            if(ctx.array_var_dec().INT() != null){ //want to declare int array
                constArrIntDeclaration constArrIntDeclar = new constArrIntDeclaration();
                constArrIntDeclar.setIdentifierVar(declArrName);
                constArrIntDeclar.setDecNum(declArrsize);
                System.out.println("CONST INT ARR declaration\n" + constArrIntDeclar.getIdentifierVar() + ", " + constArrIntDeclar.getDecNum());
                addStatement(constArrIntDeclar);
            }else{ //want to declare bool array
                constArrBoolDeclaration constArrBoolDeclar = new constArrBoolDeclaration();
                constArrBoolDeclar.setIdentifierVar(declArrName);
                constArrBoolDeclar.setDecNum(declArrsize);
                System.out.println("CONST BOOL ARR declaration: " + constArrBoolDeclar.getIdentifierVar() + ", " + constArrBoolDeclar.getDecNum());
                addStatement(constArrBoolDeclar);
            }
        }else{
            //error, tbd
        }
        return super.visitVar_const_dec_command(ctx);
    }

    /* visited on int declaration, const int declaration, while cycle */
    @Override
    public Object visitDecimal_var_dec(ourCParser.Decimal_var_decContext ctx) {
        return super.visitDecimal_var_dec(ctx);
    }

    /* visited on if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition */
    @Override
    public Object visitBlock_body(ourCParser.Block_bodyContext ctx) {
        if(ctx.code_block() != null){ //could be more code_block in block_body
            int codeBlockCount = ctx.code_block().size();
            System.out.println("Code block count is: " + codeBlockCount);
            toPutInsideArr.add(codeBlockCount);
        }

        return super.visitBlock_body(ctx);
    }

    /* visited on procedure call */
    @Override
    public Object visitCall_proc(ourCParser.Call_procContext ctx) {
        /* relevant statement info to keep - START */
        String identifierVar = ""; //name of the called procedure
        String arguments = ""; //arguments given in between brackets after procedure name
        /* relevant statement info to keep - END */

        if(ctx.identifier_var() != null){ //name of the procedure
            identifierVar = ctx.identifier_var().getText();
        }

        if(ctx.expr_dec_bool() != null){ //names of parameters in parentheses
            List<ourCParser.Expr_dec_boolContext> treeItem1 = ctx.expr_dec_bool();

            for(int i = 0; i < treeItem1.size(); i++){
                if(i != 0){ //first item traversed, dnt add comma
                    arguments += ",";
                }

                arguments += treeItem1.get(i).getText();
            }
        }

        procedureCall procCall = new procedureCall();
        procCall.setIdentifierVar(identifierVar);
        procCall.setArguments(arguments);

        addStatement(procCall);
        System.out.println("Procedure called: name: " + identifierVar + ", args: " + arguments);

        return super.visitCall_proc(ctx);
    }

    /* visited on procedure definition */
    @Override
    public Object visitDef_proc(ourCParser.Def_procContext ctx) {
        if(ctx.PROC_DEF() != null && ctx.LEFT_BASIC_BRACK() != null && ctx.RIGHT_BASIC_BRACK() != null){ //procedure definition
            /* relevant statement info to keep - START */
            String identifierVar = ""; //name of the NEW procedure
            ArrayList<String> parameters = new ArrayList<String>(); //contains parameters (content in brackets after procedure name)
            /* relevant statement info to keep - END */

            if(ctx.identifier_var() != null){ //name of the procedure
                identifierVar = ctx.identifier_var().getText();
            }

            String[] splitContent = ctx.getText().split("\\("); //names of parameters in parentheses
            splitContent = splitContent[1].split("\\)");
            System.out.println("Def is: " + splitContent[0]);

            String[] indivParams = splitContent[0].split(",");
            for(int i = 0; i < indivParams.length; i++){
                if(indivParams[i].startsWith("bool")){
                    indivParams[i] = indivParams[i].replaceFirst("bool", "bool ");
                }else if(indivParams[i].startsWith("int")){
                    indivParams[i] = indivParams[i].replaceFirst("int", "int ");
                }else if(indivParams[i].startsWith("string")){
                    indivParams[i] = indivParams[i].replaceFirst("string", "string ");
                }
            }

            String params = "";
            for(int i = 0; i < indivParams.length; i++){
                if(params.length() != 0){
                    params += ",";
                }

                params += indivParams[i];
            }

            procedureDefinition procDef = new procedureDefinition();
            procDef.setIdentifierVar(identifierVar);
            procDef.setParameters(params);

            addStatement(procDef);
            encounteredMultiStatements.add((ImultiLineStatement) procDef);
            System.out.println("Procedure defined: name: " + identifierVar + ", params: " + params);
        }

        return super.visitDef_proc(ctx);
    }

    /* visited on ternar assignment */
    @Override
    public Object visitTernar_assignment(ourCParser.Ternar_assignmentContext ctx) {
        /* relevant statement info to keep - START */
        String identifierVar = ""; //name of the variable, which we want to assign value
        String exprDecBoolCont = ""; //conditions written in between brackets before ?
        String exprDecBoolTrueVal = ""; //value, which will be assigned to identifierVar if condition equals TRUE
        String exprDecBoolFalseVal = ""; //value, which will be assigned to identifierVar if condition equals FALSE
        /* relevant statement info to keep - END */

        if(ctx.identifier_var() != null){ //name of the variable, which value should be assigned
            identifierVar = ctx.identifier_var().getText();
        }

        if(ctx.expr_dec_bool() != null){
            List<ourCParser.Expr_dec_boolContext> treeItem1 = ctx.expr_dec_bool();

            exprDecBoolCont = treeItem1.get(0).getText(); //first is condition

            if(treeItem1.size() == 3){ //ok, want to assign bool or dec
                exprDecBoolTrueVal = treeItem1.get(1).getText(); //second value which is assigned if true
                exprDecBoolFalseVal = treeItem1.get(2).getText(); //last is value assigned if false
            }else{ //want to assign string
                List<ourCParser.Expr_stringContext> treeItem2 = ctx.expr_string();

                exprDecBoolTrueVal = treeItem2.get(0).getText(); //first value which is assigned if true
                exprDecBoolFalseVal = treeItem2.get(1).getText(); //second is value assigned if false
            }
        }

        if(visitedTernDecl){ //ternar declaration was visited -> create declaration instance
            System.out.println("Ternar declaratino vis!");

            visitedTernDecl = false;

            if(ternDecType.equals("int")){
                intTernarDeclaration intTernDec = new intTernarDeclaration();

                intTernDec.setIdentifierVar(identifierVar);
                intTernDec.setExprDecBoolCont(exprDecBoolCont);
                intTernDec.setExprDecBoolTrueVal(exprDecBoolTrueVal);
                intTernDec.setExprDecBoolFalseVal(exprDecBoolFalseVal);
                System.out.println("Added INT TERN DECLAR: ident: " + identifierVar + " condition: " + exprDecBoolCont + ", when true: " + exprDecBoolTrueVal + ", when false: " + exprDecBoolFalseVal);
                addStatement(intTernDec);
            }else if(ternDecType.equals("bool")){
                boolTernarDeclaration boolTernDec = new boolTernarDeclaration();

                boolTernDec.setIdentifierVar(identifierVar);
                boolTernDec.setExprDecBoolCont(exprDecBoolCont);
                boolTernDec.setExprDecBoolTrueVal(exprDecBoolTrueVal);
                boolTernDec.setExprDecBoolFalseVal(exprDecBoolFalseVal);
                System.out.println("Added BOOL TERN DECLAR: ident: " + identifierVar + " condition: " + exprDecBoolCont + ", when true: " + exprDecBoolTrueVal + ", when false: " + exprDecBoolFalseVal);

                addStatement(boolTernDec);
            }else if(ternDecType.equals("string")){
                stringTernarDeclaration stringTernDec = new stringTernarDeclaration();

                stringTernDec.setIdentifierVar(identifierVar);
                stringTernDec.setExprDecBoolCont(exprDecBoolCont);
                stringTernDec.setExprDecBoolTrueVal(exprDecBoolTrueVal);
                stringTernDec.setExprDecBoolFalseVal(exprDecBoolFalseVal);
                System.out.println("Added STRING TERN DECLAR: ident: " + identifierVar + " condition: " + exprDecBoolCont + ", when true: " + exprDecBoolTrueVal + ", when false: " + exprDecBoolFalseVal);

                addStatement(stringTernDec);
            }
        }else{ //declaration not visited -> create classic assignment
            ternarAssign ternarAss = new ternarAssign();
            ternarAss.setIdentifierVar(identifierVar);
            ternarAss.setExprDecBoolCont(exprDecBoolCont);
            ternarAss.setExprDecBoolTrueVal(exprDecBoolTrueVal);
            ternarAss.setExprDecBoolFalseVal(exprDecBoolFalseVal);

            addStatement(ternarAss);
            System.out.println("Added ternar assignment: ident: " + identifierVar + " condition: " + exprDecBoolCont + ", when true: " + exprDecBoolTrueVal + ", when false: " + exprDecBoolFalseVal);
        }
        return super.visitTernar_assignment(ctx);
    }

    @Override
    public Object visitTernar_declaration(ourCParser.Ternar_declarationContext ctx) {
        System.out.println("Ternar declaration visited");
        visitedTernDecl = true;

        if(ctx.INT() != null){
            ternDecType = "int";
        }else if(ctx.BOOL() != null){
            ternDecType = "bool";
        }else if(ctx.STRING() != null){
            ternDecType = "string";
        }

        return super.visitTernar_declaration(ctx);
    }
}