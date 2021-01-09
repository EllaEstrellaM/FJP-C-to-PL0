import compiler.Compiler;
import compiler.Instruction;
import generated.ourCLexer;
import generated.ourCParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import statementInterEnum.Istatement;
import visitors.VarAssVisitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args){
        String testFile = "testif.txt";
        String filesPath = "testFiles";
        String path = filesPath + File.separator + testFile;

        // load the contents of the file to a string:
        String content = loadContents(path);

        ourCLexer lexer = new ourCLexer(CharStreams.fromString(content)); //content
        ourCParser parser = new ourCParser(new CommonTokenStream(lexer));

        ParseTree tree = null;
        tree = parser.start();

        VarAssVisitor varAss = new VarAssVisitor();
        varAss.visit(tree);

        ArrayList<Istatement> encounteredStatements = varAss.getEncounteredStatements();

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