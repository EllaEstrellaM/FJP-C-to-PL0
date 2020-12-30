package compiler.errors;

public class Error {

    public static void printInvalidMain(boolean notFound, boolean arguments){

        if(notFound){
            System.err.println("No main procedure found.");
        }
        else if(arguments){
            System.err.println("The main procedure must not have any arguments.");
        }

        System.exit(0);
    }

    public static void printMultipleDefines(String varName){
        System.err.println("Symbol " + varName + " already defined earlier.");
        System.exit(0);
    }

    public static void printVarNotFound(String varName){
        System.err.println("Unknown symbol " + varName+ ".");
        System.exit(0);
    }

    public static void printDivisoinByZero(){
        System.err.println("Attempt to divide by zero detected.");
        System.exit(0);
    }
}
