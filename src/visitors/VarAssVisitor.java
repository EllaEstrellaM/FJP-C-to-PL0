package visitors;

import generated.ourCBaseVisitor;
import generated.ourCParser;
import statementDefOneLine.*;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class VarAssVisitor extends ourCBaseVisitor {
    ArrayList<Istatement> encounteredStatements; //list of ALL recognized statements (oneline + multiline)

    public VarAssVisitor(){
        encounteredStatements = new ArrayList<Istatement>();
    }

    /* visited on int assign, string assign, bool assign, arr int assign, arr bool assign, int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration,
    const int declaration, const bool declaration, const string declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition,
    ternar assign */
    @Override
    public Object visitCode_block(ourCParser.Code_blockContext ctx) {
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
            ourCParser.Expr_stringContext treeItem1 = ctx.expr_string();

            assignVarValue = treeItem1.getText();
        }else{
            //error, tbd
        }

        ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool();
        assignVarValue = treeItem1.getText(); //value of the variable

        unknownAssign unkAssign = new unknownAssign();
        unkAssign.setIdentifierVar(assignVarName);
        unkAssign.setMinusSign(assignVarMinusSign);
        unkAssign.setValueVar(assignVarValue);

        System.out.println("Var assignment created\n");
        encounteredStatements.add(unkAssign);

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
    public Object visitStateStringVal(ourCParser.StateStringValContext ctx) {
        return super.visitStateStringVal(ctx);
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
            System.out.println("INT declaration \n");
            encounteredStatements.add(intDeclar);
        }else if(ctx.bool_var_dec() != null){ //bool value
            ourCParser.Bool_var_decContext treeItem1 = ctx.bool_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of BOOL the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the BOOL variable

            boolDeclaration boolDeclar = new boolDeclaration();
            boolDeclar.setIdentifierVar(declVarName);
            boolDeclar.setBoolVal(declVarValue);
            System.out.println("BOOL declaration\n");
            encounteredStatements.add(boolDeclar);
        }else if(ctx.string_var_dec() != null){ //string value
            ourCParser.String_var_decContext treeItem1 = ctx.string_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of STRING the variable
            declVarValue = treeItem1.expr_string().getText(); //value of the STRING variable

            stringDeclaration stringDeclar = new stringDeclaration();
            stringDeclar.setIdentifierVar(declVarName);
            stringDeclar.setStringVal(declVarValue);
            System.out.println("STRING declaration\n");
            encounteredStatements.add(stringDeclar);
        }else if(ctx.array_var_dec() != null){
            ourCParser.Array_var_decContext treeItem1 = ctx.array_var_dec();

            declArrName = treeItem1.identifier_var().IDENT().getText();
            declArrsize = Integer.valueOf(treeItem1.DEC_NUM().getText());

            if(ctx.array_var_dec().INT() != null){ //want to declare int array
                arrIntDeclaration arrIntDeclar = new arrIntDeclaration();
                arrIntDeclar.setIdentifierVar(declArrName);
                arrIntDeclar.setDecNum(declArrsize);
                System.out.println("INT ARR declaration\n");
                encounteredStatements.add(arrIntDeclar);
            }else{ //want to declare bool array
                arrBoolDeclaration arrBoolDeclar = new arrBoolDeclaration();
                arrBoolDeclar.setIdentifierVar(declArrName);
                arrBoolDeclar.setDecNum(declArrsize);
                System.out.println("BOOL ARR declaration\n");
                encounteredStatements.add(arrBoolDeclar);
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
            System.out.println("INT const declaration \n");
            encounteredStatements.add(constIntDeclar);
        }else if(ctx.bool_var_dec() != null){ //bool value
            ourCParser.Bool_var_decContext treeItem1 = ctx.bool_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of BOOL the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the BOOL variable

            constBoolDeclaration constBoolDeclar = new constBoolDeclaration();
            constBoolDeclar.setIdentifierVar(declVarName);
            constBoolDeclar.setBoolVal(declVarValue);
            System.out.println("BOOL const declaration\n");
            encounteredStatements.add(constBoolDeclar);
        }else if(ctx.string_var_dec() != null){ //string value
            ourCParser.String_var_decContext treeItem1 = ctx.string_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of STRING the variable
            declVarValue = treeItem1.expr_string().getText(); //value of the STRING variable

            constStringDeclaration constStringDeclar = new constStringDeclaration();
            constStringDeclar.setIdentifierVar(declVarName);
            constStringDeclar.setStringVal(declVarValue);
            System.out.println("STRING const declaration\n");
            encounteredStatements.add(constStringDeclar);
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
        return super.visitBlock_body(ctx);
    }

    /* visited on procedure definition */
    @Override
    public Object visitDef_proc(ourCParser.Def_procContext ctx) {
        return super.visitDef_proc(ctx);
    }

    /* visited on ternar assignment */
    @Override
    public Object visitTernar_assignment(ourCParser.Ternar_assignmentContext ctx) {
        return super.visitTernar_assignment(ctx);
    }
}