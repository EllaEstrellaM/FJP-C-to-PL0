package compiler;

/**
 * Contains possible PL/0 comparison operators.
 */
public enum EOperator {
    UNARY_MINUS(1),
    PLUS(2),
    MINUS(3),
    MULT(4),
    DIV(5),
    MOD(6),
    ODD(7),
    EQUAL(8),
    NOT_EQUAL(9),
    LT(10),
    GE(11),
    GT(12),
    LE(13),

    // these that follow aren't part of the instruction set:
    OR(-1),
    AND(-1),
    NEG(-1);


    private final int instrCode;
    private EOperator(int instrCode){
        this.instrCode = instrCode;
    }

    public int getInstrCode() {
        return instrCode;
    }

    /**
     * Returns PL/0 instruction code corresponding to given String.
     * @param str represents symbol to which we want to get specific instruction code
     * @return PL/0 instruction code
     */
    public static EOperator getOperFromString(String str){
        switch (str){
            case "unary minus": return UNARY_MINUS;
            case "+": return PLUS;
            case "-": return MINUS;
            case "*": return MULT;
            case "/": return DIV;
            case "%": return MOD;
            case "odd": return ODD;
            case "==": return EQUAL;
            case "!=": return NOT_EQUAL;
            case "<": return LT;
            case ">=": return GE;
            case ">": return GT;
            case "<=": return LE;
            case "|": return OR;
            case "&": return AND;
            case "!": return NEG;
            default: return null;
        }
    }
}
