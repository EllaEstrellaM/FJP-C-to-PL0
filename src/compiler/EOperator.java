package compiler;

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
    LE(13);

    private int instrCode;
    private EOperator(int instrCode){
        ;;
    }


    public int getInstrCode() {
        return instrCode;
    }
}
