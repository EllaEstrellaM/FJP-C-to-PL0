import compiler.Compiler;
import compiler.Instruction;
import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import statementDefMultiLine.*;
import statementDefOneLine.*;
import statementInterEnum.*;
import visitors.VarAssVisitor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;


public class Main {
    static String testStr = "const bool pole[29]; bool s = (c < 25) ? true : false; string g = (c < 25) ? \"truuu\" : \"faaals\"; g = (c < 25) ? \"asstrue\" : \"assfalse\"; string testStr = existing;callProc(iAmArgs); int i = exVal; const string ahoj = existuje; int pokus[20]; bool test[4]; while(i < 4 or c > 9){r = 4;} repeat{c = 7;}until(d == 8 or v == 6); procedure proc(int intPar, int intArr[2], string stringPar, string stringArr[4], bool boolPar, string boolArr[3]){innerAssProc = 4;} foreach(i : pole){c = 4;} do{int c = 5;}while(i < 4 and i == 8); if(i == 4 and c == 8){int c = 5; for(o = 1 to 10){if(i == 7){bool r = true;}int g = 4;} string s = \"ahoj\"; bool tr = true;}";
    static String test2 = "int ahoj = 3;";

    public static void main(String[] args){

        String testFile = "test4.txt";
        String filesPath = "testFiles";
        String path = filesPath + File.separator + testFile;

        // load the contents of the file to a string:
        String content = loadContents(path);

        // change all trues / falseses to 1s / 0ses
       // content = editInput(content);


        ourCLexer lexer = new ourCLexer(CharStreams.fromString(content)); //content
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));

        ParseTree tree = null;
        tree = parser.start();

        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();
      
        // --- expressions ---
//        ArrayList<valueEvalDecData> operOrder = parseExprDecBool("100*(2+12)/14");
//        for(int i = 0; i < operOrder.size(); i++){
//            valueEvalDecData oper = operOrder.get(i);
//            System.out.println("Operation - START");
//            System.out.println(oper.getFirstVal() + ", " + oper.getOper() + ", " + oper.getSecondVal());
//            System.out.println("Operation - END");
//        }

        Compiler compiler = new Compiler(encounteredStatements);
        ArrayList<Instruction> generatedInstructions = compiler.compile();


        // write the instructions to a file:
        try {
            writeToFile(generatedInstructions);
        } catch (IOException e) {
            System.err.println("Something went wrong with writing to file.");
            e.printStackTrace();
        }
    }

    private static String loadContents(String filePath)
    {

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }


    // todo is this a good idea? what about var names, etc..?
    private static String editInput(String content){
        String res = content.replaceAll("true", "1");
        res = res.replaceAll("false", "0");

        return res;
    }


    private static void writeToFile(ArrayList<Instruction> instructions) throws IOException{
        String str = "Hello";
        String fileName = "resultInstr.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < instructions.size(); i++){
            str = "" + (i) + " " + instructions.get(i).toString() + "\n";
            writer.write(str);
        }




        writer.close();
    }


}