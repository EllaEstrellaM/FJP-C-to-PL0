import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.VarAssVisitor;


public class Main {

    static String testStr = "int ahoj = 10;\n" +
            "\n" +
            "for(i = 0 to 5){\n" +
            "\n" +
            "}";

    public static void main(String[] args){
        //System.out.println("jajajja");


        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr));
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        VarAssVisitor ass = new VarAssVisitor();
        ass.visit(tree);



//        String name = parser.start().children.get(0).getText();
//
//        System.out.println(name);
    }
}
