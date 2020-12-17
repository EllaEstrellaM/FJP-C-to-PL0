package generated;// Generated from C:/Users/elisk/Documents/kiv-FJP\ourC.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ourCLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_MULTIPLICATION", "OP_MINUS", "OP_PLUS", "OP_DIVISION", "COMP_IDENT", 
			"COMP_NOT_IDENT", "COMP_GRTH", "COMP_GRTH_EQ", "COMP_LW", "COMP_LW_EQ", 
			"ASSIGN", "NEGATION", "QUES_MARK", "OPER_AND", "OPER_OR", "COLON", "SEMI_COLON", 
			"BOOL_TRUE", "BOOL_FALSE", "LEFT_BASIC_BRACK", "RIGHT_BASIC_BRACK", "LEFT_CURLY_BRACK", 
			"RIGHT_CURLY_BRACK", "LEFT_NARROW_BRACK", "RIGHT_NARROW_BRACK", "COMMA", 
			"END_OF_COM", "CON_IF", "CON_ELSE", "CYC_WHILE", "CYC_FOR", "CYC_FOREACH", 
			"CYC_REPEAT", "CYC_UNTIL", "CYC_DO", "TO", "BOOL", "INT", "STRING", "CONST", 
			"PROC_DEF", "DEC_NUM", "IDENT", "STRING_DEC", "COMMENT_START", "BLANK_SPACE"
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


	public ourCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ourC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0119\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\6+\u00f2\n"+
		"+\r+\16+\u00f3\3,\3,\7,\u00f8\n,\f,\16,\u00fb\13,\3-\3-\3-\3-\7-\u0101"+
		"\n-\f-\16-\u0104\13-\3-\3-\3.\3.\3.\3.\7.\u010c\n.\f.\16.\u010f\13.\3"+
		".\3.\3/\6/\u0114\n/\r/\16/\u0115\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60\3\2\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\n\2$$))^^ddhhpp"+
		"ttvv\6\2\f\f\17\17$$^^\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u011e\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2"+
		"\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\rj\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2"+
		"\23r\3\2\2\2\25t\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2"+
		"\2\37\u0081\3\2\2\2!\u0084\3\2\2\2#\u0086\3\2\2\2%\u0088\3\2\2\2\'\u008d"+
		"\3\2\2\2)\u0093\3\2\2\2+\u0095\3\2\2\2-\u0097\3\2\2\2/\u0099\3\2\2\2\61"+
		"\u009b\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2\2\2\67\u00a1\3\2\2\29\u00a3"+
		"\3\2\2\2;\u00a6\3\2\2\2=\u00ab\3\2\2\2?\u00b1\3\2\2\2A\u00b5\3\2\2\2C"+
		"\u00bd\3\2\2\2E\u00c4\3\2\2\2G\u00ca\3\2\2\2I\u00cd\3\2\2\2K\u00d0\3\2"+
		"\2\2M\u00d5\3\2\2\2O\u00d9\3\2\2\2Q\u00e0\3\2\2\2S\u00e6\3\2\2\2U\u00f1"+
		"\3\2\2\2W\u00f5\3\2\2\2Y\u00fc\3\2\2\2[\u0107\3\2\2\2]\u0113\3\2\2\2_"+
		"`\7,\2\2`\4\3\2\2\2ab\7/\2\2b\6\3\2\2\2cd\7-\2\2d\b\3\2\2\2ef\7\61\2\2"+
		"f\n\3\2\2\2gh\7?\2\2hi\7?\2\2i\f\3\2\2\2jk\7#\2\2kl\7?\2\2l\16\3\2\2\2"+
		"mn\7@\2\2n\20\3\2\2\2op\7@\2\2pq\7?\2\2q\22\3\2\2\2rs\7>\2\2s\24\3\2\2"+
		"\2tu\7>\2\2uv\7?\2\2v\26\3\2\2\2wx\7?\2\2x\30\3\2\2\2yz\7#\2\2z\32\3\2"+
		"\2\2{|\7A\2\2|\34\3\2\2\2}~\7c\2\2~\177\7p\2\2\177\u0080\7f\2\2\u0080"+
		"\36\3\2\2\2\u0081\u0082\7q\2\2\u0082\u0083\7t\2\2\u0083 \3\2\2\2\u0084"+
		"\u0085\7<\2\2\u0085\"\3\2\2\2\u0086\u0087\7=\2\2\u0087$\3\2\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7t\2\2\u008a\u008b\7w\2\2\u008b\u008c\7g\2\2"+
		"\u008c&\3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f\7c\2\2\u008f\u0090\7n\2"+
		"\2\u0090\u0091\7u\2\2\u0091\u0092\7g\2\2\u0092(\3\2\2\2\u0093\u0094\7"+
		"*\2\2\u0094*\3\2\2\2\u0095\u0096\7+\2\2\u0096,\3\2\2\2\u0097\u0098\7}"+
		"\2\2\u0098.\3\2\2\2\u0099\u009a\7\177\2\2\u009a\60\3\2\2\2\u009b\u009c"+
		"\7]\2\2\u009c\62\3\2\2\2\u009d\u009e\7_\2\2\u009e\64\3\2\2\2\u009f\u00a0"+
		"\7.\2\2\u00a0\66\3\2\2\2\u00a1\u00a2\7\f\2\2\u00a28\3\2\2\2\u00a3\u00a4"+
		"\7k\2\2\u00a4\u00a5\7h\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8"+
		"\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa<\3\2\2\2\u00ab\u00ac"+
		"\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0>\3\2\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7q\2\2\u00b3"+
		"\u00b4\7t\2\2\u00b4@\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7q\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7e\2\2"+
		"\u00bb\u00bc\7j\2\2\u00bcB\3\2\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7g\2"+
		"\2\u00bf\u00c0\7r\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3"+
		"\7v\2\2\u00c3D\3\2\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7"+
		"\7v\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7n\2\2\u00c9F\3\2\2\2\u00ca\u00cb"+
		"\7f\2\2\u00cb\u00cc\7q\2\2\u00ccH\3\2\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf"+
		"\7q\2\2\u00cfJ\3\2\2\2\u00d0\u00d1\7d\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3"+
		"\7q\2\2\u00d3\u00d4\7n\2\2\u00d4L\3\2\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7"+
		"\7p\2\2\u00d7\u00d8\7v\2\2\u00d8N\3\2\2\2\u00d9\u00da\7u\2\2\u00da\u00db"+
		"\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de"+
		"\u00df\7i\2\2\u00dfP\3\2\2\2\u00e0\u00e1\7e\2\2\u00e1\u00e2\7q\2\2\u00e2"+
		"\u00e3\7p\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7v\2\2\u00e5R\3\2\2\2\u00e6"+
		"\u00e7\7r\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7e\2\2"+
		"\u00ea\u00eb\7g\2\2\u00eb\u00ec\7f\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee"+
		"\7t\2\2\u00ee\u00ef\7g\2\2\u00efT\3\2\2\2\u00f0\u00f2\t\2\2\2\u00f1\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"V\3\2\2\2\u00f5\u00f9\t\3\2\2\u00f6\u00f8\t\4\2\2\u00f7\u00f6\3\2\2\2"+
		"\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faX\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u0102\7$\2\2\u00fd\u00fe\7^\2\2\u00fe"+
		"\u0101\t\5\2\2\u00ff\u0101\n\6\2\2\u0100\u00fd\3\2\2\2\u0100\u00ff\3\2"+
		"\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7$\2\2\u0106Z\3\2\2\2\u0107"+
		"\u0108\7\61\2\2\u0108\u0109\7\61\2\2\u0109\u010d\3\2\2\2\u010a\u010c\n"+
		"\7\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\b."+
		"\2\2\u0111\\\3\2\2\2\u0112\u0114\t\b\2\2\u0113\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\b/\2\2\u0118^\3\2\2\2\t\2\u00f3\u00f9\u0100\u0102\u010d\u0115\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}