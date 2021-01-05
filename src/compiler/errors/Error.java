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

    public static void printConstAssign(String constName){
        System.err.println("Cannot modify constant value " + constName + ".");
        System.exit(0);
    }

    public static void printStringTooLong(String dest, String src){
        System.err.println("Cannot assign " + src + " to string " + dest + ", because " + src + " is too long.");
        System.exit(0);
    }

    public static void printCannotAssign(String dest, String src){
        System.err.println("Cannot assign " + src + " to " + dest);
        System.exit(0);
    }

    public static void printOutOfBounds(String arrIdent, int index){
        System.err.println("Index " + index + " out of bounds of array " + arrIdent + ".");
        System.exit(0);
    }
}
