// Generated from C:/Users/elisk/Documents/FJP-C-to-PL0\ourC.g4 by ANTLR 4.9
package generated;
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
		COMMENT_START=1, BLANK_SPACE=2, OP_MULTIPLICATION=3, OP_MINUS=4, OP_PLUS=5, 
		OP_DIVISION=6, COMP_IDENT=7, COMP_NOT_IDENT=8, COMP_GRTH=9, COMP_GRTH_EQ=10, 
		COMP_LW=11, COMP_LW_EQ=12, ASSIGN=13, NEGATION=14, QUES_MARK=15, OPER_AND=16, 
		OPER_OR=17, COLON=18, SEMI_COLON=19, BOOL_TRUE=20, BOOL_FALSE=21, LEFT_BASIC_BRACK=22, 
		RIGHT_BASIC_BRACK=23, LEFT_CURLY_BRACK=24, RIGHT_CURLY_BRACK=25, LEFT_NARROW_BRACK=26, 
		RIGHT_NARROW_BRACK=27, COMMA=28, END_OF_COM=29, CON_IF=30, CON_ELSE=31, 
		CYC_WHILE=32, CYC_FOR=33, CYC_FOREACH=34, CYC_REPEAT=35, CYC_UNTIL=36, 
		CYC_DO=37, TO=38, BOOL=39, INT=40, STRING=41, CONST=42, PROC_DEF=43, DEC_NUM=44, 
		IDENT=45, STRING_DEC=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT_START", "BLANK_SPACE", "OP_MULTIPLICATION", "OP_MINUS", "OP_PLUS", 
			"OP_DIVISION", "COMP_IDENT", "COMP_NOT_IDENT", "COMP_GRTH", "COMP_GRTH_EQ", 
			"COMP_LW", "COMP_LW_EQ", "ASSIGN", "NEGATION", "QUES_MARK", "OPER_AND", 
			"OPER_OR", "COLON", "SEMI_COLON", "BOOL_TRUE", "BOOL_FALSE", "LEFT_BASIC_BRACK", 
			"RIGHT_BASIC_BRACK", "LEFT_CURLY_BRACK", "RIGHT_CURLY_BRACK", "LEFT_NARROW_BRACK", 
			"RIGHT_NARROW_BRACK", "COMMA", "END_OF_COM", "CON_IF", "CON_ELSE", "CYC_WHILE", 
			"CYC_FOR", "CYC_FOREACH", "CYC_REPEAT", "CYC_UNTIL", "CYC_DO", "TO", 
			"BOOL", "INT", "STRING", "CONST", "PROC_DEF", "DEC_NUM", "IDENT", "STRING_DEC"
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
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3\2"+
		"\3\2\3\3\6\3l\n\3\r\3\16\3m\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&"+
		"\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+"+
		"\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\6-\u0104\n-\r-\16-\u0105"+
		"\3.\3.\7.\u010a\n.\f.\16.\u010d\13.\3/\3/\3/\3/\7/\u0113\n/\f/\16/\u0116"+
		"\13/\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\t\4\2\f\f"+
		"\17\17\5\2\13\f\17\17\"\"\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\n\2$$))^^"+
		"ddhhppttvv\6\2\f\f\17\17$$^^\2\u011e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5k\3\2\2\2\7q\3\2\2\2\ts\3\2\2\2\13u\3"+
		"\2\2\2\rw\3\2\2\2\17y\3\2\2\2\21|\3\2\2\2\23\177\3\2\2\2\25\u0081\3\2"+
		"\2\2\27\u0084\3\2\2\2\31\u0086\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2"+
		"\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0093\3\2\2\2%\u0096\3\2\2\2\'\u0098"+
		"\3\2\2\2)\u009a\3\2\2\2+\u009f\3\2\2\2-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61"+
		"\u00a9\3\2\2\2\63\u00ab\3\2\2\2\65\u00ad\3\2\2\2\67\u00af\3\2\2\29\u00b1"+
		"\3\2\2\2;\u00b3\3\2\2\2=\u00b5\3\2\2\2?\u00b8\3\2\2\2A\u00bd\3\2\2\2C"+
		"\u00c3\3\2\2\2E\u00c7\3\2\2\2G\u00cf\3\2\2\2I\u00d6\3\2\2\2K\u00dc\3\2"+
		"\2\2M\u00df\3\2\2\2O\u00e2\3\2\2\2Q\u00e7\3\2\2\2S\u00eb\3\2\2\2U\u00f2"+
		"\3\2\2\2W\u00f8\3\2\2\2Y\u0103\3\2\2\2[\u0107\3\2\2\2]\u010e\3\2\2\2_"+
		"`\7\61\2\2`a\7\61\2\2ae\3\2\2\2bd\n\2\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\b\2\2\2i\4\3\2\2\2jl\t\3\2\2kj\3\2"+
		"\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\3\2\2p\6\3\2\2\2qr\7"+
		",\2\2r\b\3\2\2\2st\7/\2\2t\n\3\2\2\2uv\7-\2\2v\f\3\2\2\2wx\7\61\2\2x\16"+
		"\3\2\2\2yz\7?\2\2z{\7?\2\2{\20\3\2\2\2|}\7#\2\2}~\7?\2\2~\22\3\2\2\2\177"+
		"\u0080\7@\2\2\u0080\24\3\2\2\2\u0081\u0082\7@\2\2\u0082\u0083\7?\2\2\u0083"+
		"\26\3\2\2\2\u0084\u0085\7>\2\2\u0085\30\3\2\2\2\u0086\u0087\7>\2\2\u0087"+
		"\u0088\7?\2\2\u0088\32\3\2\2\2\u0089\u008a\7?\2\2\u008a\34\3\2\2\2\u008b"+
		"\u008c\7#\2\2\u008c\36\3\2\2\2\u008d\u008e\7A\2\2\u008e \3\2\2\2\u008f"+
		"\u0090\7c\2\2\u0090\u0091\7p\2\2\u0091\u0092\7f\2\2\u0092\"\3\2\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7t\2\2\u0095$\3\2\2\2\u0096\u0097\7<\2\2\u0097"+
		"&\3\2\2\2\u0098\u0099\7=\2\2\u0099(\3\2\2\2\u009a\u009b\7v\2\2\u009b\u009c"+
		"\7t\2\2\u009c\u009d\7w\2\2\u009d\u009e\7g\2\2\u009e*\3\2\2\2\u009f\u00a0"+
		"\7h\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6.\3\2\2\2\u00a7\u00a8"+
		"\7+\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\7}\2\2\u00aa\62\3\2\2\2\u00ab\u00ac"+
		"\7\177\2\2\u00ac\64\3\2\2\2\u00ad\u00ae\7]\2\2\u00ae\66\3\2\2\2\u00af"+
		"\u00b0\7_\2\2\u00b08\3\2\2\2\u00b1\u00b2\7.\2\2\u00b2:\3\2\2\2\u00b3\u00b4"+
		"\7\f\2\2\u00b4<\3\2\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7h\2\2\u00b7>\3"+
		"\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc@\3\2\2\2\u00bd\u00be\7y\2\2\u00be\u00bf\7j\2\2\u00bf"+
		"\u00c0\7k\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7g\2\2\u00c2B\3\2\2\2\u00c3"+
		"\u00c4\7h\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7t\2\2\u00c6D\3\2\2\2\u00c7"+
		"\u00c8\7h\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2"+
		"\u00cb\u00cc\7c\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7j\2\2\u00ceF\3\2\2"+
		"\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7r\2\2\u00d2\u00d3"+
		"\7g\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7v\2\2\u00d5H\3\2\2\2\u00d6\u00d7"+
		"\7w\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7k\2\2\u00da"+
		"\u00db\7n\2\2\u00dbJ\3\2\2\2\u00dc\u00dd\7f\2\2\u00dd\u00de\7q\2\2\u00de"+
		"L\3\2\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7q\2\2\u00e1N\3\2\2\2\u00e2\u00e3"+
		"\7d\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7n\2\2\u00e6"+
		"P\3\2\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7v\2\2\u00ea"+
		"R\3\2\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7t\2\2\u00ee"+
		"\u00ef\7k\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7i\2\2\u00f1T\3\2\2\2\u00f2"+
		"\u00f3\7e\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6\7u\2\2"+
		"\u00f6\u00f7\7v\2\2\u00f7V\3\2\2\2\u00f8\u00f9\7r\2\2\u00f9\u00fa\7t\2"+
		"\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7e\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe"+
		"\7f\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7g\2\2\u0101"+
		"X\3\2\2\2\u0102\u0104\t\4\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106Z\3\2\2\2\u0107\u010b\t"+
		"\5\2\2\u0108\u010a\t\6\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\\\3\2\2\2\u010d\u010b\3\2\2\2"+
		"\u010e\u0114\7$\2\2\u010f\u0110\7^\2\2\u0110\u0113\t\7\2\2\u0111\u0113"+
		"\n\b\2\2\u0112\u010f\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0117\u0118\7$\2\2\u0118^\3\2\2\2\t\2em\u0105\u010b\u0112\u0114\3"+
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