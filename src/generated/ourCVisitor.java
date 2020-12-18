// Generated from C:/Users/Ondrej/IdeaProjects/FJP-C-to-PL0\ourC.g4 by ANTLR 4.9
package generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ourCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ourCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ourCParser#identifier_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_var(ourCParser.Identifier_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#bool_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_val(ourCParser.Bool_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#dec_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_val(ourCParser.Dec_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#string_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_val(ourCParser.String_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#sign_whole_num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign_whole_num(ourCParser.Sign_whole_numContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#multi_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulti_assign(ourCParser.Multi_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_dec_bool(ourCParser.Expr_dec_boolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateIdentifierVar}
	 * labeled alternative in {@link ourCParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateIdentifierVar(ourCParser.StateIdentifierVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateExprString}
	 * labeled alternative in {@link ourCParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateExprString(ourCParser.StateExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateLeftString}
	 * labeled alternative in {@link ourCParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateLeftString(ourCParser.StateLeftStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateStringVal}
	 * labeled alternative in {@link ourCParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateStringVal(ourCParser.StateStringValContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#bool_var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_var_dec(ourCParser.Bool_var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#decimal_var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_var_dec(ourCParser.Decimal_var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#string_var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_var_dec(ourCParser.String_var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#array_var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_var_dec(ourCParser.Array_var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#var_non_const_dec_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_non_const_dec_command(ourCParser.Var_non_const_dec_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#var_const_dec_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_const_dec_command(ourCParser.Var_const_dec_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#var_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declaration(ourCParser.Var_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#var_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_assignment(ourCParser.Var_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#arr_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr_assignment(ourCParser.Arr_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#ternar_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernar_assignment(ourCParser.Ternar_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#call_proc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_proc(ourCParser.Call_procContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#code_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode_block(ourCParser.Code_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#block_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_body(ourCParser.Block_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#def_proc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_proc(ourCParser.Def_procContext ctx);
	/**
	 * Visit a parse tree produced by {@link ourCParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ourCParser.StartContext ctx);
}