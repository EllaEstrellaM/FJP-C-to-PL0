package visitors;

import generated.ourCBaseVisitor;
import generated.ourCParser;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefOneLine.boolDeclaration;
import statementDefOneLine.intDeclaration;
import statementDefOneLine.stringDeclaration;
import statementDefOneLine.unknownAssign;
import statementInterEnum.Istatement;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("code_block visited");
        return super.visitCode_block(ctx);
    }

    /* visited on arr int assign, arr bool assign */
    @Override
    public Object visitArr_assignment(ourCParser.Arr_assignmentContext ctx) {
        return super.visitArr_assignment(ctx);
    }

    /* visited on int assign, string assign, bool assign, if condition, do-while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition */
    @Override
    public Object visitVar_assignment(ourCParser.Var_assignmentContext ctx) {
        /* info relevant to variable assign - START */
        String assignVarName; //name of the variable
        boolean assignVarMinusSign; //true if minus sign is present; else false ; used just on int assign...
        String assignVarValue; //newly assigned value of the  variable (int, bool or string) -> convert after...
        /* info relevant to variable assign - END */

        assignVarName = ctx.identifier_var().getText();
        ourCParser.Expr_dec_boolContext treeItem1 = ctx.expr_dec_bool();
        if(treeItem1.OP_MINUS() != null){ //minus sign present
            assignVarMinusSign = true;
        }else{ //plus or no sign present in assignment...
            assignVarMinusSign = false;
        }
        assignVarValue = treeItem1.getText(); //value of the variable

        unknownAssign unkAssign = new unknownAssign();
        unkAssign.setIdentifierVar(assignVarName);
        unkAssign.setMinusSign(assignVarMinusSign);
        unkAssign.setValueVar(assignVarValue);

        encounteredStatements.add(unkAssign);

        return super.visitVar_assignment(ctx);
    }

    /* visited on int assign, string assign, bool assign, arr int assign, arr bool assign, int declaration, bool declaration, string declaration, arr int declaration, arr bool declaration,
    const int declaration, const bool declaration, const string declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition,
     ternar assign */
    @Override
    public Object visitIdentifier_var(ourCParser.Identifier_varContext ctx) {
        System.out.println("identifier_var visited");
        return super.visitIdentifier_var(ctx);
    }

    /* visited on int assign, bool assign, arr bool assign, arr int assign, int declaration, bool declaration, const int declaration, const bool declaration, if condition, do-while cycle,
    * while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition, ternar assign */
    @Override
    public Object visitExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx) {
        System.out.println("expr_dec_bool visited");
        return super.visitExpr_dec_bool(ctx);
    }

    /* visited on int assign, arr int assign, int declaration, const int declaration, if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle,
    procedure definition */
    @Override
    public Object visitDec_val(ourCParser.Dec_valContext ctx) {
        System.out.println("dec_val visited");
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
        System.out.println("array_var_dec visited");
        return super.visitArray_var_dec(ctx);
    }

    /* visited on string assign, string declaration, const string declaration */
    @Override
    public Object visitStateStringVal(ourCParser.StateStringValContext ctx) {
        System.out.println("state_string_val visited");
        return super.visitStateStringVal(ctx);
    }

    /* visited on string assign, string declaration, const string declaration */
    @Override
    public Object visitString_val(ourCParser.String_valContext ctx) {
        System.out.println("string_val visited");
        return super.visitString_val(ctx);
    }

    /* visited on bool assign, arr bool assign, bool declaration, const bool declaration */
    @Override
    public Object visitBool_val(ourCParser.Bool_valContext ctx) {
        System.out.println("bool_val visited");
        return super.visitBool_val(ctx);
    }

    /* visited on bool declaration, const bool declaration */
    @Override
    public Object visitBool_var_dec(ourCParser.Bool_var_decContext ctx) {
        System.out.println("bool_var_dec visited");
        return super.visitBool_var_dec(ctx);
    }

    /* visited on string declaration, const string declaration */
    @Override
    public Object visitString_var_dec(ourCParser.String_var_decContext ctx) {
        System.out.println("string_var_dec visited");
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

            encounteredStatements.add(intDeclar);
        }else if(ctx.bool_var_dec() != null){ //bool value
            ourCParser.Bool_var_decContext treeItem1 = ctx.bool_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of BOOL the variable
            declVarValue = treeItem1.expr_dec_bool().getText(); //value of the BOOL variable

            boolDeclaration boolDeclar = new boolDeclaration();
            boolDeclar.setIdentifierVar(declVarName);
            boolDeclar.setBoolVal(declVarValue);

            encounteredStatements.add(boolDeclar);
        }else if(ctx.string_var_dec() != null){ //string value
            ourCParser.String_var_decContext treeItem1 = ctx.string_var_dec();

            declVarName = treeItem1.identifier_var().IDENT().getText(); //name of STRING the variable
            declVarValue = treeItem1.expr_string().getText(); //value of the STRING variable

            stringDeclaration stringDeclar = new stringDeclaration();
            stringDeclar.setIdentifierVar(declVarName);
            stringDeclar.setStringVal(declVarValue);

            encounteredStatements.add(stringDeclar);
        }else{
            //error, tbd
        }
        return super.visitVar_non_const_dec_command(ctx);
    }

    /* visited on const int declaration, const bool declaration, const string declaration */
    @Override
    public Object visitVar_const_dec_command(ourCParser.Var_const_dec_commandContext ctx) {
        System.out.println("var_const_dec_command visited");
        return super.visitVar_const_dec_command(ctx);
    }

    /* visited on int declaration, const int declaration, while cycle */
    @Override
    public Object visitDecimal_var_dec(ourCParser.Decimal_var_decContext ctx) {
        System.out.println("decimal_var_dec visited");
        return super.visitDecimal_var_dec(ctx);
    }

    /* visited on if condition, do-while cycle, while cycle, repeat-until cycle, for cycle, foreach cycle, procedure definition */
    @Override
    public Object visitBlock_body(ourCParser.Block_bodyContext ctx) {
        System.out.println("block_body visited");
        return super.visitBlock_body(ctx);
    }

    /* visited on procedure definition */
    @Override
    public Object visitDef_proc(ourCParser.Def_procContext ctx) {
        System.out.println("def_proc visited");
        return super.visitDef_proc(ctx);
    }

    /* visited on ternar assignment */
    @Override
    public Object visitTernar_assignment(ourCParser.Ternar_assignmentContext ctx) {
        System.out.println("ternar_assignment visited");
        return super.visitTernar_assignment(ctx);
    }
}