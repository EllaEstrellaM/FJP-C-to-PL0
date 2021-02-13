// Generated from C:/Users/elisk/Documents/FJP-C-to-PL0\ourC.g4 by ANTLR 4.9
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
		RULE_multi_assign = 4, RULE_expr_dec_bool = 5, RULE_expr_string = 6, RULE_bool_var_dec = 7, 
		RULE_decimal_var_dec = 8, RULE_string_var_dec = 9, RULE_array_var_dec = 10, 
		RULE_var_non_const_dec_command = 11, RULE_var_const_dec_command = 12, 
		RULE_var_declaration = 13, RULE_var_assignment = 14, RULE_arr_assignment = 15, 
		RULE_ternar_assignment = 16, RULE_ternar_declaration = 17, RULE_call_proc = 18, 
		RULE_code_block = 19, RULE_block_body = 20, RULE_def_proc = 21, RULE_start = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier_var", "bool_val", "dec_val", "string_val", "multi_assign", 
			"expr_dec_bool", "expr_string", "bool_var_dec", "decimal_var_dec", "string_var_dec", 
			"array_var_dec", "var_non_const_dec_command", "var_const_dec_command", 
			"var_declaration", "var_assignment", "arr_assignment", "ternar_assignment", 
			"ternar_declaration", "call_proc", "code_block", "block_body", "def_proc", 
			"start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'*'", "'-'", "'+'", "'/'", "'=='", "'!='", "'>'", 
			"'>='", "'<'", "'<='", "'='", "'!'", "'?'", "'&'", "'|'", "':'", "';'", 
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
			setState(46);
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
			setState(48);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
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
			setState(52);
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
		enterRule(_localctx, 8, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ASSIGN);
			setState(55);
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
		public TerminalNode OP_MULTIPLICATION() { return getToken(ourCParser.OP_MULTIPLICATION, 0); }
		public TerminalNode OP_DIVISION() { return getToken(ourCParser.OP_DIVISION, 0); }
		public TerminalNode OP_PLUS() { return getToken(ourCParser.OP_PLUS, 0); }
		public TerminalNode OP_MINUS() { return getToken(ourCParser.OP_MINUS, 0); }
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr_dec_bool, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(58);
				dec_val();
				}
				break;
			case 2:
				{
				setState(59);
				bool_val();
				}
				break;
			case 3:
				{
				setState(60);
				identifier_var();
				}
				break;
			case 4:
				{
				setState(61);
				identifier_var();
				setState(62);
				match(LEFT_NARROW_BRACK);
				setState(63);
				match(DEC_NUM);
				setState(64);
				match(RIGHT_NARROW_BRACK);
				}
				break;
			case 5:
				{
				setState(66);
				expr_string(0);
				setState(67);
				_la = _input.LA(1);
				if ( !(_la==COMP_IDENT || _la==COMP_NOT_IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(68);
				expr_string(0);
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(69);
					_la = _input.LA(1);
					if ( !(_la==OPER_AND || _la==OPER_OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(70);
					expr_dec_bool(0);
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(73);
				match(LEFT_BASIC_BRACK);
				setState(74);
				expr_dec_bool(0);
				setState(75);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			case 7:
				{
				setState(77);
				match(NEGATION);
				setState(78);
				expr_dec_bool(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(81);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(82);
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
						setState(83);
						expr_dec_bool(8);
						}
						break;
					case 2:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(84);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(85);
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
						setState(86);
						expr_dec_bool(7);
						}
						break;
					case 3:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(87);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(88);
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
						setState(89);
						expr_dec_bool(6);
						}
						break;
					case 4:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(90);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(91);
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
						setState(92);
						expr_dec_bool(5);
						}
						break;
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr_string, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_DEC:
				{
				setState(99);
				string_val();
				}
				break;
			case IDENT:
				{
				setState(100);
				identifier_var();
				}
				break;
			case LEFT_BASIC_BRACK:
				{
				setState(101);
				match(LEFT_BASIC_BRACK);
				setState(102);
				expr_string(0);
				setState(103);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_stringContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_string);
					setState(107);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(108);
					match(OP_PLUS);
					setState(109);
					expr_string(3);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 14, RULE_bool_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(BOOL);
			setState(116);
			identifier_var();
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					multi_assign();
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(123);
			match(ASSIGN);
			setState(124);
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
		enterRule(_localctx, 16, RULE_decimal_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(INT);
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
		enterRule(_localctx, 18, RULE_string_var_dec);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(STRING);
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
			setState(146);
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
		enterRule(_localctx, 20, RULE_array_var_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(149);
			identifier_var();
			setState(150);
			match(LEFT_NARROW_BRACK);
			setState(151);
			match(DEC_NUM);
			setState(152);
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
		enterRule(_localctx, 22, RULE_var_non_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(154);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(155);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(156);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(157);
				array_var_dec();
				}
				break;
			}
			setState(160);
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
		enterRule(_localctx, 24, RULE_var_const_dec_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(CONST);
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(163);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(164);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(165);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(166);
				array_var_dec();
				}
				break;
			}
			setState(169);
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
		enterRule(_localctx, 26, RULE_var_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
				{
				setState(171);
				var_non_const_dec_command();
				}
				break;
			case CONST:
				{
				setState(172);
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
		enterRule(_localctx, 28, RULE_var_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			identifier_var();
			setState(176);
			match(ASSIGN);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(177);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(178);
				expr_string(0);
				}
				break;
			}
			setState(181);
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
		enterRule(_localctx, 30, RULE_arr_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			identifier_var();
			setState(184);
			match(LEFT_NARROW_BRACK);
			setState(185);
			match(DEC_NUM);
			setState(186);
			match(RIGHT_NARROW_BRACK);
			setState(187);
			match(ASSIGN);
			{
			setState(188);
			expr_dec_bool(0);
			}
			setState(189);
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
		enterRule(_localctx, 32, RULE_ternar_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			identifier_var();
			setState(192);
			match(ASSIGN);
			setState(193);
			match(LEFT_BASIC_BRACK);
			setState(194);
			expr_dec_bool(0);
			setState(195);
			match(RIGHT_BASIC_BRACK);
			setState(196);
			match(QUES_MARK);
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(197);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(198);
				expr_string(0);
				}
				break;
			}
			setState(201);
			match(COLON);
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(202);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(203);
				expr_string(0);
				}
				break;
			}
			setState(206);
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
		enterRule(_localctx, 34, RULE_ternar_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(209);
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
		enterRule(_localctx, 36, RULE_call_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			identifier_var();
			setState(212);
			match(LEFT_BASIC_BRACK);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(213);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(214);
					expr_string(0);
					}
					break;
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(217);
					match(COMMA);
					setState(220);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(218);
						expr_dec_bool(0);
						}
						break;
					case 2:
						{
						setState(219);
						expr_string(0);
						}
						break;
					}
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(229);
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
		enterRule(_localctx, 38, RULE_code_block);
		int _la;
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				var_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				arr_assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
				ternar_assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				ternar_declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				call_proc();
				setState(237);
				match(SEMI_COLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(239);
				match(CON_IF);
				setState(240);
				match(LEFT_BASIC_BRACK);
				setState(241);
				expr_dec_bool(0);
				setState(242);
				match(RIGHT_BASIC_BRACK);
				setState(243);
				block_body();
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CON_ELSE) {
					{
					setState(244);
					match(CON_ELSE);
					setState(245);
					block_body();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(248);
				match(CYC_WHILE);
				setState(249);
				match(LEFT_BASIC_BRACK);
				setState(250);
				expr_dec_bool(0);
				setState(251);
				match(RIGHT_BASIC_BRACK);
				setState(252);
				block_body();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(254);
				match(CYC_FOR);
				setState(255);
				match(LEFT_BASIC_BRACK);
				setState(256);
				identifier_var();
				setState(257);
				match(ASSIGN);
				setState(259);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(258);
					dec_val();
					}
					break;
				}
				setState(261);
				expr_dec_bool(0);
				setState(262);
				match(TO);
				setState(264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(263);
					dec_val();
					}
					break;
				}
				setState(266);
				expr_dec_bool(0);
				setState(267);
				match(RIGHT_BASIC_BRACK);
				setState(268);
				block_body();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(270);
				match(CYC_FOREACH);
				setState(271);
				match(LEFT_BASIC_BRACK);
				setState(272);
				identifier_var();
				setState(273);
				match(COLON);
				setState(274);
				identifier_var();
				setState(275);
				match(RIGHT_BASIC_BRACK);
				setState(276);
				block_body();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(278);
				match(CYC_REPEAT);
				setState(279);
				block_body();
				setState(280);
				match(CYC_UNTIL);
				setState(281);
				match(LEFT_BASIC_BRACK);
				setState(282);
				expr_dec_bool(0);
				setState(283);
				match(RIGHT_BASIC_BRACK);
				setState(284);
				match(SEMI_COLON);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(286);
				match(CYC_DO);
				setState(287);
				block_body();
				setState(288);
				match(CYC_WHILE);
				setState(289);
				match(LEFT_BASIC_BRACK);
				setState(290);
				expr_dec_bool(0);
				setState(291);
				match(RIGHT_BASIC_BRACK);
				setState(292);
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
		enterRule(_localctx, 40, RULE_block_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(LEFT_CURLY_BRACK);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0)) {
				{
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(297);
					code_block();
					}
					}
					setState(300); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0) );
				}
			}

			setState(304);
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
		enterRule(_localctx, 42, RULE_def_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(PROC_DEF);
			setState(307);
			identifier_var();
			setState(308);
			match(LEFT_BASIC_BRACK);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(313);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case INT:
					{
					setState(309);
					_la = _input.LA(1);
					if ( !(_la==BOOL || _la==INT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(310);
					expr_dec_bool(0);
					}
					break;
				case STRING:
					{
					{
					setState(311);
					match(STRING);
					}
					setState(312);
					expr_string(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(315);
					match(COMMA);
					setState(320);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOL:
					case INT:
						{
						setState(316);
						_la = _input.LA(1);
						if ( !(_la==BOOL || _la==INT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(317);
						expr_dec_bool(0);
						}
						break;
					case STRING:
						{
						{
						setState(318);
						match(STRING);
						}
						setState(319);
						expr_string(0);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(329);
			match(RIGHT_BASIC_BRACK);
			setState(330);
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
		enterRule(_localctx, 44, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << PROC_DEF) | (1L << IDENT))) != 0)) {
				{
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(334);
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
						setState(332);
						code_block();
						}
						break;
					case PROC_DEF:
						{
						setState(333);
						def_proc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(336); 
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
		case 5:
			return expr_dec_bool_sempred((Expr_dec_boolContext)_localctx, predIndex);
		case 6:
			return expr_string_sempred((Expr_stringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_dec_bool_sempred(Expr_dec_boolContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0157\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7J\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7R\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bl\n\b\3\b\3\b\3\b\7\bq\n\b\f\b\16\bt\13\b\3"+
		"\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u0084\n"+
		"\n\f\n\16\n\u0087\13\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008f\n\13\f\13"+
		"\16\13\u0092\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\5\r\u00a1\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16\u00aa\n\16\3"+
		"\16\3\16\3\17\3\17\5\17\u00b0\n\17\3\20\3\20\3\20\3\20\5\20\u00b6\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00ca\n\22\3\22\3\22\3\22\5\22\u00cf\n\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00da\n\24\3\24\3\24"+
		"\3\24\5\24\u00df\n\24\7\24\u00e1\n\24\f\24\16\24\u00e4\13\24\5\24\u00e6"+
		"\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00f9\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0106\n\25\3\25\3\25\3\25\5\25\u010b\n\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u0129\n\25\3\26\3\26\6\26\u012d\n\26\r\26\16\26\u012e\5\26\u0131\n"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u013c\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0143\n\27\7\27\u0145\n\27\f\27\16\27\u0148"+
		"\13\27\5\27\u014a\n\27\3\27\3\27\3\27\3\30\3\30\6\30\u0151\n\30\r\30\16"+
		"\30\u0152\5\30\u0155\n\30\3\30\2\4\f\16\31\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\2\n\3\2\26\27\3\2\t\n\3\2\22\23\4\2\5\5\b\b\3\2"+
		"\6\7\3\2\t\16\3\2)*\3\2)+\2\u0175\2\60\3\2\2\2\4\62\3\2\2\2\6\64\3\2\2"+
		"\2\b\66\3\2\2\2\n8\3\2\2\2\fQ\3\2\2\2\16k\3\2\2\2\20u\3\2\2\2\22\u0080"+
		"\3\2\2\2\24\u008b\3\2\2\2\26\u0096\3\2\2\2\30\u00a0\3\2\2\2\32\u00a4\3"+
		"\2\2\2\34\u00af\3\2\2\2\36\u00b1\3\2\2\2 \u00b9\3\2\2\2\"\u00c1\3\2\2"+
		"\2$\u00d2\3\2\2\2&\u00d5\3\2\2\2(\u0128\3\2\2\2*\u012a\3\2\2\2,\u0134"+
		"\3\2\2\2.\u0154\3\2\2\2\60\61\7/\2\2\61\3\3\2\2\2\62\63\t\2\2\2\63\5\3"+
		"\2\2\2\64\65\7.\2\2\65\7\3\2\2\2\66\67\7\60\2\2\67\t\3\2\2\289\7\17\2"+
		"\29:\5\2\2\2:\13\3\2\2\2;<\b\7\1\2<R\5\6\4\2=R\5\4\3\2>R\5\2\2\2?@\5\2"+
		"\2\2@A\7\34\2\2AB\7.\2\2BC\7\35\2\2CR\3\2\2\2DE\5\16\b\2EF\t\3\2\2FI\5"+
		"\16\b\2GH\t\4\2\2HJ\5\f\7\2IG\3\2\2\2IJ\3\2\2\2JR\3\2\2\2KL\7\30\2\2L"+
		"M\5\f\7\2MN\7\31\2\2NR\3\2\2\2OP\7\20\2\2PR\5\f\7\3Q;\3\2\2\2Q=\3\2\2"+
		"\2Q>\3\2\2\2Q?\3\2\2\2QD\3\2\2\2QK\3\2\2\2QO\3\2\2\2Ra\3\2\2\2ST\f\t\2"+
		"\2TU\t\5\2\2U`\5\f\7\nVW\f\b\2\2WX\t\6\2\2X`\5\f\7\tYZ\f\7\2\2Z[\t\7\2"+
		"\2[`\5\f\7\b\\]\f\6\2\2]^\t\4\2\2^`\5\f\7\7_S\3\2\2\2_V\3\2\2\2_Y\3\2"+
		"\2\2_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\r\3\2\2\2ca\3\2\2\2de\b"+
		"\b\1\2el\5\b\5\2fl\5\2\2\2gh\7\30\2\2hi\5\16\b\2ij\7\31\2\2jl\3\2\2\2"+
		"kd\3\2\2\2kf\3\2\2\2kg\3\2\2\2lr\3\2\2\2mn\f\4\2\2no\7\7\2\2oq\5\16\b"+
		"\5pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tr\3\2\2\2uv\7)"+
		"\2\2vz\5\2\2\2wy\5\n\6\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2"+
		"\2\2|z\3\2\2\2}~\7\17\2\2~\177\5\f\7\2\177\21\3\2\2\2\u0080\u0081\7*\2"+
		"\2\u0081\u0085\5\2\2\2\u0082\u0084\5\n\6\2\u0083\u0082\3\2\2\2\u0084\u0087"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0088\u0089\7\17\2\2\u0089\u008a\5\f\7\2\u008a\23\3\2\2"+
		"\2\u008b\u008c\7+\2\2\u008c\u0090\5\2\2\2\u008d\u008f\5\n\6\2\u008e\u008d"+
		"\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\17\2\2\u0094\u0095\5"+
		"\16\b\2\u0095\25\3\2\2\2\u0096\u0097\t\b\2\2\u0097\u0098\5\2\2\2\u0098"+
		"\u0099\7\34\2\2\u0099\u009a\7.\2\2\u009a\u009b\7\35\2\2\u009b\27\3\2\2"+
		"\2\u009c\u00a1\5\20\t\2\u009d\u00a1\5\22\n\2\u009e\u00a1\5\24\13\2\u009f"+
		"\u00a1\5\26\f\2\u00a0\u009c\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u009e\3"+
		"\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\25\2\2\u00a3"+
		"\31\3\2\2\2\u00a4\u00a9\7,\2\2\u00a5\u00aa\5\20\t\2\u00a6\u00aa\5\22\n"+
		"\2\u00a7\u00aa\5\24\13\2\u00a8\u00aa\5\26\f\2\u00a9\u00a5\3\2\2\2\u00a9"+
		"\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\7\25\2\2\u00ac\33\3\2\2\2\u00ad\u00b0\5\30\r\2\u00ae"+
		"\u00b0\5\32\16\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\35\3\2"+
		"\2\2\u00b1\u00b2\5\2\2\2\u00b2\u00b5\7\17\2\2\u00b3\u00b6\5\f\7\2\u00b4"+
		"\u00b6\5\16\b\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3"+
		"\2\2\2\u00b7\u00b8\7\25\2\2\u00b8\37\3\2\2\2\u00b9\u00ba\5\2\2\2\u00ba"+
		"\u00bb\7\34\2\2\u00bb\u00bc\7.\2\2\u00bc\u00bd\7\35\2\2\u00bd\u00be\7"+
		"\17\2\2\u00be\u00bf\5\f\7\2\u00bf\u00c0\7\25\2\2\u00c0!\3\2\2\2\u00c1"+
		"\u00c2\5\2\2\2\u00c2\u00c3\7\17\2\2\u00c3\u00c4\7\30\2\2\u00c4\u00c5\5"+
		"\f\7\2\u00c5\u00c6\7\31\2\2\u00c6\u00c9\7\21\2\2\u00c7\u00ca\5\f\7\2\u00c8"+
		"\u00ca\5\16\b\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3"+
		"\2\2\2\u00cb\u00ce\7\24\2\2\u00cc\u00cf\5\f\7\2\u00cd\u00cf\5\16\b\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\25"+
		"\2\2\u00d1#\3\2\2\2\u00d2\u00d3\t\t\2\2\u00d3\u00d4\5\"\22\2\u00d4%\3"+
		"\2\2\2\u00d5\u00d6\5\2\2\2\u00d6\u00e5\7\30\2\2\u00d7\u00da\5\f\7\2\u00d8"+
		"\u00da\5\16\b\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00e2\3"+
		"\2\2\2\u00db\u00de\7\36\2\2\u00dc\u00df\5\f\7\2\u00dd\u00df\5\16\b\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00d9\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7\31\2\2\u00e8\'\3\2\2\2\u00e9\u0129"+
		"\5\34\17\2\u00ea\u0129\5\36\20\2\u00eb\u0129\5 \21\2\u00ec\u0129\5\"\22"+
		"\2\u00ed\u0129\5$\23\2\u00ee\u00ef\5&\24\2\u00ef\u00f0\7\25\2\2\u00f0"+
		"\u0129\3\2\2\2\u00f1\u00f2\7 \2\2\u00f2\u00f3\7\30\2\2\u00f3\u00f4\5\f"+
		"\7\2\u00f4\u00f5\7\31\2\2\u00f5\u00f8\5*\26\2\u00f6\u00f7\7!\2\2\u00f7"+
		"\u00f9\5*\26\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0129\3\2"+
		"\2\2\u00fa\u00fb\7\"\2\2\u00fb\u00fc\7\30\2\2\u00fc\u00fd\5\f\7\2\u00fd"+
		"\u00fe\7\31\2\2\u00fe\u00ff\5*\26\2\u00ff\u0129\3\2\2\2\u0100\u0101\7"+
		"#\2\2\u0101\u0102\7\30\2\2\u0102\u0103\5\2\2\2\u0103\u0105\7\17\2\2\u0104"+
		"\u0106\5\6\4\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0108\5\f\7\2\u0108\u010a\7(\2\2\u0109\u010b\5\6\4\2\u010a"+
		"\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\5\f"+
		"\7\2\u010d\u010e\7\31\2\2\u010e\u010f\5*\26\2\u010f\u0129\3\2\2\2\u0110"+
		"\u0111\7$\2\2\u0111\u0112\7\30\2\2\u0112\u0113\5\2\2\2\u0113\u0114\7\24"+
		"\2\2\u0114\u0115\5\2\2\2\u0115\u0116\7\31\2\2\u0116\u0117\5*\26\2\u0117"+
		"\u0129\3\2\2\2\u0118\u0119\7%\2\2\u0119\u011a\5*\26\2\u011a\u011b\7&\2"+
		"\2\u011b\u011c\7\30\2\2\u011c\u011d\5\f\7\2\u011d\u011e\7\31\2\2\u011e"+
		"\u011f\7\25\2\2\u011f\u0129\3\2\2\2\u0120\u0121\7\'\2\2\u0121\u0122\5"+
		"*\26\2\u0122\u0123\7\"\2\2\u0123\u0124\7\30\2\2\u0124\u0125\5\f\7\2\u0125"+
		"\u0126\7\31\2\2\u0126\u0127\7\25\2\2\u0127\u0129\3\2\2\2\u0128\u00e9\3"+
		"\2\2\2\u0128\u00ea\3\2\2\2\u0128\u00eb\3\2\2\2\u0128\u00ec\3\2\2\2\u0128"+
		"\u00ed\3\2\2\2\u0128\u00ee\3\2\2\2\u0128\u00f1\3\2\2\2\u0128\u00fa\3\2"+
		"\2\2\u0128\u0100\3\2\2\2\u0128\u0110\3\2\2\2\u0128\u0118\3\2\2\2\u0128"+
		"\u0120\3\2\2\2\u0129)\3\2\2\2\u012a\u0130\7\32\2\2\u012b\u012d\5(\25\2"+
		"\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012c\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\7\33\2\2\u0133+\3\2\2\2\u0134\u0135\7-\2\2"+
		"\u0135\u0136\5\2\2\2\u0136\u0149\7\30\2\2\u0137\u0138\t\b\2\2\u0138\u013c"+
		"\5\f\7\2\u0139\u013a\7+\2\2\u013a\u013c\5\16\b\2\u013b\u0137\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u0146\3\2\2\2\u013d\u0142\7\36\2\2\u013e\u013f\t"+
		"\b\2\2\u013f\u0143\5\f\7\2\u0140\u0141\7+\2\2\u0141\u0143\5\16\b\2\u0142"+
		"\u013e\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u013d\3\2"+
		"\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u013b\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\31\2\2\u014c\u014d\5*\26\2\u014d"+
		"-\3\2\2\2\u014e\u0151\5(\25\2\u014f\u0151\5,\27\2\u0150\u014e\3\2\2\2"+
		"\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"/\3\2\2\2\"IQ_akrz\u0085\u0090\u00a0\u00a9\u00af\u00b5\u00c9\u00ce\u00d9"+
		"\u00de\u00e2\u00e5\u00f8\u0105\u010a\u0128\u012e\u0130\u013b\u0142\u0146"+
		"\u0149\u0150\u0152\u0154";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}