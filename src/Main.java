import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.VarAssVisitor;


public class Main {
    static String testStr = "newValue = (i == 4) ? 10 : 20; int d = 4; bool test[3]; const string s = \"ahoj\"; cislo = porno; const string new = \"here\";\n" +
            "\n" +
            "for(i = 0 to 5){\n" +
            "int i = 4;\n" +
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
