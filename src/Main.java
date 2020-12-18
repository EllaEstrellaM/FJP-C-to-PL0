import compiler.Compiler;
import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.VarAssVisitor;


public class Main {

    static String testStr =
            "const int ahoj = 0;\n" +
            "int haha = 2;\n" +
            "\n" +
            "if(a < 10){\n" +
            "    ahoj = 5;\n" +
            "}\n" +
            "else{\n" +
            "    ahoj = 1;\n" +
            "}";

    public static void main(String[] args){

        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr));
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
//        VarAssVisitor ass = new VarAssVisitor();
//        ass.visit(tree);


        Compiler compiler = new Compiler(tree);
        compiler.compile();


    }
}
