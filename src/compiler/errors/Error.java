package compiler.errors;

/**
 * Class contains methods which informs user about errors which occured during program translation.
 */
public class Error {
    /**
     * Main procedure was not found.
     */
    public static void printInvalidMain(boolean notFound, boolean arguments){
        if(notFound){
            System.err.println("No main procedure found.");
        }
        else if(arguments){
            System.err.println("The main procedure must not have any arguments.");
        }

        System.exit(0);
    }

    /**
     * Symbol was defined earlier in the code.
     */
    public static void printMultipleDefines(String varName){
        System.err.println("Symbol " + varName + " already defined earlier.");
        System.exit(0);
    }

    /**
     * User is trying to use unknown symbol.
     */
    public static void printVarNotFound(String varName){
        System.err.println("Unknown symbol " + varName+ ".");
        System.exit(0);
    }

    /**
     * User attempts to divide number by zero.
     */
    public static void printDivisoinByZero(){
        System.err.println("Attempt to divide by zero detected.");
        System.exit(0);
    }

    /**
     * User attempts to modify constant value.
     * @param constName name of the const variable
     */
    public static void printConstAssign(String constName){
        System.err.println("Cannot modify constant value " + constName + ".");
        System.exit(0);
    }

    /**
     * String which should be assigned is too long.
     */
    public static void printStringTooLong(String dest, String src){
        System.err.println("Cannot assign " + src + " to string " + dest + ", because " + src + " is too long.");
        System.exit(0);
    }

    /**
     * Value cannot be assigned to the variable.
     */
    public static void printCannotAssign(String dest, String src){
        System.err.println("Cannot assign " + src + " to " + dest);
        System.exit(0);
    }

    /**
     * Index of array is out of bounds.
     */
    public static void printOutOfBounds(String arrIdent, int index){
        System.err.println("Index " + index + " out of bounds of array " + arrIdent + ".");
        System.exit(0);
    }

    /**
     * Procedure call is not valid (number of args does not match).
     */
    public static void printUnmatchingArgs(String proc){
        System.err.println("Number of arguments doesn't match in procedure call of " + proc + ".");
        System.exit(0);
    }

    /**
     * Expression input is not valid
     */
    public static void printExprNotValid(String expr){
        System.err.println("Multiple signs in a row are not supported (use parentheses): " + expr + ".");
        System.exit(0);
    }
}
