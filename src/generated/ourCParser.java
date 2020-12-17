package generated;// Generated from C:/Users/elisk/Documents/kiv-FJP\ourC.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ourCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_MULTIPLICATION=1, OP_MINUS=2, OP_PLUS=3, OP_DIVISION=4, COMP_IDENT=5, 
		COMP_NOT_IDENT=6, COMP_GRTH=7, COMP_GRTH_EQ=8, COMP_LW=9, COMP_LW_EQ=10, 
		ASSIGN=11, NEGATION=12, QUES_MARK=13, OPER_AND=14, OPER_OR=15, COLON=16, 
		SEMI_COLON=17, BOOL_TRUE=18, BOOL_FALSE=19, LEFT_BASIC_BRACK=20, RIGHT_BASIC_BRACK=21, 
		LEFT_CURLY_BRACK=22, RIGHT_CURLY_BRACK=23, LEFT_NARROW_BRACK=24, RIGHT_NARROW_BRACK=25, 
		COMMA=26, END_OF_COM=27, CON_IF=28, CON_ELSE=29, CYC_WHILE=30, CYC_FOR=31, 
		CYC_FOREACH=32, CYC_REPEAT=33, CYC_UNTIL=34, CYC_DO=35, TO=36, BOOL=37, 
		INT=38, STRING=39, CONST=40, PROC_DEF=41, DEC_NUM=42, IDENT=43, STRING_DEC=44, 
		COMMENT_START=45, BLANK_SPACE=46;
	public static final int
		RULE_identifier_var = 0, RULE_bool_val = 1, RULE_dec_val = 2, RULE_string_val = 3, 
		RULE_types = 4, RULE_sign_whole_num = 5, RULE_values_pos_assign = 6, RULE_multi_assign = 7, 
		RULE_expr_dec_bool = 8, RULE_expr_string = 9, RULE_bool_var_dec = 10, 
		RULE_decimal_var_dec = 11, RULE_string_var_dec = 12, RULE_array_var_dec = 13, 
		RULE_var_non_const_dec_command = 14, RULE_var_const_dec_command = 15, 
		RULE_var_declaration = 16, RULE_var_assignment = 17, RULE_arr_assignment = 18, 
		RULE_ternar_assignment = 19, RULE_call_proc = 20, RULE_code_block = 21, 
		RULE_block_body = 22, RULE_def_proc = 23, RULE_start = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier_var", "bool_val", "dec_val", "string_val", "types", "sign_whole_num", 
			"values_pos_assign", "multi_assign", "expr_dec_bool", "expr_string", 
			"bool_var_dec", "decimal_var_dec", "string_var_dec", "array_var_dec", 
			"var_non_const_dec_command", "var_const_dec_command", "var_declaration", 
			"var_assignment", "arr_assignment", "ternar_assignment", "call_proc", 
			"code_block", "block_body", "def_proc", "start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'-'", "'+'", "'/'", "'=='", "'!='", "'>'", "'>='", "'<'", 
			"'<='", "'='", "'!'", "'?'", "'and'", "'or'", "':'", "';'", "'true'", 
			"'false'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'\n'", "'if'", 
			"'else'", "'while'", "'for'", "'foreach'", "'repeat'", "'until'", "'do'", 
			"'to'", "'bool'", "'int'", "'string'", "'const'", "'procedure'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_MULTIPLICATION", "OP_MINUS", "OP_PLUS", "OP_DIVISION", "COMP_IDENT", 
			"COMP_NOT_IDENT", "COMP_GRTH", "COMP_GRTH_EQ", "COMP_LW", "COMP_LW_EQ", 
			"ASSIGN", "NEGATION", "QUES_MARK", "OPER_AND", "OPER_OR", "COLON", "SEMI_COLON", 
			"BOOL_TRUE", "BOOL_FALSE", "LEFT_BASIC_BRACK", "RIGHT_BASIC_BRACK", "LEFT_CURLY_BRACK", 
			"RIGHT_CURLY_BRACK", "LEFT_NARROW_BRACK", "RIGHT_NARROW_BRACK", "COMMA", 
			"END_OF_COM", "CON_IF", "CON_ELSE", "CYC_WHILE", "CYC_FOR", "CYC_FOREACH", 
			"CYC_REPEAT", "CYC_UNTIL", "CYC_DO", "TO", "BOOL", "INT", "STRING", "CONST", 
			"PROC_DEF", "DEC_NUM", "IDENT", "STRING_DEC", "COMMENT_START", "BLANK_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ourC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ourCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Identifier_varContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ourCParser.IDENT, 0); }
		public Identifier_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterIdentifier_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitIdentifier_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitIdentifier_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_varContext identifier_var() throws RecognitionException {
		Identifier_varContext _localctx = new Identifier_varContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_valContext extends ParserRuleContext {
		public TerminalNode BOOL_TRUE() { return getToken(ourCParser.BOOL_TRUE, 0); }
		public TerminalNode BOOL_FALSE() { return getToken(ourCParser.BOOL_FALSE, 0); }
		public Bool_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterBool_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitBool_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitBool_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_valContext bool_val() throws RecognitionException {
		Bool_valContext _localctx = new Bool_valContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bool_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==BOOL_TRUE || _la==BOOL_FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dec_valContext extends ParserRuleContext {
		public TerminalNode DEC_NUM() { return getToken(ourCParser.DEC_NUM, 0); }
		public Sign_whole_numContext sign_whole_num() {
			return getRuleContext(Sign_whole_numContext.class,0);
		}
		public Dec_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterDec_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitDec_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitDec_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dec_valContext dec_val() throws RecognitionException {
		Dec_valContext _localctx = new Dec_valContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_MINUS || _la==OP_PLUS) {
				{
				setState(54);
				sign_whole_num();
				}
			}

			setState(57);
			match(DEC_NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_valContext extends ParserRuleContext {
		public TerminalNode STRING_DEC() { return getToken(ourCParser.STRING_DEC, 0); }
		public String_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterString_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitString_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitString_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_valContext string_val() throws RecognitionException {
		String_valContext _localctx = new String_valContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_string_val);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(STRING_DEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(ourCParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(ourCParser.INT, 0); }
		public TerminalNode STRING() { return getToken(ourCParser.STRING, 0); }
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sign_whole_numContext extends ParserRuleContext {
		public TerminalNode OP_PLUS() { return getToken(ourCParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(ourCParser.OP_MINUS, 0); }
		public Sign_whole_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign_whole_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterSign_whole_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitSign_whole_num(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitSign_whole_num(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sign_whole_numContext sign_whole_num() throws RecognitionException {
		Sign_whole_numContext _localctx = new Sign_whole_numContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sign_whole_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !(_la==OP_MINUS || _la==OP_PLUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Values_pos_assignContext extends ParserRuleContext {
		public TerminalNode STRING_DEC() { return getToken(ourCParser.STRING_DEC, 0); }
		public Bool_valContext bool_val() {
			return getRuleContext(Bool_valContext.class,0);
		}
		public TerminalNode DEC_NUM() { return getToken(ourCParser.DEC_NUM, 0); }
		public Sign_whole_numContext sign_whole_num() {
			return getRuleContext(Sign_whole_numContext.class,0);
		}
		public Values_pos_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values_pos_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterValues_pos_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitValues_pos_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitValues_pos_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Values_pos_assignContext values_pos_assign() throws RecognitionException {
		Values_pos_assignContext _localctx = new Values_pos_assignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_values_pos_assign);
		int _la;
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_DEC:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(STRING_DEC);
				}
				break;
			case BOOL_TRUE:
			case BOOL_FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				bool_val();
				}
				break;
			case OP_MINUS:
			case OP_PLUS:
			case DEC_NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_MINUS || _la==OP_PLUS) {
					{
					setState(67);
					sign_whole_num();
					}
				}

				setState(70);
				match(DEC_NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multi_assignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public Multi_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterMulti_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitMulti_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitMulti_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multi_assignContext multi_assign() throws RecognitionException {
		Multi_assignContext _localctx = new Multi_assignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ASSIGN);
			setState(74);
			identifier_var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_dec_boolContext extends ParserRuleContext {
		public Token op;
		public Dec_valContext dec_val() {
			return getRuleContext(Dec_valContext.class,0);
		}
		public Bool_valContext bool_val() {
			return getRuleContext(Bool_valContext.class,0);
		}
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_NARROW_BRACK() { return getToken(ourCParser.LEFT_NARROW_BRACK, 0); }
		public TerminalNode DEC_NUM() { return getToken(ourCParser.DEC_NUM, 0); }
		public TerminalNode RIGHT_NARROW_BRACK() { return getToken(ourCParser.RIGHT_NARROW_BRACK, 0); }
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public TerminalNode COMP_IDENT() { return getToken(ourCParser.COMP_IDENT, 0); }
		public TerminalNode COMP_NOT_IDENT() { return getToken(ourCParser.COMP_NOT_IDENT, 0); }
		public List<Expr_dec_boolContext> expr_dec_bool() {
			return getRuleContexts(Expr_dec_boolContext.class);
		}
		public Expr_dec_boolContext expr_dec_bool(int i) {
			return getRuleContext(Expr_dec_boolContext.class,i);
		}
		public TerminalNode OPER_AND() { return getToken(ourCParser.OPER_AND, 0); }
		public TerminalNode OPER_OR() { return getToken(ourCParser.OPER_OR, 0); }
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public TerminalNode NEGATION() { return getToken(ourCParser.NEGATION, 0); }
		public TerminalNode OP_PLUS() { return getToken(ourCParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(ourCParser.OP_MINUS, 0); }
		public TerminalNode OP_MULTIPLICATION() { return getToken(ourCParser.OP_MULTIPLICATION, 0); }
		public TerminalNode OP_DIVISION() { return getToken(ourCParser.OP_DIVISION, 0); }
		public TerminalNode COMP_LW() { return getToken(ourCParser.COMP_LW, 0); }
		public TerminalNode COMP_LW_EQ() { return getToken(ourCParser.COMP_LW_EQ, 0); }
		public TerminalNode COMP_GRTH() { return getToken(ourCParser.COMP_GRTH, 0); }
		public TerminalNode COMP_GRTH_EQ() { return getToken(ourCParser.COMP_GRTH_EQ, 0); }
		public Expr_dec_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_dec_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterExpr_dec_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitExpr_dec_bool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitExpr_dec_bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_dec_boolContext expr_dec_bool() throws RecognitionException {
		return expr_dec_bool(0);
	}

	private Expr_dec_boolContext expr_dec_bool(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_dec_boolContext _localctx = new Expr_dec_boolContext(_ctx, _parentState);
		Expr_dec_boolContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr_dec_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(77);
				dec_val();
				}
				break;
			case 2:
				{
				setState(78);
				bool_val();
				}
				break;
			case 3:
				{
				setState(79);
				identifier_var();
				}
				break;
			case 4:
				{
				setState(80);
				identifier_var();
				setState(81);
				match(LEFT_NARROW_BRACK);
				setState(82);
				match(DEC_NUM);
				setState(83);
				match(RIGHT_NARROW_BRACK);
				}
				break;
			case 5:
				{
				setState(85);
				expr_string(0);
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==COMP_IDENT || _la==COMP_NOT_IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				expr_string(0);
				setState(90);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(88);
					_la = _input.LA(1);
					if ( !(_la==OPER_AND || _la==OPER_OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(89);
					expr_dec_bool(0);
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(92);
				match(LEFT_BASIC_BRACK);
				setState(93);
				expr_dec_bool(0);
				setState(94);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			case 7:
				{
				setState(96);
				match(NEGATION);
				setState(97);
				expr_dec_bool(3);
				}
				break;
			case 8:
				{
				setState(98);
				match(OP_PLUS);
				setState(99);
				expr_dec_bool(2);
				}
				break;
			case 9:
				{
				setState(100);
				match(OP_MINUS);
				setState(101);
				expr_dec_bool(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						((Expr_dec_boolContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MULTIPLICATION || _la==OP_DIVISION) ) {
							((Expr_dec_boolContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expr_dec_bool(10);
						}
						break;
					case 2:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(107);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(108);
						((Expr_dec_boolContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MINUS || _la==OP_PLUS) ) {
							((Expr_dec_boolContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						expr_dec_bool(9);
						}
						break;
					case 3:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(110);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(111);
						((Expr_dec_boolContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMP_IDENT) | (1L << COMP_NOT_IDENT) | (1L << COMP_GRTH) | (1L << COMP_GRTH_EQ) | (1L << COMP_LW) | (1L << COMP_LW_EQ))) != 0)) ) {
							((Expr_dec_boolContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						expr_dec_bool(8);
						}
						break;
					case 4:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(113);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(114);
						((Expr_dec_boolContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OPER_AND || _la==OPER_OR) ) {
							((Expr_dec_boolContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(115);
						expr_dec_bool(7);
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr_stringContext extends ParserRuleContext {
		public String_valContext string_val() {
			return getRuleContext(String_valContext.class,0);
		}
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public TerminalNode OP_PLUS() { return getToken(ourCParser.OP_PLUS, 0); }
		public Expr_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterExpr_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitExpr_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitExpr_string(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stringContext expr_string() throws RecognitionException {
		return expr_string(0);
	}

	private Expr_stringContext expr_string(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_stringContext _localctx = new Expr_stringContext(_ctx, _parentState);
		Expr_stringContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_DEC:
				{
				setState(122);
				string_val();
				}
				break;
			case IDENT:
				{
				setState(123);
				identifier_var();
				}
				break;
			case LEFT_BASIC_BRACK:
				{
				setState(124);
				match(LEFT_BASIC_BRACK);
				setState(125);
				expr_string(0);
				setState(126);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_stringContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_string);
					setState(130);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(131);
					match(OP_PLUS);
					setState(132);
					expr_string(3);
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Bool_var_decContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(ourCParser.BOOL, 0); }
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public Expr_dec_boolContext expr_dec_bool() {
			return getRuleContext(Expr_dec_boolContext.class,0);
		}
		public List<Multi_assignContext> multi_assign() {
			return getRuleContexts(Multi_assignContext.class);
		}
		public Multi_assignContext multi_assign(int i) {
			return getRuleContext(Multi_assignContext.class,i);
		}
		public Bool_var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterBool_var_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitBool_var_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitBool_var_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_var_decContext bool_var_dec() throws RecognitionException {
		Bool_var_decContext _localctx = new Bool_var_decContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bool_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(BOOL);
			setState(139);
			identifier_var();
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					multi_assign();
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(146);
			match(ASSIGN);
			setState(147);
			expr_dec_bool(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decimal_var_decContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ourCParser.INT, 0); }
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public Expr_dec_boolContext expr_dec_bool() {
			return getRuleContext(Expr_dec_boolContext.class,0);
		}
		public List<Multi_assignContext> multi_assign() {
			return getRuleContexts(Multi_assignContext.class);
		}
		public Multi_assignContext multi_assign(int i) {
			return getRuleContext(Multi_assignContext.class,i);
		}
		public Sign_whole_numContext sign_whole_num() {
			return getRuleContext(Sign_whole_numContext.class,0);
		}
		public Decimal_var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterDecimal_var_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitDecimal_var_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitDecimal_var_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_var_decContext decimal_var_dec() throws RecognitionException {
		Decimal_var_decContext _localctx = new Decimal_var_decContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_decimal_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(INT);
			setState(150);
			identifier_var();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					multi_assign();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(157);
			match(ASSIGN);
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(158);
				sign_whole_num();
				}
				break;
			}
			setState(161);
			expr_dec_bool(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_var_decContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ourCParser.STRING, 0); }
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public Expr_stringContext expr_string() {
			return getRuleContext(Expr_stringContext.class,0);
		}
		public List<Multi_assignContext> multi_assign() {
			return getRuleContexts(Multi_assignContext.class);
		}
		public Multi_assignContext multi_assign(int i) {
			return getRuleContext(Multi_assignContext.class,i);
		}
		public String_var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterString_var_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitString_var_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitString_var_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_var_decContext string_var_dec() throws RecognitionException {
		String_var_decContext _localctx = new String_var_decContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_string_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(STRING);
			setState(164);
			identifier_var();
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					multi_assign();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(171);
			match(ASSIGN);
			setState(172);
			expr_string(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_var_decContext extends ParserRuleContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_NARROW_BRACK() { return getToken(ourCParser.LEFT_NARROW_BRACK, 0); }
		public TerminalNode DEC_NUM() { return getToken(ourCParser.DEC_NUM, 0); }
		public TerminalNode RIGHT_NARROW_BRACK() { return getToken(ourCParser.RIGHT_NARROW_BRACK, 0); }
		public TerminalNode INT() { return getToken(ourCParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(ourCParser.BOOL, 0); }
		public Array_var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterArray_var_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitArray_var_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitArray_var_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_var_decContext array_var_dec() throws RecognitionException {
		Array_var_decContext _localctx = new Array_var_decContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array_var_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(175);
			identifier_var();
			setState(176);
			match(LEFT_NARROW_BRACK);
			setState(177);
			match(DEC_NUM);
			setState(178);
			match(RIGHT_NARROW_BRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_non_const_dec_commandContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public Bool_var_decContext bool_var_dec() {
			return getRuleContext(Bool_var_decContext.class,0);
		}
		public Decimal_var_decContext decimal_var_dec() {
			return getRuleContext(Decimal_var_decContext.class,0);
		}
		public String_var_decContext string_var_dec() {
			return getRuleContext(String_var_decContext.class,0);
		}
		public Array_var_decContext array_var_dec() {
			return getRuleContext(Array_var_decContext.class,0);
		}
		public Var_non_const_dec_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_non_const_dec_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterVar_non_const_dec_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitVar_non_const_dec_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitVar_non_const_dec_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_non_const_dec_commandContext var_non_const_dec_command() throws RecognitionException {
		Var_non_const_dec_commandContext _localctx = new Var_non_const_dec_commandContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var_non_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(180);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(181);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(182);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(183);
				array_var_dec();
				}
				break;
			}
			setState(186);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_const_dec_commandContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(ourCParser.CONST, 0); }
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public Bool_var_decContext bool_var_dec() {
			return getRuleContext(Bool_var_decContext.class,0);
		}
		public Decimal_var_decContext decimal_var_dec() {
			return getRuleContext(Decimal_var_decContext.class,0);
		}
		public String_var_decContext string_var_dec() {
			return getRuleContext(String_var_decContext.class,0);
		}
		public Array_var_decContext array_var_dec() {
			return getRuleContext(Array_var_decContext.class,0);
		}
		public Var_const_dec_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_const_dec_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterVar_const_dec_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitVar_const_dec_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitVar_const_dec_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_const_dec_commandContext var_const_dec_command() throws RecognitionException {
		Var_const_dec_commandContext _localctx = new Var_const_dec_commandContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_var_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(CONST);
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(189);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(190);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(191);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(192);
				array_var_dec();
				}
				break;
			}
			setState(195);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declarationContext extends ParserRuleContext {
		public Var_non_const_dec_commandContext var_non_const_dec_command() {
			return getRuleContext(Var_non_const_dec_commandContext.class,0);
		}
		public Var_const_dec_commandContext var_const_dec_command() {
			return getRuleContext(Var_const_dec_commandContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterVar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitVar_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitVar_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
				{
				setState(197);
				var_non_const_dec_command();
				}
				break;
			case CONST:
				{
				setState(198);
				var_const_dec_command();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_assignmentContext extends ParserRuleContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public Expr_dec_boolContext expr_dec_bool() {
			return getRuleContext(Expr_dec_boolContext.class,0);
		}
		public Expr_stringContext expr_string() {
			return getRuleContext(Expr_stringContext.class,0);
		}
		public Var_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterVar_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitVar_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitVar_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_assignmentContext var_assignment() throws RecognitionException {
		Var_assignmentContext _localctx = new Var_assignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			identifier_var();
			setState(202);
			match(ASSIGN);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(203);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(204);
				expr_string(0);
				}
				break;
			}
			setState(207);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arr_assignmentContext extends ParserRuleContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_NARROW_BRACK() { return getToken(ourCParser.LEFT_NARROW_BRACK, 0); }
		public TerminalNode DEC_NUM() { return getToken(ourCParser.DEC_NUM, 0); }
		public TerminalNode RIGHT_NARROW_BRACK() { return getToken(ourCParser.RIGHT_NARROW_BRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public Expr_dec_boolContext expr_dec_bool() {
			return getRuleContext(Expr_dec_boolContext.class,0);
		}
		public Arr_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterArr_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitArr_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitArr_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arr_assignmentContext arr_assignment() throws RecognitionException {
		Arr_assignmentContext _localctx = new Arr_assignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arr_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			identifier_var();
			setState(210);
			match(LEFT_NARROW_BRACK);
			setState(211);
			match(DEC_NUM);
			setState(212);
			match(RIGHT_NARROW_BRACK);
			setState(213);
			match(ASSIGN);
			{
			setState(214);
			expr_dec_bool(0);
			}
			setState(215);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ternar_assignmentContext extends ParserRuleContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public List<Expr_dec_boolContext> expr_dec_bool() {
			return getRuleContexts(Expr_dec_boolContext.class);
		}
		public Expr_dec_boolContext expr_dec_bool(int i) {
			return getRuleContext(Expr_dec_boolContext.class,i);
		}
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public TerminalNode QUES_MARK() { return getToken(ourCParser.QUES_MARK, 0); }
		public TerminalNode COLON() { return getToken(ourCParser.COLON, 0); }
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public Ternar_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternar_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterTernar_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitTernar_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitTernar_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ternar_assignmentContext ternar_assignment() throws RecognitionException {
		Ternar_assignmentContext _localctx = new Ternar_assignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ternar_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			identifier_var();
			setState(218);
			match(ASSIGN);
			setState(219);
			match(LEFT_BASIC_BRACK);
			setState(220);
			expr_dec_bool(0);
			setState(221);
			match(RIGHT_BASIC_BRACK);
			setState(222);
			match(QUES_MARK);
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(223);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(224);
				expr_string(0);
				}
				break;
			}
			setState(227);
			match(COLON);
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(228);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(229);
				expr_string(0);
				}
				break;
			}
			setState(232);
			match(SEMI_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_procContext extends ParserRuleContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public List<Expr_dec_boolContext> expr_dec_bool() {
			return getRuleContexts(Expr_dec_boolContext.class);
		}
		public Expr_dec_boolContext expr_dec_bool(int i) {
			return getRuleContext(Expr_dec_boolContext.class,i);
		}
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ourCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ourCParser.COMMA, i);
		}
		public Call_procContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_proc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterCall_proc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitCall_proc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitCall_proc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_procContext call_proc() throws RecognitionException {
		Call_procContext _localctx = new Call_procContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			identifier_var();
			setState(235);
			match(LEFT_BASIC_BRACK);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MINUS) | (1L << OP_PLUS) | (1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(236);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(237);
					expr_string(0);
					}
					break;
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(240);
					match(COMMA);
					setState(243);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(241);
						expr_dec_bool(0);
						}
						break;
					case 2:
						{
						setState(242);
						expr_string(0);
						}
						break;
					}
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(252);
			match(RIGHT_BASIC_BRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Code_blockContext extends ParserRuleContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Var_assignmentContext var_assignment() {
			return getRuleContext(Var_assignmentContext.class,0);
		}
		public Arr_assignmentContext arr_assignment() {
			return getRuleContext(Arr_assignmentContext.class,0);
		}
		public Ternar_assignmentContext ternar_assignment() {
			return getRuleContext(Ternar_assignmentContext.class,0);
		}
		public Call_procContext call_proc() {
			return getRuleContext(Call_procContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(ourCParser.SEMI_COLON, 0); }
		public TerminalNode CON_IF() { return getToken(ourCParser.CON_IF, 0); }
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public List<Expr_dec_boolContext> expr_dec_bool() {
			return getRuleContexts(Expr_dec_boolContext.class);
		}
		public Expr_dec_boolContext expr_dec_bool(int i) {
			return getRuleContext(Expr_dec_boolContext.class,i);
		}
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public List<Block_bodyContext> block_body() {
			return getRuleContexts(Block_bodyContext.class);
		}
		public Block_bodyContext block_body(int i) {
			return getRuleContext(Block_bodyContext.class,i);
		}
		public TerminalNode CON_ELSE() { return getToken(ourCParser.CON_ELSE, 0); }
		public TerminalNode CYC_WHILE() { return getToken(ourCParser.CYC_WHILE, 0); }
		public TerminalNode CYC_FOR() { return getToken(ourCParser.CYC_FOR, 0); }
		public List<Identifier_varContext> identifier_var() {
			return getRuleContexts(Identifier_varContext.class);
		}
		public Identifier_varContext identifier_var(int i) {
			return getRuleContext(Identifier_varContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(ourCParser.ASSIGN, 0); }
		public TerminalNode TO() { return getToken(ourCParser.TO, 0); }
		public List<Dec_valContext> dec_val() {
			return getRuleContexts(Dec_valContext.class);
		}
		public Dec_valContext dec_val(int i) {
			return getRuleContext(Dec_valContext.class,i);
		}
		public TerminalNode CYC_FOREACH() { return getToken(ourCParser.CYC_FOREACH, 0); }
		public TerminalNode COLON() { return getToken(ourCParser.COLON, 0); }
		public TerminalNode CYC_REPEAT() { return getToken(ourCParser.CYC_REPEAT, 0); }
		public TerminalNode CYC_UNTIL() { return getToken(ourCParser.CYC_UNTIL, 0); }
		public TerminalNode CYC_DO() { return getToken(ourCParser.CYC_DO, 0); }
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterCode_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitCode_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitCode_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_code_block);
		int _la;
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				var_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				arr_assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				ternar_assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				call_proc();
				setState(259);
				match(SEMI_COLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				match(CON_IF);
				setState(262);
				match(LEFT_BASIC_BRACK);
				setState(263);
				expr_dec_bool(0);
				setState(264);
				match(RIGHT_BASIC_BRACK);
				setState(265);
				block_body();
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CON_ELSE) {
					{
					setState(266);
					match(CON_ELSE);
					setState(267);
					block_body();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				match(CYC_WHILE);
				setState(271);
				match(LEFT_BASIC_BRACK);
				setState(272);
				expr_dec_bool(0);
				setState(273);
				match(RIGHT_BASIC_BRACK);
				setState(274);
				block_body();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(276);
				match(CYC_FOR);
				setState(277);
				match(LEFT_BASIC_BRACK);
				setState(278);
				identifier_var();
				setState(279);
				match(ASSIGN);
				setState(281);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(280);
					dec_val();
					}
					break;
				}
				setState(283);
				expr_dec_bool(0);
				setState(284);
				match(TO);
				setState(286);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(285);
					dec_val();
					}
					break;
				}
				setState(288);
				expr_dec_bool(0);
				setState(289);
				match(RIGHT_BASIC_BRACK);
				setState(290);
				block_body();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(292);
				match(CYC_FOREACH);
				setState(293);
				match(LEFT_BASIC_BRACK);
				setState(294);
				identifier_var();
				setState(295);
				match(COLON);
				setState(296);
				identifier_var();
				setState(297);
				match(RIGHT_BASIC_BRACK);
				setState(298);
				block_body();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(300);
				match(CYC_REPEAT);
				setState(301);
				block_body();
				setState(302);
				match(CYC_UNTIL);
				setState(303);
				match(LEFT_BASIC_BRACK);
				setState(304);
				expr_dec_bool(0);
				setState(305);
				match(RIGHT_BASIC_BRACK);
				setState(306);
				match(SEMI_COLON);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(308);
				match(CYC_DO);
				setState(309);
				block_body();
				setState(310);
				match(CYC_WHILE);
				setState(311);
				match(LEFT_BASIC_BRACK);
				setState(312);
				expr_dec_bool(0);
				setState(313);
				match(RIGHT_BASIC_BRACK);
				setState(314);
				match(SEMI_COLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_bodyContext extends ParserRuleContext {
		public TerminalNode LEFT_CURLY_BRACK() { return getToken(ourCParser.LEFT_CURLY_BRACK, 0); }
		public TerminalNode RIGHT_CURLY_BRACK() { return getToken(ourCParser.RIGHT_CURLY_BRACK, 0); }
		public List<Code_blockContext> code_block() {
			return getRuleContexts(Code_blockContext.class);
		}
		public Code_blockContext code_block(int i) {
			return getRuleContext(Code_blockContext.class,i);
		}
		public Block_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterBlock_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitBlock_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitBlock_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_bodyContext block_body() throws RecognitionException {
		Block_bodyContext _localctx = new Block_bodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(LEFT_CURLY_BRACK);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0)) {
				{
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(319);
					code_block();
					}
					}
					setState(322); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0) );
				}
			}

			setState(326);
			match(RIGHT_CURLY_BRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Def_procContext extends ParserRuleContext {
		public TerminalNode PROC_DEF() { return getToken(ourCParser.PROC_DEF, 0); }
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public Block_bodyContext block_body() {
			return getRuleContext(Block_bodyContext.class,0);
		}
		public List<Expr_dec_boolContext> expr_dec_bool() {
			return getRuleContexts(Expr_dec_boolContext.class);
		}
		public Expr_dec_boolContext expr_dec_bool(int i) {
			return getRuleContext(Expr_dec_boolContext.class,i);
		}
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ourCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ourCParser.COMMA, i);
		}
		public Def_procContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_proc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterDef_proc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitDef_proc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitDef_proc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Def_procContext def_proc() throws RecognitionException {
		Def_procContext _localctx = new Def_procContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_def_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(PROC_DEF);
			setState(329);
			identifier_var();
			setState(330);
			match(LEFT_BASIC_BRACK);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MINUS) | (1L << OP_PLUS) | (1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(333);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(331);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(332);
					expr_string(0);
					}
					break;
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(335);
					match(COMMA);
					setState(338);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(336);
						expr_dec_bool(0);
						}
						break;
					case 2:
						{
						setState(337);
						expr_string(0);
						}
						break;
					}
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347);
			match(RIGHT_BASIC_BRACK);
			setState(348);
			block_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartContext extends ParserRuleContext {
		public List<Code_blockContext> code_block() {
			return getRuleContexts(Code_blockContext.class);
		}
		public Code_blockContext code_block(int i) {
			return getRuleContext(Code_blockContext.class,i);
		}
		public List<Def_procContext> def_proc() {
			return getRuleContexts(Def_procContext.class);
		}
		public Def_procContext def_proc(int i) {
			return getRuleContext(Def_procContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << PROC_DEF) | (1L << IDENT))) != 0)) {
				{
				setState(352); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(352);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CON_IF:
					case CYC_WHILE:
					case CYC_FOR:
					case CYC_FOREACH:
					case CYC_REPEAT:
					case CYC_DO:
					case BOOL:
					case INT:
					case STRING:
					case CONST:
					case IDENT:
						{
						setState(350);
						code_block();
						}
						break;
					case PROC_DEF:
						{
						setState(351);
						def_proc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(354); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << PROC_DEF) | (1L << IDENT))) != 0) );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_dec_bool_sempred((Expr_dec_boolContext)_localctx, predIndex);
		case 9:
			return expr_string_sempred((Expr_stringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_dec_bool_sempred(Expr_dec_boolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean expr_string_sempred(Expr_stringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0169\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\3\3\3\3\4\5\4:\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\5\bG\n\b\3\b\5\bJ\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n]\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\ni\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\7\nw\n\n\f\n\16\nz\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0083"+
		"\n\13\3\13\3\13\3\13\7\13\u0088\n\13\f\13\16\13\u008b\13\13\3\f\3\f\3"+
		"\f\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u009b"+
		"\n\r\f\r\16\r\u009e\13\r\3\r\3\r\5\r\u00a2\n\r\3\r\3\r\3\16\3\16\3\16"+
		"\7\16\u00a9\n\16\f\16\16\16\u00ac\13\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00bb\n\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00c4\n\21\3\21\3\21\3\22\3\22\5\22\u00ca\n\22\3"+
		"\23\3\23\3\23\3\23\5\23\u00d0\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e4\n\25"+
		"\3\25\3\25\3\25\5\25\u00e9\n\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u00f1"+
		"\n\26\3\26\3\26\3\26\5\26\u00f6\n\26\7\26\u00f8\n\26\f\26\16\26\u00fb"+
		"\13\26\5\26\u00fd\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u010f\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u011c\n\27\3\27\3\27\3\27\5\27"+
		"\u0121\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u013f\n\27\3\30\3\30\6\30\u0143\n\30\r\30\16\30\u0144"+
		"\5\30\u0147\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u0150\n\31\3"+
		"\31\3\31\3\31\5\31\u0155\n\31\7\31\u0157\n\31\f\31\16\31\u015a\13\31\5"+
		"\31\u015c\n\31\3\31\3\31\3\31\3\32\3\32\6\32\u0163\n\32\r\32\16\32\u0164"+
		"\5\32\u0167\n\32\3\32\2\4\22\24\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\2\n\3\2\24\25\3\2\')\3\2\4\5\3\2\7\b\3\2\20\21\4\2"+
		"\3\3\6\6\3\2\7\f\3\2\'(\2\u018b\2\64\3\2\2\2\4\66\3\2\2\2\69\3\2\2\2\b"+
		"=\3\2\2\2\n?\3\2\2\2\fA\3\2\2\2\16I\3\2\2\2\20K\3\2\2\2\22h\3\2\2\2\24"+
		"\u0082\3\2\2\2\26\u008c\3\2\2\2\30\u0097\3\2\2\2\32\u00a5\3\2\2\2\34\u00b0"+
		"\3\2\2\2\36\u00ba\3\2\2\2 \u00be\3\2\2\2\"\u00c9\3\2\2\2$\u00cb\3\2\2"+
		"\2&\u00d3\3\2\2\2(\u00db\3\2\2\2*\u00ec\3\2\2\2,\u013e\3\2\2\2.\u0140"+
		"\3\2\2\2\60\u014a\3\2\2\2\62\u0166\3\2\2\2\64\65\7-\2\2\65\3\3\2\2\2\66"+
		"\67\t\2\2\2\67\5\3\2\2\28:\5\f\7\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7,"+
		"\2\2<\7\3\2\2\2=>\7.\2\2>\t\3\2\2\2?@\t\3\2\2@\13\3\2\2\2AB\t\4\2\2B\r"+
		"\3\2\2\2CJ\7.\2\2DJ\5\4\3\2EG\5\f\7\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ"+
		"\7,\2\2IC\3\2\2\2ID\3\2\2\2IF\3\2\2\2J\17\3\2\2\2KL\7\r\2\2LM\5\2\2\2"+
		"M\21\3\2\2\2NO\b\n\1\2Oi\5\6\4\2Pi\5\4\3\2Qi\5\2\2\2RS\5\2\2\2ST\7\32"+
		"\2\2TU\7,\2\2UV\7\33\2\2Vi\3\2\2\2WX\5\24\13\2XY\t\5\2\2Y\\\5\24\13\2"+
		"Z[\t\6\2\2[]\5\22\n\2\\Z\3\2\2\2\\]\3\2\2\2]i\3\2\2\2^_\7\26\2\2_`\5\22"+
		"\n\2`a\7\27\2\2ai\3\2\2\2bc\7\16\2\2ci\5\22\n\5de\7\5\2\2ei\5\22\n\4f"+
		"g\7\4\2\2gi\5\22\n\3hN\3\2\2\2hP\3\2\2\2hQ\3\2\2\2hR\3\2\2\2hW\3\2\2\2"+
		"h^\3\2\2\2hb\3\2\2\2hd\3\2\2\2hf\3\2\2\2ix\3\2\2\2jk\f\13\2\2kl\t\7\2"+
		"\2lw\5\22\n\fmn\f\n\2\2no\t\4\2\2ow\5\22\n\13pq\f\t\2\2qr\t\b\2\2rw\5"+
		"\22\n\nst\f\b\2\2tu\t\6\2\2uw\5\22\n\tvj\3\2\2\2vm\3\2\2\2vp\3\2\2\2v"+
		"s\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\23\3\2\2\2zx\3\2\2\2{|\b\13\1"+
		"\2|\u0083\5\b\5\2}\u0083\5\2\2\2~\177\7\26\2\2\177\u0080\5\24\13\2\u0080"+
		"\u0081\7\27\2\2\u0081\u0083\3\2\2\2\u0082{\3\2\2\2\u0082}\3\2\2\2\u0082"+
		"~\3\2\2\2\u0083\u0089\3\2\2\2\u0084\u0085\f\4\2\2\u0085\u0086\7\5\2\2"+
		"\u0086\u0088\5\24\13\5\u0087\u0084\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\25\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008d\7\'\2\2\u008d\u0091\5\2\2\2\u008e\u0090\5\20\t\2\u008f\u008e\3"+
		"\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\r\2\2\u0095\u0096\5\22"+
		"\n\2\u0096\27\3\2\2\2\u0097\u0098\7(\2\2\u0098\u009c\5\2\2\2\u0099\u009b"+
		"\5\20\t\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1"+
		"\7\r\2\2\u00a0\u00a2\5\f\7\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\5\22\n\2\u00a4\31\3\2\2\2\u00a5\u00a6\7)\2"+
		"\2\u00a6\u00aa\5\2\2\2\u00a7\u00a9\5\20\t\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\r\2\2\u00ae\u00af\5\24\13\2\u00af"+
		"\33\3\2\2\2\u00b0\u00b1\t\t\2\2\u00b1\u00b2\5\2\2\2\u00b2\u00b3\7\32\2"+
		"\2\u00b3\u00b4\7,\2\2\u00b4\u00b5\7\33\2\2\u00b5\35\3\2\2\2\u00b6\u00bb"+
		"\5\26\f\2\u00b7\u00bb\5\30\r\2\u00b8\u00bb\5\32\16\2\u00b9\u00bb\5\34"+
		"\17\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\23\2\2\u00bd\37\3\2\2"+
		"\2\u00be\u00c3\7*\2\2\u00bf\u00c4\5\26\f\2\u00c0\u00c4\5\30\r\2\u00c1"+
		"\u00c4\5\32\16\2\u00c2\u00c4\5\34\17\2\u00c3\u00bf\3\2\2\2\u00c3\u00c0"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\7\23\2\2\u00c6!\3\2\2\2\u00c7\u00ca\5\36\20\2\u00c8\u00ca\5 \21"+
		"\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca#\3\2\2\2\u00cb\u00cc"+
		"\5\2\2\2\u00cc\u00cf\7\r\2\2\u00cd\u00d0\5\22\n\2\u00ce\u00d0\5\24\13"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2"+
		"\7\23\2\2\u00d2%\3\2\2\2\u00d3\u00d4\5\2\2\2\u00d4\u00d5\7\32\2\2\u00d5"+
		"\u00d6\7,\2\2\u00d6\u00d7\7\33\2\2\u00d7\u00d8\7\r\2\2\u00d8\u00d9\5\22"+
		"\n\2\u00d9\u00da\7\23\2\2\u00da\'\3\2\2\2\u00db\u00dc\5\2\2\2\u00dc\u00dd"+
		"\7\r\2\2\u00dd\u00de\7\26\2\2\u00de\u00df\5\22\n\2\u00df\u00e0\7\27\2"+
		"\2\u00e0\u00e3\7\17\2\2\u00e1\u00e4\5\22\n\2\u00e2\u00e4\5\24\13\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\7\22"+
		"\2\2\u00e6\u00e9\5\22\n\2\u00e7\u00e9\5\24\13\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\23\2\2\u00eb)\3\2\2\2"+
		"\u00ec\u00ed\5\2\2\2\u00ed\u00fc\7\26\2\2\u00ee\u00f1\5\22\n\2\u00ef\u00f1"+
		"\5\24\13\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f9\3\2\2\2"+
		"\u00f2\u00f5\7\34\2\2\u00f3\u00f6\5\22\n\2\u00f4\u00f6\5\24\13\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f2\3\2"+
		"\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\27\2\2\u00ff+\3\2\2\2\u0100\u013f"+
		"\5\"\22\2\u0101\u013f\5$\23\2\u0102\u013f\5&\24\2\u0103\u013f\5(\25\2"+
		"\u0104\u0105\5*\26\2\u0105\u0106\7\23\2\2\u0106\u013f\3\2\2\2\u0107\u0108"+
		"\7\36\2\2\u0108\u0109\7\26\2\2\u0109\u010a\5\22\n\2\u010a\u010b\7\27\2"+
		"\2\u010b\u010e\5.\30\2\u010c\u010d\7\37\2\2\u010d\u010f\5.\30\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u013f\3\2\2\2\u0110\u0111\7 "+
		"\2\2\u0111\u0112\7\26\2\2\u0112\u0113\5\22\n\2\u0113\u0114\7\27\2\2\u0114"+
		"\u0115\5.\30\2\u0115\u013f\3\2\2\2\u0116\u0117\7!\2\2\u0117\u0118\7\26"+
		"\2\2\u0118\u0119\5\2\2\2\u0119\u011b\7\r\2\2\u011a\u011c\5\6\4\2\u011b"+
		"\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\5\22"+
		"\n\2\u011e\u0120\7&\2\2\u011f\u0121\5\6\4\2\u0120\u011f\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\5\22\n\2\u0123\u0124\7"+
		"\27\2\2\u0124\u0125\5.\30\2\u0125\u013f\3\2\2\2\u0126\u0127\7\"\2\2\u0127"+
		"\u0128\7\26\2\2\u0128\u0129\5\2\2\2\u0129\u012a\7\22\2\2\u012a\u012b\5"+
		"\2\2\2\u012b\u012c\7\27\2\2\u012c\u012d\5.\30\2\u012d\u013f\3\2\2\2\u012e"+
		"\u012f\7#\2\2\u012f\u0130\5.\30\2\u0130\u0131\7$\2\2\u0131\u0132\7\26"+
		"\2\2\u0132\u0133\5\22\n\2\u0133\u0134\7\27\2\2\u0134\u0135\7\23\2\2\u0135"+
		"\u013f\3\2\2\2\u0136\u0137\7%\2\2\u0137\u0138\5.\30\2\u0138\u0139\7 \2"+
		"\2\u0139\u013a\7\26\2\2\u013a\u013b\5\22\n\2\u013b\u013c\7\27\2\2\u013c"+
		"\u013d\7\23\2\2\u013d\u013f\3\2\2\2\u013e\u0100\3\2\2\2\u013e\u0101\3"+
		"\2\2\2\u013e\u0102\3\2\2\2\u013e\u0103\3\2\2\2\u013e\u0104\3\2\2\2\u013e"+
		"\u0107\3\2\2\2\u013e\u0110\3\2\2\2\u013e\u0116\3\2\2\2\u013e\u0126\3\2"+
		"\2\2\u013e\u012e\3\2\2\2\u013e\u0136\3\2\2\2\u013f-\3\2\2\2\u0140\u0146"+
		"\7\30\2\2\u0141\u0143\5,\27\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0142"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\7\31\2\2"+
		"\u0149/\3\2\2\2\u014a\u014b\7+\2\2\u014b\u014c\5\2\2\2\u014c\u015b\7\26"+
		"\2\2\u014d\u0150\5\22\n\2\u014e\u0150\5\24\13\2\u014f\u014d\3\2\2\2\u014f"+
		"\u014e\3\2\2\2\u0150\u0158\3\2\2\2\u0151\u0154\7\34\2\2\u0152\u0155\5"+
		"\22\n\2\u0153\u0155\5\24\13\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2"+
		"\u0155\u0157\3\2\2\2\u0156\u0151\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015b"+
		"\u014f\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7\27"+
		"\2\2\u015e\u015f\5.\30\2\u015f\61\3\2\2\2\u0160\u0163\5,\27\2\u0161\u0163"+
		"\5\60\31\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2"+
		"\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0162"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\63\3\2\2\2&9FI\\hvx\u0082\u0089\u0091"+
		"\u009c\u00a1\u00aa\u00ba\u00c3\u00c9\u00cf\u00e3\u00e8\u00f0\u00f5\u00f9"+
		"\u00fc\u010e\u011b\u0120\u013e\u0144\u0146\u014f\u0154\u0158\u015b\u0162"+
		"\u0164\u0166";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}