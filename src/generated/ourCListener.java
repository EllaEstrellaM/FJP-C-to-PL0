// Generated from C:/Users/elisk/Documents/FJP-C-to-PL0\ourC.g4 by ANTLR 4.9
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ourCParser}.
 */
public interface ourCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ourCParser#identifier_var}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_var(ourCParser.Identifier_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#identifier_var}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_var(ourCParser.Identifier_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#bool_val}.
	 * @param ctx the parse tree
	 */
	void enterBool_val(ourCParser.Bool_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#bool_val}.
	 * @param ctx the parse tree
	 */
	void exitBool_val(ourCParser.Bool_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#dec_val}.
	 * @param ctx the parse tree
	 */
	void enterDec_val(ourCParser.Dec_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#dec_val}.
	 * @param ctx the parse tree
	 */
	void exitDec_val(ourCParser.Dec_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#string_val}.
	 * @param ctx the parse tree
	 */
	void enterString_val(ourCParser.String_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#string_val}.
	 * @param ctx the parse tree
	 */
	void exitString_val(ourCParser.String_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void enterMulti_assign(ourCParser.Multi_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#multi_assign}.
	 * @param ctx the parse tree
	 */
	void exitMulti_assign(ourCParser.Multi_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#expr_dec_bool}.
	 * @param ctx the parse tree
	 */
	void enterExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#expr_dec_bool}.
	 * @param ctx the parse tree
	 */
	void exitExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#expr_string}.
	 * @param ctx the parse tree
	 */
	void enterExpr_string(ourCParser.Expr_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#expr_string}.
	 * @param ctx the parse tree
	 */
	void exitExpr_string(ourCParser.Expr_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#bool_var_dec}.
	 * @param ctx the parse tree
	 */
	void enterBool_var_dec(ourCParser.Bool_var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#bool_var_dec}.
	 * @param ctx the parse tree
	 */
	void exitBool_var_dec(ourCParser.Bool_var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#decimal_var_dec}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_var_dec(ourCParser.Decimal_var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#decimal_var_dec}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_var_dec(ourCParser.Decimal_var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#string_var_dec}.
	 * @param ctx the parse tree
	 */
	void enterString_var_dec(ourCParser.String_var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#string_var_dec}.
	 * @param ctx the parse tree
	 */
	void exitString_var_dec(ourCParser.String_var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#array_var_dec}.
	 * @param ctx the parse tree
	 */
	void enterArray_var_dec(ourCParser.Array_var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#array_var_dec}.
	 * @param ctx the parse tree
	 */
	void exitArray_var_dec(ourCParser.Array_var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#var_non_const_dec_command}.
	 * @param ctx the parse tree
	 */
	void enterVar_non_const_dec_command(ourCParser.Var_non_const_dec_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#var_non_const_dec_command}.
	 * @param ctx the parse tree
	 */
	void exitVar_non_const_dec_command(ourCParser.Var_non_const_dec_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#var_const_dec_command}.
	 * @param ctx the parse tree
	 */
	void enterVar_const_dec_command(ourCParser.Var_const_dec_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#var_const_dec_command}.
	 * @param ctx the parse tree
	 */
	void exitVar_const_dec_command(ourCParser.Var_const_dec_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(ourCParser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(ourCParser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#var_assignment}.
	 * @param ctx the parse tree
	 */
	void enterVar_assignment(ourCParser.Var_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#var_assignment}.
	 * @param ctx the parse tree
	 */
	void exitVar_assignment(ourCParser.Var_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#arr_assignment}.
	 * @param ctx the parse tree
	 */
	void enterArr_assignment(ourCParser.Arr_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#arr_assignment}.
	 * @param ctx the parse tree
	 */
	void exitArr_assignment(ourCParser.Arr_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#ternar_assignment}.
	 * @param ctx the parse tree
	 */
	void enterTernar_assignment(ourCParser.Ternar_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#ternar_assignment}.
	 * @param ctx the parse tree
	 */
	void exitTernar_assignment(ourCParser.Ternar_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#ternar_declaration}.
	 * @param ctx the parse tree
	 */
	void enterTernar_declaration(ourCParser.Ternar_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#ternar_declaration}.
	 * @param ctx the parse tree
	 */
	void exitTernar_declaration(ourCParser.Ternar_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#call_proc}.
	 * @param ctx the parse tree
	 */
	void enterCall_proc(ourCParser.Call_procContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#call_proc}.
	 * @param ctx the parse tree
	 */
	void exitCall_proc(ourCParser.Call_procContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#code_block}.
	 * @param ctx the parse tree
	 */
	void enterCode_block(ourCParser.Code_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#code_block}.
	 * @param ctx the parse tree
	 */
	void exitCode_block(ourCParser.Code_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#block_body}.
	 * @param ctx the parse tree
	 */
	void enterBlock_body(ourCParser.Block_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#block_body}.
	 * @param ctx the parse tree
	 */
	void exitBlock_body(ourCParser.Block_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#def_proc}.
	 * @param ctx the parse tree
	 */
	void enterDef_proc(ourCParser.Def_procContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#def_proc}.
	 * @param ctx the parse tree
	 */
	void exitDef_proc(ourCParser.Def_procContext ctx);
	/**
	 * Enter a parse tree produced by {@link ourCParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ourCParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ourCParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ourCParser.StartContext ctx);
}