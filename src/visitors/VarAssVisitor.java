package visitors;
import generated.ourCBaseVisitor;
import generated.ourCParser;

public class VarAssVisitor extends ourCBaseVisitor {
    /* visited on int declaration, */
    @Override
    public Object visitCode_block(ourCParser.Code_blockContext ctx) {
        System.out.println("code block");
        return super.visitCode_block(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitVar_declaration(ourCParser.Var_declarationContext ctx) {
        return super.visitVar_declaration(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitVar_non_const_dec_command(ourCParser.Var_non_const_dec_commandContext ctx) {
        return super.visitVar_non_const_dec_command(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitDecimal_var_dec(ourCParser.Decimal_var_decContext ctx) {
        return super.visitDecimal_var_dec(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitIdentifier_var(ourCParser.Identifier_varContext ctx) {
        return super.visitIdentifier_var(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx) {
        return super.visitExpr_dec_bool(ctx);
    }

    /* visited on int declaration, */
    @Override
    public Object visitDec_val(ourCParser.Dec_valContext ctx) {
        return super.visitDec_val(ctx);
    }
}