package visitors;

import generated.ourCBaseVisitor;
import generated.ourCParser;

public class VarAssVisitor extends ourCBaseVisitor {
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
        System.out.println("var_assignment visited");
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
        System.out.println("Var declaration children: " + ctx.getChild(0).getText());
        System.out.println("var_declaration visited");
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
        System.out.println("var_non_const_dec_command visited");
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