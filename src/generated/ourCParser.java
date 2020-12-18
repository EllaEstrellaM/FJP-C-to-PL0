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
		RULE_sign_whole_num = 4, RULE_multi_assign = 5, RULE_expr_dec_bool = 6, 
		RULE_expr_string = 7, RULE_bool_var_dec = 8, RULE_decimal_var_dec = 9, 
		RULE_string_var_dec = 10, RULE_array_var_dec = 11, RULE_var_non_const_dec_command = 12, 
		RULE_var_const_dec_command = 13, RULE_var_declaration = 14, RULE_var_assignment = 15, 
		RULE_arr_assignment = 16, RULE_ternar_assignment = 17, RULE_call_proc = 18, 
		RULE_code_block = 19, RULE_block_body = 20, RULE_def_proc = 21, RULE_start = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier_var", "bool_val", "dec_val", "string_val", "sign_whole_num", 
			"multi_assign", "expr_dec_bool", "expr_string", "bool_var_dec", "decimal_var_dec", 
			"string_var_dec", "array_var_dec", "var_non_const_dec_command", "var_const_dec_command", 
			"var_declaration", "var_assignment", "arr_assignment", "ternar_assignment", 
			"call_proc", "code_block", "block_body", "def_proc", "start"
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_MINUS || _la==OP_PLUS) {
				{
				setState(50);
				sign_whole_num();
				}
			}

			setState(53);
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
			setState(55);
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
			setState(57);
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
			setState(59);
			match(ASSIGN);
			setState(60);
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(63);
				dec_val();
				}
				break;
			case 2:
				{
				setState(64);
				bool_val();
				}
				break;
			case 3:
				{
				setState(65);
				identifier_var();
				}
				break;
			case 4:
				{
				setState(66);
				identifier_var();
				setState(67);
				match(LEFT_NARROW_BRACK);
				setState(68);
				match(DEC_NUM);
				setState(69);
				match(RIGHT_NARROW_BRACK);
				}
				break;
			case 5:
				{
				setState(71);
				expr_string(0);
				setState(72);
				_la = _input.LA(1);
				if ( !(_la==COMP_IDENT || _la==COMP_NOT_IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(73);
				expr_string(0);
				setState(76);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(74);
					_la = _input.LA(1);
					if ( !(_la==OPER_AND || _la==OPER_OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(75);
					expr_dec_bool(0);
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(78);
				match(LEFT_BASIC_BRACK);
				setState(79);
				expr_dec_bool(0);
				setState(80);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			case 7:
				{
				setState(82);
				match(NEGATION);
				setState(83);
				expr_dec_bool(3);
				}
				break;
			case 8:
				{
				setState(84);
				match(OP_PLUS);
				setState(85);
				expr_dec_bool(2);
				}
				break;
			case 9:
				{
				setState(86);
				match(OP_MINUS);
				setState(87);
				expr_dec_bool(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(90);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(91);
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
						setState(92);
						expr_dec_bool(10);
						}
						break;
					case 2:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(93);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(94);
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
						setState(95);
						expr_dec_bool(9);
						}
						break;
					case 3:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(96);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(97);
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
						setState(98);
						expr_dec_bool(8);
						}
						break;
					case 4:
						{
						_localctx = new Expr_dec_boolContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_dec_bool);
						setState(99);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(100);
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
						setState(101);
						expr_dec_bool(7);
						}
						break;
					}
					} 
				}
				setState(106);
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
		public Expr_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_string; }
	 
		public Expr_stringContext() { }
		public void copyFrom(Expr_stringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStringHashContext extends Expr_stringContext {
		public List<Expr_stringContext> expr_string() {
			return getRuleContexts(Expr_stringContext.class);
		}
		public Expr_stringContext expr_string(int i) {
			return getRuleContext(Expr_stringContext.class,i);
		}
		public TerminalNode OP_PLUS() { return getToken(ourCParser.OP_PLUS, 0); }
		public ExprStringHashContext(Expr_stringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterExprStringHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitExprStringHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitExprStringHash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketsHashContext extends Expr_stringContext {
		public TerminalNode LEFT_BASIC_BRACK() { return getToken(ourCParser.LEFT_BASIC_BRACK, 0); }
		public Expr_stringContext expr_string() {
			return getRuleContext(Expr_stringContext.class,0);
		}
		public TerminalNode RIGHT_BASIC_BRACK() { return getToken(ourCParser.RIGHT_BASIC_BRACK, 0); }
		public BracketsHashContext(Expr_stringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterBracketsHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitBracketsHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitBracketsHash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierVarHashContext extends Expr_stringContext {
		public Identifier_varContext identifier_var() {
			return getRuleContext(Identifier_varContext.class,0);
		}
		public IdentifierVarHashContext(Expr_stringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterIdentifierVarHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitIdentifierVarHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitIdentifierVarHash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValHashContext extends Expr_stringContext {
		public String_valContext string_val() {
			return getRuleContext(String_valContext.class,0);
		}
		public StringValHashContext(Expr_stringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).enterStringValHash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ourCListener ) ((ourCListener)listener).exitStringValHash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ourCVisitor ) return ((ourCVisitor<? extends T>)visitor).visitStringValHash(this);
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
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_DEC:
				{
				_localctx = new StringValHashContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				string_val();
				}
				break;
			case IDENT:
				{
				_localctx = new IdentifierVarHashContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				identifier_var();
				}
				break;
			case LEFT_BASIC_BRACK:
				{
				_localctx = new BracketsHashContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(LEFT_BASIC_BRACK);
				setState(111);
				expr_string(0);
				setState(112);
				match(RIGHT_BASIC_BRACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprStringHashContext(new Expr_stringContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr_string);
					setState(116);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(117);
					match(OP_PLUS);
					setState(118);
					expr_string(3);
					}
					} 
				}
				setState(123);
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
			setState(124);
			match(BOOL);
			setState(125);
			identifier_var();
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					multi_assign();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(132);
			match(ASSIGN);
			setState(133);
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
			setState(135);
			match(INT);
			setState(136);
			identifier_var();
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					multi_assign();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(143);
			match(ASSIGN);
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(144);
				sign_whole_num();
				}
				break;
			}
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
			setState(149);
			match(STRING);
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
			setState(158);
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
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(161);
			identifier_var();
			setState(162);
			match(LEFT_NARROW_BRACK);
			setState(163);
			match(DEC_NUM);
			setState(164);
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
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(166);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(167);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(168);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(169);
				array_var_dec();
				}
				break;
			}
			setState(172);
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
			setState(174);
			match(CONST);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(175);
				bool_var_dec();
				}
				break;
			case 2:
				{
				setState(176);
				decimal_var_dec();
				}
				break;
			case 3:
				{
				setState(177);
				string_var_dec();
				}
				break;
			case 4:
				{
				setState(178);
				array_var_dec();
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
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
				{
				setState(183);
				var_non_const_dec_command();
				}
				break;
			case CONST:
				{
				setState(184);
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
			setState(187);
			identifier_var();
			setState(188);
			match(ASSIGN);
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(189);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(190);
				expr_string(0);
				}
				break;
			}
			setState(193);
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
			setState(195);
			identifier_var();
			setState(196);
			match(LEFT_NARROW_BRACK);
			setState(197);
			match(DEC_NUM);
			setState(198);
			match(RIGHT_NARROW_BRACK);
			setState(199);
			match(ASSIGN);
			{
			setState(200);
			expr_dec_bool(0);
			}
			setState(201);
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
			setState(203);
			identifier_var();
			setState(204);
			match(ASSIGN);
			setState(205);
			match(LEFT_BASIC_BRACK);
			setState(206);
			expr_dec_bool(0);
			setState(207);
			match(RIGHT_BASIC_BRACK);
			setState(208);
			match(QUES_MARK);
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(209);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(210);
				expr_string(0);
				}
				break;
			}
			setState(213);
			match(COLON);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(214);
				expr_dec_bool(0);
				}
				break;
			case 2:
				{
				setState(215);
				expr_string(0);
				}
				break;
			}
			setState(218);
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
		enterRule(_localctx, 36, RULE_call_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			identifier_var();
			setState(221);
			match(LEFT_BASIC_BRACK);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MINUS) | (1L << OP_PLUS) | (1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(222);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(223);
					expr_string(0);
					}
					break;
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(226);
					match(COMMA);
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
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
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(238);
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
		enterRule(_localctx, 38, RULE_code_block);
		int _la;
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				var_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				var_assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				arr_assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				ternar_assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				call_proc();
				setState(245);
				match(SEMI_COLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				match(CON_IF);
				setState(248);
				match(LEFT_BASIC_BRACK);
				setState(249);
				expr_dec_bool(0);
				setState(250);
				match(RIGHT_BASIC_BRACK);
				setState(251);
				block_body();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CON_ELSE) {
					{
					setState(252);
					match(CON_ELSE);
					setState(253);
					block_body();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(256);
				match(CYC_WHILE);
				setState(257);
				match(LEFT_BASIC_BRACK);
				setState(258);
				expr_dec_bool(0);
				setState(259);
				match(RIGHT_BASIC_BRACK);
				setState(260);
				block_body();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(262);
				match(CYC_FOR);
				setState(263);
				match(LEFT_BASIC_BRACK);
				setState(264);
				identifier_var();
				setState(265);
				match(ASSIGN);
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(266);
					dec_val();
					}
					break;
				}
				setState(269);
				expr_dec_bool(0);
				setState(270);
				match(TO);
				setState(272);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(271);
					dec_val();
					}
					break;
				}
				setState(274);
				expr_dec_bool(0);
				setState(275);
				match(RIGHT_BASIC_BRACK);
				setState(276);
				block_body();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(278);
				match(CYC_FOREACH);
				setState(279);
				match(LEFT_BASIC_BRACK);
				setState(280);
				identifier_var();
				setState(281);
				match(COLON);
				setState(282);
				identifier_var();
				setState(283);
				match(RIGHT_BASIC_BRACK);
				setState(284);
				block_body();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(286);
				match(CYC_REPEAT);
				setState(287);
				block_body();
				setState(288);
				match(CYC_UNTIL);
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
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(294);
				match(CYC_DO);
				setState(295);
				block_body();
				setState(296);
				match(CYC_WHILE);
				setState(297);
				match(LEFT_BASIC_BRACK);
				setState(298);
				expr_dec_bool(0);
				setState(299);
				match(RIGHT_BASIC_BRACK);
				setState(300);
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
			setState(304);
			match(LEFT_CURLY_BRACK);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0)) {
				{
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(305);
					code_block();
					}
					}
					setState(308); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << IDENT))) != 0) );
				}
			}

			setState(312);
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
		enterRule(_localctx, 42, RULE_def_proc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(PROC_DEF);
			setState(315);
			identifier_var();
			setState(316);
			match(LEFT_BASIC_BRACK);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MINUS) | (1L << OP_PLUS) | (1L << NEGATION) | (1L << BOOL_TRUE) | (1L << BOOL_FALSE) | (1L << LEFT_BASIC_BRACK) | (1L << DEC_NUM) | (1L << IDENT) | (1L << STRING_DEC))) != 0)) {
				{
				setState(319);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(317);
					expr_dec_bool(0);
					}
					break;
				case 2:
					{
					setState(318);
					expr_string(0);
					}
					break;
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(321);
					match(COMMA);
					setState(324);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(322);
						expr_dec_bool(0);
						}
						break;
					case 2:
						{
						setState(323);
						expr_string(0);
						}
						break;
					}
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(333);
			match(RIGHT_BASIC_BRACK);
			setState(334);
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
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CON_IF) | (1L << CYC_WHILE) | (1L << CYC_FOR) | (1L << CYC_FOREACH) | (1L << CYC_REPEAT) | (1L << CYC_DO) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CONST) | (1L << PROC_DEF) | (1L << IDENT))) != 0)) {
				{
				setState(338); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(338);
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
						setState(336);
						code_block();
						}
						break;
					case PROC_DEF:
						{
						setState(337);
						def_proc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(340); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u015b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\3\3\3\4\5\4\66\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b[\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tu"+
		"\n\t\3\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\n\3\n\3\n\7\n\u0082\n\n\f\n"+
		"\16\n\u0085\13\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u008d\n\13\f\13\16\13"+
		"\u0090\13\13\3\13\3\13\5\13\u0094\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u009b"+
		"\n\f\f\f\16\f\u009e\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\5\16\u00ad\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00b6"+
		"\n\17\3\17\3\17\3\20\3\20\5\20\u00bc\n\20\3\21\3\21\3\21\3\21\5\21\u00c2"+
		"\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00d6\n\23\3\23\3\23\3\23\5\23\u00db\n"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00e3\n\24\3\24\3\24\3\24\5\24"+
		"\u00e8\n\24\7\24\u00ea\n\24\f\24\16\24\u00ed\13\24\5\24\u00ef\n\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0101\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u010e\n\25\3\25\3\25\3\25\5\25\u0113\n\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0131\n\25"+
		"\3\26\3\26\6\26\u0135\n\26\r\26\16\26\u0136\5\26\u0139\n\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u0142\n\27\3\27\3\27\3\27\5\27\u0147\n"+
		"\27\7\27\u0149\n\27\f\27\16\27\u014c\13\27\5\27\u014e\n\27\3\27\3\27\3"+
		"\27\3\30\3\30\6\30\u0155\n\30\r\30\16\30\u0156\5\30\u0159\n\30\3\30\2"+
		"\4\16\20\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\t\3\2\26"+
		"\27\3\2\6\7\3\2\t\n\3\2\22\23\4\2\5\5\b\b\3\2\t\16\3\2)*\2\u017c\2\60"+
		"\3\2\2\2\4\62\3\2\2\2\6\65\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\f=\3\2\2\2\16"+
		"Z\3\2\2\2\20t\3\2\2\2\22~\3\2\2\2\24\u0089\3\2\2\2\26\u0097\3\2\2\2\30"+
		"\u00a2\3\2\2\2\32\u00ac\3\2\2\2\34\u00b0\3\2\2\2\36\u00bb\3\2\2\2 \u00bd"+
		"\3\2\2\2\"\u00c5\3\2\2\2$\u00cd\3\2\2\2&\u00de\3\2\2\2(\u0130\3\2\2\2"+
		"*\u0132\3\2\2\2,\u013c\3\2\2\2.\u0158\3\2\2\2\60\61\7/\2\2\61\3\3\2\2"+
		"\2\62\63\t\2\2\2\63\5\3\2\2\2\64\66\5\n\6\2\65\64\3\2\2\2\65\66\3\2\2"+
		"\2\66\67\3\2\2\2\678\7.\2\28\7\3\2\2\29:\7\60\2\2:\t\3\2\2\2;<\t\3\2\2"+
		"<\13\3\2\2\2=>\7\17\2\2>?\5\2\2\2?\r\3\2\2\2@A\b\b\1\2A[\5\6\4\2B[\5\4"+
		"\3\2C[\5\2\2\2DE\5\2\2\2EF\7\34\2\2FG\7.\2\2GH\7\35\2\2H[\3\2\2\2IJ\5"+
		"\20\t\2JK\t\4\2\2KN\5\20\t\2LM\t\5\2\2MO\5\16\b\2NL\3\2\2\2NO\3\2\2\2"+
		"O[\3\2\2\2PQ\7\30\2\2QR\5\16\b\2RS\7\31\2\2S[\3\2\2\2TU\7\20\2\2U[\5\16"+
		"\b\5VW\7\7\2\2W[\5\16\b\4XY\7\6\2\2Y[\5\16\b\3Z@\3\2\2\2ZB\3\2\2\2ZC\3"+
		"\2\2\2ZD\3\2\2\2ZI\3\2\2\2ZP\3\2\2\2ZT\3\2\2\2ZV\3\2\2\2ZX\3\2\2\2[j\3"+
		"\2\2\2\\]\f\13\2\2]^\t\6\2\2^i\5\16\b\f_`\f\n\2\2`a\t\3\2\2ai\5\16\b\13"+
		"bc\f\t\2\2cd\t\7\2\2di\5\16\b\nef\f\b\2\2fg\t\5\2\2gi\5\16\b\th\\\3\2"+
		"\2\2h_\3\2\2\2hb\3\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\17\3"+
		"\2\2\2lj\3\2\2\2mn\b\t\1\2nu\5\b\5\2ou\5\2\2\2pq\7\30\2\2qr\5\20\t\2r"+
		"s\7\31\2\2su\3\2\2\2tm\3\2\2\2to\3\2\2\2tp\3\2\2\2u{\3\2\2\2vw\f\4\2\2"+
		"wx\7\7\2\2xz\5\20\t\5yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\21\3\2"+
		"\2\2}{\3\2\2\2~\177\7)\2\2\177\u0083\5\2\2\2\u0080\u0082\5\f\7\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\17\2\2\u0087"+
		"\u0088\5\16\b\2\u0088\23\3\2\2\2\u0089\u008a\7*\2\2\u008a\u008e\5\2\2"+
		"\2\u008b\u008d\5\f\7\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0093\7\17\2\2\u0092\u0094\5\n\6\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\16\b\2\u0096\25\3\2\2\2\u0097"+
		"\u0098\7+\2\2\u0098\u009c\5\2\2\2\u0099\u009b\5\f\7\2\u009a\u0099\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\17\2\2\u00a0\u00a1\5"+
		"\20\t\2\u00a1\27\3\2\2\2\u00a2\u00a3\t\b\2\2\u00a3\u00a4\5\2\2\2\u00a4"+
		"\u00a5\7\34\2\2\u00a5\u00a6\7.\2\2\u00a6\u00a7\7\35\2\2\u00a7\31\3\2\2"+
		"\2\u00a8\u00ad\5\22\n\2\u00a9\u00ad\5\24\13\2\u00aa\u00ad\5\26\f\2\u00ab"+
		"\u00ad\5\30\r\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\25\2\2\u00af"+
		"\33\3\2\2\2\u00b0\u00b5\7,\2\2\u00b1\u00b6\5\22\n\2\u00b2\u00b6\5\24\13"+
		"\2\u00b3\u00b6\5\26\f\2\u00b4\u00b6\5\30\r\2\u00b5\u00b1\3\2\2\2\u00b5"+
		"\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\7\25\2\2\u00b8\35\3\2\2\2\u00b9\u00bc\5\32\16\2\u00ba"+
		"\u00bc\5\34\17\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\37\3\2"+
		"\2\2\u00bd\u00be\5\2\2\2\u00be\u00c1\7\17\2\2\u00bf\u00c2\5\16\b\2\u00c0"+
		"\u00c2\5\20\t\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3"+
		"\2\2\2\u00c3\u00c4\7\25\2\2\u00c4!\3\2\2\2\u00c5\u00c6\5\2\2\2\u00c6\u00c7"+
		"\7\34\2\2\u00c7\u00c8\7.\2\2\u00c8\u00c9\7\35\2\2\u00c9\u00ca\7\17\2\2"+
		"\u00ca\u00cb\5\16\b\2\u00cb\u00cc\7\25\2\2\u00cc#\3\2\2\2\u00cd\u00ce"+
		"\5\2\2\2\u00ce\u00cf\7\17\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00d1\5\16\b"+
		"\2\u00d1\u00d2\7\31\2\2\u00d2\u00d5\7\21\2\2\u00d3\u00d6\5\16\b\2\u00d4"+
		"\u00d6\5\20\t\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3"+
		"\2\2\2\u00d7\u00da\7\24\2\2\u00d8\u00db\5\16\b\2\u00d9\u00db\5\20\t\2"+
		"\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\7\25\2\2\u00dd%\3\2\2\2\u00de\u00df\5\2\2\2\u00df\u00ee\7\30\2\2\u00e0"+
		"\u00e3\5\16\b\2\u00e1\u00e3\5\20\t\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3"+
		"\2\2\2\u00e3\u00eb\3\2\2\2\u00e4\u00e7\7\36\2\2\u00e5\u00e8\5\16\b\2\u00e6"+
		"\u00e8\5\20\t\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00ea\3"+
		"\2\2\2\u00e9\u00e4\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00e2\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\31\2\2\u00f1"+
		"\'\3\2\2\2\u00f2\u0131\5\36\20\2\u00f3\u0131\5 \21\2\u00f4\u0131\5\"\22"+
		"\2\u00f5\u0131\5$\23\2\u00f6\u00f7\5&\24\2\u00f7\u00f8\7\25\2\2\u00f8"+
		"\u0131\3\2\2\2\u00f9\u00fa\7 \2\2\u00fa\u00fb\7\30\2\2\u00fb\u00fc\5\16"+
		"\b\2\u00fc\u00fd\7\31\2\2\u00fd\u0100\5*\26\2\u00fe\u00ff\7!\2\2\u00ff"+
		"\u0101\5*\26\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0131\3\2"+
		"\2\2\u0102\u0103\7\"\2\2\u0103\u0104\7\30\2\2\u0104\u0105\5\16\b\2\u0105"+
		"\u0106\7\31\2\2\u0106\u0107\5*\26\2\u0107\u0131\3\2\2\2\u0108\u0109\7"+
		"#\2\2\u0109\u010a\7\30\2\2\u010a\u010b\5\2\2\2\u010b\u010d\7\17\2\2\u010c"+
		"\u010e\5\6\4\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0110\5\16\b\2\u0110\u0112\7(\2\2\u0111\u0113\5\6\4\2\u0112"+
		"\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\5\16"+
		"\b\2\u0115\u0116\7\31\2\2\u0116\u0117\5*\26\2\u0117\u0131\3\2\2\2\u0118"+
		"\u0119\7$\2\2\u0119\u011a\7\30\2\2\u011a\u011b\5\2\2\2\u011b\u011c\7\24"+
		"\2\2\u011c\u011d\5\2\2\2\u011d\u011e\7\31\2\2\u011e\u011f\5*\26\2\u011f"+
		"\u0131\3\2\2\2\u0120\u0121\7%\2\2\u0121\u0122\5*\26\2\u0122\u0123\7&\2"+
		"\2\u0123\u0124\7\30\2\2\u0124\u0125\5\16\b\2\u0125\u0126\7\31\2\2\u0126"+
		"\u0127\7\25\2\2\u0127\u0131\3\2\2\2\u0128\u0129\7\'\2\2\u0129\u012a\5"+
		"*\26\2\u012a\u012b\7\"\2\2\u012b\u012c\7\30\2\2\u012c\u012d\5\16\b\2\u012d"+
		"\u012e\7\31\2\2\u012e\u012f\7\25\2\2\u012f\u0131\3\2\2\2\u0130\u00f2\3"+
		"\2\2\2\u0130\u00f3\3\2\2\2\u0130\u00f4\3\2\2\2\u0130\u00f5\3\2\2\2\u0130"+
		"\u00f6\3\2\2\2\u0130\u00f9\3\2\2\2\u0130\u0102\3\2\2\2\u0130\u0108\3\2"+
		"\2\2\u0130\u0118\3\2\2\2\u0130\u0120\3\2\2\2\u0130\u0128\3\2\2\2\u0131"+
		")\3\2\2\2\u0132\u0138\7\32\2\2\u0133\u0135\5(\25\2\u0134\u0133\3\2\2\2"+
		"\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u0134\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013b\7\33\2\2\u013b+\3\2\2\2\u013c\u013d\7-\2\2\u013d\u013e\5\2\2\2"+
		"\u013e\u014d\7\30\2\2\u013f\u0142\5\16\b\2\u0140\u0142\5\20\t\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\u014a\3\2\2\2\u0143\u0146\7\36"+
		"\2\2\u0144\u0147\5\16\b\2\u0145\u0147\5\20\t\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0145\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0143\3\2\2\2\u0149\u014c\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014d\u0141\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u0150\7\31\2\2\u0150\u0151\5*\26\2\u0151-\3\2\2\2\u0152\u0155"+
		"\5(\25\2\u0153\u0155\5,\27\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2"+
		"\2\2\u0158\u0154\3\2\2\2\u0158\u0159\3\2\2\2\u0159/\3\2\2\2$\65NZhjt{"+
		"\u0083\u008e\u0093\u009c\u00ac\u00b5\u00bb\u00c1\u00d5\u00da\u00e2\u00e7"+
		"\u00eb\u00ee\u0100\u010d\u0112\u0130\u0136\u0138\u0141\u0146\u014a\u014d"+
		"\u0154\u0156\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}