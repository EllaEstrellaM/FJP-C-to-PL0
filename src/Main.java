import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import statementInterEnum.Istatement;
import visitors.VarAssVisitor;

import java.util.ArrayList;


public class Main {
    static String testStr = "if(i == 4){c = 5; d = 4;} newValue = (i == 4) ? 10 : 20; int d = 4; bool test[3]; const string s = \"ahoj\"; cislo = porno;";

    public static void main(String[] args){
        //System.out.println("jajajja");


        ourCLexer lexer = new ourCLexer(CharStreams.fromString(testStr));
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();
        System.out.println("Got number of statements: " + encounteredStatements.size());

//        String name = parser.start().children.get(0).getText();
//
//        System.out.println(name);
    }
}
