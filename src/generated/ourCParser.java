// Generated from C:/Users/Ondrej/IdeaProjects/FJP-C-to-PL0\ourC.g4 by ANTLR 4.9
package generated;
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
		COMMENT_START=1, BLANK_SPACE=2, OP_MULTIPLICATION=3, OP_MINUS=4, OP_PLUS=5, 
		OP_DIVISION=6, COMP_IDENT=7, COMP_NOT_IDENT=8, COMP_GRTH=9, COMP_GRTH_EQ=10, 
		COMP_LW=11, COMP_LW_EQ=12, ASSIGN=13, NEGATION=14, QUES_MARK=15, OPER_AND=16, 
		OPER_OR=17, COLON=18, SEMI_COLON=19, BOOL_TRUE=20, BOOL_FALSE=21, LEFT_BASIC_BRACK=22, 
		RIGHT_BASIC_BRACK=23, LEFT_CURLY_BRACK=24, RIGHT_CURLY_BRACK=25, LEFT_NARROW_BRACK=26, 
		RIGHT_NARROW_BRACK=27, COMMA=28, END_OF_COM=29, CON_IF=30, CON_ELSE=31, 
		CYC_WHILE=32, CYC_FOR=33, CYC_FOREACH=34, CYC_REPEAT=35, CYC_UNTIL=36, 
		CYC_DO=37, TO=38, BOOL=39, INT=40, STRING=41, CONST=42, PROC_DEF=43, DEC_NUM=44, 
		IDENT=45, STRING_DEC=46;
	public static final int
		RULE_identifier_var = 0, RULE_bool_val = 1, RULE_dec_val = 2, RULE_string_val = 3, 
		RULE_sign_whole_num = 4, RULE_multi_assign = 5, RULE_expr_dec_bool = 6, 
		RULE_expr_string = 7, RULE_bool_var_dec = 8, RULE_decimal_var_dec = 9, 
		RULE_string_var_dec = 10, RULE_array_var_dec = 11, RULE_var_non_const_dec_command = 12, 
		RULE_var_const_dec_command = 13, RULE_var_declaration = 14, RULE_var_assignment = 15, 
		RULE_arr_assignment = 16, RULE_ternar_assignment = 17, RULE_ternar_declaration = 18, 
		RULE_call_proc = 19, RULE_code_block = 20, RULE_block_body = 21, RULE_def_proc = 22, 
		RULE_start = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier_var", "bool_val", "dec_val", "string_val", "sign_whole_num", 
			"multi_assign", "expr_dec_bool", "expr_string", "bool_var_dec", "decimal_var_dec", 
			"string_var_dec", "array_var_dec", "var_non_const_dec_command", "var_const_dec_command", 
			"var_declaration", "var_assignment", "arr_assignment", "ternar_assignment", 
			"ternar_declaration", "call_proc", "code_block", "block_body", "def_proc", 
			"start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'*'", "'-'", "'+'", "'/'", "'=='", "'!='", "'>'", 
			"'>='", "'<'", "'<='", "'='", "'!'", "'?'", "'and'", "'or'", "':'", "';'", 
			"'true'", "'false'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", 
			"'\n'", "'if'", "'else'", "'while'", "'for'", "'foreach'", "'repeat'", 
			"'until'", "'do'", "'to'", "'bool'", "'int'", "'string'", "'const'", 
			"'procedure'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT_START", "BLANK_SPACE", "OP_MULTIPLICATION", "OP_MINUS", 
			"OP_PLUS", "OP_DIVISION", "COMP_IDENT", "COMP_NOT_IDENT", "COMP_GRTH", 
			"COMP_GRTH_EQ", "COMP_LW", "COMP_LW_EQ", "ASSIGN", "NEGATION", "QUES_MARK", 
			"OPER_AND", "OPER_OR", "COLON", "SEMI_COLON", "BOOL_TRUE", "BOOL_FALSE", 
			"LEFT_BASIC_BRACK", "RIGHT_BASIC_BRACK", "LEFT_CURLY_BRACK", "RIGHT_CURLY_BRACK", 
			"LEFT_NARROW_BRACK", "RIGHT_NARROW_BRACK", "COMMA", "END_OF_COM", "CON_IF", 
			"CON_ELSE", "CYC_WHILE", "CYC_FOR", "CYC_FOREACH", "CYC_REPEAT", "CYC_UNTIL", 
			"CYC_DO", "TO", "BOOL", "INT", "STRING", "CONST", "PROC_DEF", "DEC_NUM", 
			"IDENT", "STRING_DEC"
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
			setState(48);
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
			setState(50);
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_MINUS || _la==OP_PLUS) {
				{
				setState(52);
				sign_whole_num();
				}
			}

			setState(55);
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
			setState(57);
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
		enterRule(_localctx, 8, RULE_sign_whole_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
		enterRule(_localctx, 10, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(ASSIGN);
			setState(62);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr_dec_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(65);
				dec_val();
				}
				break;
			case 2:
				{
				setState(66);
				bool_val();
				}
				break;
			case 3:
				{
				setState(67);
				identifier_var();
				}
				break;
			case 4:
				{
				setState(68);
				identifier_var();
				setState(69);
				match(LEFT_NARROW_BRACK);
				setState(70);
				match(DEC_NUM);
				setState(71);
				match(RIGHT_NARROW_BRACK);
				}
				break;
			case 5:
				{
				setState(73);
				expr_string(0);
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==COMP_IDENT || _la==COMP_NOT_IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				expr_string(0);
				setState(78);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(76);
					_la = _input.LA(1);
					if ( !(_la==OPER_AND || _la==OPER_OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(77);
					expr_dec_bool(0);
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(80);
				match(LEFT_BASIC_BRACK);
				setState(81);
				expr_dec_bool(0);
				setState(82);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			case 7:
				{
				setState(84);
				match(NEGATION);
				setState(85);
				expr_dec_bool(3);
				}
				break;
			case 8:
				{
				setState(86);
				match(OP_PLUS);
				setState(87);
				expr_dec_bool(2);
				}
				break;
			case 9:
				{
				setState(88);
				match(OP_MINUS);
				setState(89);
				expr_dec_bool(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(104);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(92);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(93);
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
						setState(94);
						expr_dec_bool(10);
						}
						break;
					case 2:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(95);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(96);
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
						setState(97);
						expr_dec_bool(9);
						}
						break;
					case 3:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(98);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(99);
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
						setState(100);
						expr_dec_bool(8);
						}
						break;
					case 4:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(101);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(102);
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
						setState(103);
						expr_dec_bool(7);
						}
						break;
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_DEC:
				{
				setState(110);
				string_val();
				}
				break;
			case IDENT:
				{
				setState(111);
				identifier_var();
				}
				break;
			case LEFT_BASIC_BRACK:
				{
				setState(112);
				match(LEFT_BASIC_BRACK);
				setState(113);
				expr_string(0);
				setState(114);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_stringContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_string);
					setState(118);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(119);
					match(OP_PLUS);
					setState(120);
					expr_string(3);
					}
					} 
				}
				setState(125);
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
		enterRule(_localctx, 16, RULE_bool_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(BOOL);
			setState(127);
			identifier_var();
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					multi_assign();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(134);
			match(ASSIGN);
			setState(135);
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
		enterRule(_localctx, 18, RULE_decimal_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(INT);
			setState(138);
			identifier_var();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(139);
					multi_assign();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(145);
			match(ASSIGN);
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(146);
				sign_whole_num();
				}
				break;
			}
			setState(149);
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
		enterRule(_localctx, 20, RULE_string_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(STRING);
			setState(152);
			identifier_var();
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(153);
					multi_assign();
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(159);
			match(ASSIGN);
			setState(160);
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
		enterRule(_localctx, 22, RULE_array_var_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(163);
			identifier_var();
			setState(164);
			match(LEFT_NARROW_BRACK);
			setState(165);
			match(DEC_NUM);
			setState(166);
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
		enterRule(_localctx, 24, RULE_var_non_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(168);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(169);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(170);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(171);
				array_var_dec();
				}
				break;
			}
			setState(174);
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
		enterRule(_localctx, 26, RULE_var_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(CONST);
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(177);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(178);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(179);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(180);
				array_var_dec();
				}
				break;
			}
			setState(183);
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
		enterRule(_localctx, 28, RULE_var_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
				{
				setState(185);
				var_non_const_dec_command();
				}
				break;
			case CONST:
				{
				setState(186);
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
		enterRule(_localctx, 30, RULE_var_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			identifier_var();
			setState(190);
			match(ASSIGN);
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(191);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(192);
				expr_string(0);
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
		enterRule(_localctx, 32, RULE_arr_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			identifier_var();
			setState(198);
			match(LEFT_NARROW_BRACK);
			setState(199);
			match(DEC_NUM);
			setState(200);
			match(RIGHT_NARROW_BRACK);
			setState(201);
			match(ASSIGN);
			{
			setState(202);
			expr_dec_bool(0);
			}
			setState(203);
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
		enterRule(_localctx, 34, RULE_ternar_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			identifier_var();
			setState(206);
			match(ASSIGN);
			setState(207);
			match(LEFT_BASIC_BRACK);
			setState(208);
			expr_dec_bool(0);
			setState(209);
			match(RIGHT_BASIC_BRACK);
			setState(210);
			match(QUES_MARK);
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(211);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(212);
				expr_string(0);
				}
				break;
			}
			setState(215);
			match(COLON);
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(216);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(217);
				expr_string(0);
				}
				break;
			}
			setState(220);
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

	public static class Ternar_declarationContext extends ParserRuleContext {
		public Ternar_assignmentContext ternar_assignment() {
			return getRuleContext(Ternar_assignmentContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(ourCParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(ourCParser.INT, 0); }
		public TerminalNode STRING() { return getToken(ourCParser.STRING, 0); }
		public Ternar_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternar_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterTernar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitTernar_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitTernar_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ternar_declarationContext ternar_declaration() throws RecognitionException {
		Ternar_declarationContext _localctx = new Ternar_declarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ternar_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(223);
			ternar_assignment();
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
		enterRule(_localctx, 38, RULE_call_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			identifier_var();
			setState(226);
			match(LEFT_BASIC_BRACK);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MINUS) | (1L << OP_PLUS) | (1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(229);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(227);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(228);
					expr_string(0);
					}
					break;
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(231);
					match(COMMA);
					setState(234);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(232);
						expr_dec_bool(0);
						}
						break;
					case 2:
						{
						setState(233);
						expr_string(0);
						}
						break;
					}
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(243);
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
		public Ternar_declarationContext ternar_declaration() {
			return getRuleContext(Ternar_declarationContext.class,0);
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
		enterRule(_localctx, 40, RULE_code_block);
		int _la;
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				var_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				arr_assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				ternar_assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				ternar_declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				call_proc();
				setState(251);
				match(SEMI_COLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				match(CON_IF);
				setState(254);
				match(LEFT_BASIC_BRACK);
				setState(255);
				expr_dec_bool(0);
				setState(256);
				match(RIGHT_BASIC_BRACK);
				setState(257);
				block_body();
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CON_ELSE) {
					{
					setState(258);
					match(CON_ELSE);
					setState(259);
					block_body();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(262);
				match(CYC_WHILE);
				setState(263);
				match(LEFT_BASIC_BRACK);
				setState(264);
				expr_dec_bool(0);
				setState(265);
				match(RIGHT_BASIC_BRACK);
				setState(266);
				block_body();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(268);
				match(CYC_FOR);
				setState(269);
				match(LEFT_BASIC_BRACK);
				setState(270);
				identifier_var();
				setState(271);
				match(ASSIGN);
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(272);
					dec_val();
					}
					break;
				}
				setState(275);
				expr_dec_bool(0);
				setState(276);
				match(TO);
				setState(278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(277);
					dec_val();
					}
					break;
				}
				setState(280);
				expr_dec_bool(0);
				setState(281);
				match(RIGHT_BASIC_BRACK);
				setState(282);
				block_body();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(284);
				match(CYC_FOREACH);
				setState(285);
				match(LEFT_BASIC_BRACK);
				setState(286);
				identifier_var();
				setState(287);
				match(COLON);
				setState(288);
				identifier_var();
				setState(289);
				match(RIGHT_BASIC_BRACK);
				setState(290);
				block_body();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(292);
				match(CYC_REPEAT);
				setState(293);
				block_body();
				setState(294);
				match(CYC_UNTIL);
				setState(295);
				match(LEFT_BASIC_BRACK);
				setState(296);
				expr_dec_bool(0);
				setState(297);
				match(RIGHT_BASIC_BRACK);
				setState(298);
				match(SEMI_COLON);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(300);
				match(CYC_DO);
				setState(301);
				block_body();
				setState(302);
				match(CYC_WHILE);
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
		enterRule(_localctx, 42, RULE_block_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(LEFT_CURLY_BRACK);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0)) {
				{
				setState(312); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(311);
					code_block();
					}
					}
					setState(314); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0) );
				}
			}

			setState(318);
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
		public List<TerminalNode> BOOL() { return getTokens(ourCParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(ourCParser.BOOL, i);
		}
		public List<TerminalNode> INT() { return getTokens(ourCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ourCParser.INT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ourCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ourCParser.COMMA, i);
		}
		public List<TerminalNode> STRING() { return getTokens(ourCParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ourCParser.STRING, i);
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
		enterRule(_localctx, 44, RULE_def_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(PROC_DEF);
			setState(321);
			identifier_var();
			setState(322);
			match(LEFT_BASIC_BRACK);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(327);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case INT:
					{
					setState(323);
					_la = _input.LA(1);
					if ( !(_la==BOOL || _la==INT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(324);
					expr_dec_bool(0);
					}
					break;
				case STRING:
					{
					{
					setState(325);
					match(STRING);
					}
					setState(326);
					expr_string(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(329);
					match(COMMA);
					setState(334);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOL:
					case INT:
						{
						setState(330);
						_la = _input.LA(1);
						if ( !(_la==BOOL || _la==INT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(331);
						expr_dec_bool(0);
						}
						break;
					case STRING:
						{
						{
						setState(332);
						match(STRING);
						}
						setState(333);
						expr_string(0);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(340);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(343);
			match(RIGHT_BASIC_BRACK);
			setState(344);
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
		enterRule(_localctx, 46, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << PROC_DEF) | (1L << IDENT))) != 0)) {
				{
				setState(348); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(348);
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
						setState(346);
						code_block();
						}
						break;
					case PROC_DEF:
						{
						setState(347);
						def_proc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(350); 
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
		case 6:
			return expr_dec_bool_sempred((Expr_dec_boolContext)_localctx, predIndex);
		case 7:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0165\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\3\3\3\3\4\5\48\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tw\n\t\3\t\3\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\3\n\3\n\3\n\7\n\u0084"+
		"\n\n\f\n\16\n\u0087\13\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008f\n\13\f"+
		"\13\16\13\u0092\13\13\3\13\3\13\5\13\u0096\n\13\3\13\3\13\3\f\3\f\3\f"+
		"\7\f\u009d\n\f\f\f\16\f\u00a0\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00b8\n\17\3\17\3\17\3\20\3\20\5\20\u00be\n\20\3\21\3\21\3\21\3"+
		"\21\5\21\u00c4\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d8\n\23\3\23\3\23\3\23"+
		"\5\23\u00dd\n\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00e8"+
		"\n\25\3\25\3\25\3\25\5\25\u00ed\n\25\7\25\u00ef\n\25\f\25\16\25\u00f2"+
		"\13\25\5\25\u00f4\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0107\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0114\n\26\3\26\3\26\3\26"+
		"\5\26\u0119\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0137\n\26\3\27\3\27\6\27\u013b\n\27\r\27\16\27\u013c"+
		"\5\27\u013f\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u014a"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0151\n\30\7\30\u0153\n\30\f\30\16"+
		"\30\u0156\13\30\5\30\u0158\n\30\3\30\3\30\3\30\3\31\3\31\6\31\u015f\n"+
		"\31\r\31\16\31\u0160\5\31\u0163\n\31\3\31\2\4\16\20\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\n\3\2\26\27\3\2\6\7\3\2\t\n\3\2"+
		"\22\23\4\2\5\5\b\b\3\2\t\16\3\2)*\3\2)+\2\u0186\2\62\3\2\2\2\4\64\3\2"+
		"\2\2\6\67\3\2\2\2\b;\3\2\2\2\n=\3\2\2\2\f?\3\2\2\2\16\\\3\2\2\2\20v\3"+
		"\2\2\2\22\u0080\3\2\2\2\24\u008b\3\2\2\2\26\u0099\3\2\2\2\30\u00a4\3\2"+
		"\2\2\32\u00ae\3\2\2\2\34\u00b2\3\2\2\2\36\u00bd\3\2\2\2 \u00bf\3\2\2\2"+
		"\"\u00c7\3\2\2\2$\u00cf\3\2\2\2&\u00e0\3\2\2\2(\u00e3\3\2\2\2*\u0136\3"+
		"\2\2\2,\u0138\3\2\2\2.\u0142\3\2\2\2\60\u0162\3\2\2\2\62\63\7/\2\2\63"+
		"\3\3\2\2\2\64\65\t\2\2\2\65\5\3\2\2\2\668\5\n\6\2\67\66\3\2\2\2\678\3"+
		"\2\2\289\3\2\2\29:\7.\2\2:\7\3\2\2\2;<\7\60\2\2<\t\3\2\2\2=>\t\3\2\2>"+
		"\13\3\2\2\2?@\7\17\2\2@A\5\2\2\2A\r\3\2\2\2BC\b\b\1\2C]\5\6\4\2D]\5\4"+
		"\3\2E]\5\2\2\2FG\5\2\2\2GH\7\34\2\2HI\7.\2\2IJ\7\35\2\2J]\3\2\2\2KL\5"+
		"\20\t\2LM\t\4\2\2MP\5\20\t\2NO\t\5\2\2OQ\5\16\b\2PN\3\2\2\2PQ\3\2\2\2"+
		"Q]\3\2\2\2RS\7\30\2\2ST\5\16\b\2TU\7\31\2\2U]\3\2\2\2VW\7\20\2\2W]\5\16"+
		"\b\5XY\7\7\2\2Y]\5\16\b\4Z[\7\6\2\2[]\5\16\b\3\\B\3\2\2\2\\D\3\2\2\2\\"+
		"E\3\2\2\2\\F\3\2\2\2\\K\3\2\2\2\\R\3\2\2\2\\V\3\2\2\2\\X\3\2\2\2\\Z\3"+
		"\2\2\2]l\3\2\2\2^_\f\13\2\2_`\t\6\2\2`k\5\16\b\fab\f\n\2\2bc\t\3\2\2c"+
		"k\5\16\b\13de\f\t\2\2ef\t\7\2\2fk\5\16\b\ngh\f\b\2\2hi\t\5\2\2ik\5\16"+
		"\b\tj^\3\2\2\2ja\3\2\2\2jd\3\2\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2"+
		"\2\2m\17\3\2\2\2nl\3\2\2\2op\b\t\1\2pw\5\b\5\2qw\5\2\2\2rs\7\30\2\2st"+
		"\5\20\t\2tu\7\31\2\2uw\3\2\2\2vo\3\2\2\2vq\3\2\2\2vr\3\2\2\2w}\3\2\2\2"+
		"xy\f\4\2\2yz\7\7\2\2z|\5\20\t\5{x\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\21\3\2\2\2\177}\3\2\2\2\u0080\u0081\7)\2\2\u0081\u0085\5\2\2\2\u0082"+
		"\u0084\5\f\7\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"\u0089\7\17\2\2\u0089\u008a\5\16\b\2\u008a\23\3\2\2\2\u008b\u008c\7*\2"+
		"\2\u008c\u0090\5\2\2\2\u008d\u008f\5\f\7\2\u008e\u008d\3\2\2\2\u008f\u0092"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0095\7\17\2\2\u0094\u0096\5\n\6\2\u0095\u0094\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\5\16\b\2\u0098"+
		"\25\3\2\2\2\u0099\u009a\7+\2\2\u009a\u009e\5\2\2\2\u009b\u009d\5\f\7\2"+
		"\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\17\2\2"+
		"\u00a2\u00a3\5\20\t\2\u00a3\27\3\2\2\2\u00a4\u00a5\t\b\2\2\u00a5\u00a6"+
		"\5\2\2\2\u00a6\u00a7\7\34\2\2\u00a7\u00a8\7.\2\2\u00a8\u00a9\7\35\2\2"+
		"\u00a9\31\3\2\2\2\u00aa\u00af\5\22\n\2\u00ab\u00af\5\24\13\2\u00ac\u00af"+
		"\5\26\f\2\u00ad\u00af\5\30\r\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab\3\2\2\2"+
		"\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1"+
		"\7\25\2\2\u00b1\33\3\2\2\2\u00b2\u00b7\7,\2\2\u00b3\u00b8\5\22\n\2\u00b4"+
		"\u00b8\5\24\13\2\u00b5\u00b8\5\26\f\2\u00b6\u00b8\5\30\r\2\u00b7\u00b3"+
		"\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\7\25\2\2\u00ba\35\3\2\2\2\u00bb\u00be\5\32"+
		"\16\2\u00bc\u00be\5\34\17\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\37\3\2\2\2\u00bf\u00c0\5\2\2\2\u00c0\u00c3\7\17\2\2\u00c1\u00c4\5\16"+
		"\b\2\u00c2\u00c4\5\20\t\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7\25\2\2\u00c6!\3\2\2\2\u00c7\u00c8\5\2\2\2"+
		"\u00c8\u00c9\7\34\2\2\u00c9\u00ca\7.\2\2\u00ca\u00cb\7\35\2\2\u00cb\u00cc"+
		"\7\17\2\2\u00cc\u00cd\5\16\b\2\u00cd\u00ce\7\25\2\2\u00ce#\3\2\2\2\u00cf"+
		"\u00d0\5\2\2\2\u00d0\u00d1\7\17\2\2\u00d1\u00d2\7\30\2\2\u00d2\u00d3\5"+
		"\16\b\2\u00d3\u00d4\7\31\2\2\u00d4\u00d7\7\21\2\2\u00d5\u00d8\5\16\b\2"+
		"\u00d6\u00d8\5\20\t\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00dc\7\24\2\2\u00da\u00dd\5\16\b\2\u00db\u00dd\5\20\t"+
		"\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df"+
		"\7\25\2\2\u00df%\3\2\2\2\u00e0\u00e1\t\t\2\2\u00e1\u00e2\5$\23\2\u00e2"+
		"\'\3\2\2\2\u00e3\u00e4\5\2\2\2\u00e4\u00f3\7\30\2\2\u00e5\u00e8\5\16\b"+
		"\2\u00e6\u00e8\5\20\t\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00f0\3\2\2\2\u00e9\u00ec\7\36\2\2\u00ea\u00ed\5\16\b\2\u00eb\u00ed\5"+
		"\20\t\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00e9\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00e7\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7\31\2\2\u00f6)\3\2\2\2"+
		"\u00f7\u0137\5\36\20\2\u00f8\u0137\5 \21\2\u00f9\u0137\5\"\22\2\u00fa"+
		"\u0137\5$\23\2\u00fb\u0137\5&\24\2\u00fc\u00fd\5(\25\2\u00fd\u00fe\7\25"+
		"\2\2\u00fe\u0137\3\2\2\2\u00ff\u0100\7 \2\2\u0100\u0101\7\30\2\2\u0101"+
		"\u0102\5\16\b\2\u0102\u0103\7\31\2\2\u0103\u0106\5,\27\2\u0104\u0105\7"+
		"!\2\2\u0105\u0107\5,\27\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u0137\3\2\2\2\u0108\u0109\7\"\2\2\u0109\u010a\7\30\2\2\u010a\u010b\5"+
		"\16\b\2\u010b\u010c\7\31\2\2\u010c\u010d\5,\27\2\u010d\u0137\3\2\2\2\u010e"+
		"\u010f\7#\2\2\u010f\u0110\7\30\2\2\u0110\u0111\5\2\2\2\u0111\u0113\7\17"+
		"\2\2\u0112\u0114\5\6\4\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\5\16\b\2\u0116\u0118\7(\2\2\u0117\u0119\5\6"+
		"\4\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\5\16\b\2\u011b\u011c\7\31\2\2\u011c\u011d\5,\27\2\u011d\u0137\3"+
		"\2\2\2\u011e\u011f\7$\2\2\u011f\u0120\7\30\2\2\u0120\u0121\5\2\2\2\u0121"+
		"\u0122\7\24\2\2\u0122\u0123\5\2\2\2\u0123\u0124\7\31\2\2\u0124\u0125\5"+
		",\27\2\u0125\u0137\3\2\2\2\u0126\u0127\7%\2\2\u0127\u0128\5,\27\2\u0128"+
		"\u0129\7&\2\2\u0129\u012a\7\30\2\2\u012a\u012b\5\16\b\2\u012b\u012c\7"+
		"\31\2\2\u012c\u012d\7\25\2\2\u012d\u0137\3\2\2\2\u012e\u012f\7\'\2\2\u012f"+
		"\u0130\5,\27\2\u0130\u0131\7\"\2\2\u0131\u0132\7\30\2\2\u0132\u0133\5"+
		"\16\b\2\u0133\u0134\7\31\2\2\u0134\u0135\7\25\2\2\u0135\u0137\3\2\2\2"+
		"\u0136\u00f7\3\2\2\2\u0136\u00f8\3\2\2\2\u0136\u00f9\3\2\2\2\u0136\u00fa"+
		"\3\2\2\2\u0136\u00fb\3\2\2\2\u0136\u00fc\3\2\2\2\u0136\u00ff\3\2\2\2\u0136"+
		"\u0108\3\2\2\2\u0136\u010e\3\2\2\2\u0136\u011e\3\2\2\2\u0136\u0126\3\2"+
		"\2\2\u0136\u012e\3\2\2\2\u0137+\3\2\2\2\u0138\u013e\7\32\2\2\u0139\u013b"+
		"\5*\26\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013a\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7\33\2\2\u0141-\3\2\2\2\u0142\u0143"+
		"\7-\2\2\u0143\u0144\5\2\2\2\u0144\u0157\7\30\2\2\u0145\u0146\t\b\2\2\u0146"+
		"\u014a\5\16\b\2\u0147\u0148\7+\2\2\u0148\u014a\5\20\t\2\u0149\u0145\3"+
		"\2\2\2\u0149\u0147\3\2\2\2\u014a\u0154\3\2\2\2\u014b\u0150\7\36\2\2\u014c"+
		"\u014d\t\b\2\2\u014d\u0151\5\16\b\2\u014e\u014f\7+\2\2\u014f\u0151\5\20"+
		"\t\2\u0150\u014c\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0153\3\2\2\2\u0152"+
		"\u014b\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0149\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\7\31\2\2\u015a\u015b\5"+
		",\27\2\u015b/\3\2\2\2\u015c\u015f\5*\26\2\u015d\u015f\5.\30\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u015e\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\61\3\2\2\2$\67P\\jlv}\u0085\u0090\u0095\u009e\u00ae\u00b7\u00bd"+
		"\u00c3\u00d7\u00dc\u00e7\u00ec\u00f0\u00f3\u0106\u0113\u0118\u0136\u013c"+
		"\u013e\u0149\u0150\u0154\u0157\u015e\u0160\u0162";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}