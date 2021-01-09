package compiler;

import compiler.errors.Error;

/**
 * Represents one operation between two numbers / symbols.
 */
public class Operation {
    // symbols must always have a value assigned
    private Symbol symbol1;
    private Symbol symbol2;
    private EOperator operator;

    private boolean negateResult = false;

    public EOperator getOperator() {
        return operator;
    }

    public void setOperator(EOperator operator) {
        this.operator = operator;
    }

    public Symbol getSymbol1() {
        return symbol1;
    }

    public void setSymbol1(Symbol symbol1) {
        this.symbol1 = symbol1;
    }

    public Symbol getSymbol2() {
        return symbol2;
    }

    public void setSymbol2(Symbol symbol2) {
        this.symbol2 = symbol2;
    }

    public int getResult(){
        int res = 0;
        int s1 = Integer.parseInt(symbol1.getValue());
        int s2 = Integer.parseInt(symbol2.getValue());

        if(symbol1.getType() == ESymbolType.ARRAY){
            if(symbol1.getIndToArray() != -1){
                s1 = symbol1.getArrayElements().get(symbol1.getIndToArray());
            }
            else{

            }
        }

        if(symbol2.getType() == ESymbolType.ARRAY){
            if(symbol2.getIndToArray() != -1){
                s1 = symbol2.getArrayElements().get(symbol2.getIndToArray());
            }
            else{

            }
        }

        switch (operator){
            case UNARY_MINUS: break;
            case PLUS: res = s1 + s2; break;
            case MINUS: res = s1 - s2; break;
            case MULT: res = s1 * s2; break;
            case DIV:
                if(s2 == 0)
                    Error.printDivisoinByZero();

                res = s1 / s2; break;
            case MOD: res = s1 % s2; break;
            case ODD: break;
            case EQUAL:
                if(s1 == s2) res = 1;
                else res = 0;
                break;
            case NOT_EQUAL:
                if(s1 != s2) res = 1;
                else res = 0;
                break;
            case LT:
                if(s1 < s2) res = 1;
                else res = 0;
                break;
            case GE:
                if(s1 >= s2) res = 1;
                else res = 0;
                break;
            case GT:
                if(s1 > s2) res = 1;
                else res = 0;
                break;
            case LE:
                if(s1 <= s2) res = 1;
                else res = 0;
                break;
            case OR:
                if(s1 == 0 && s2 == 0) res = 0;
                else res = 1;
                break;
            case AND:
                if(s1 != 0 && s2 != 0) res = 1;
                else res = 0;
                break;
            case NEG:
                if(s1 == 0) res = 1;
                else res = 0;
                break;
        }

        return res;
    }

    public boolean isNegateResult() {
        return negateResult;
    }

    public void setNegateResult(boolean negateResult) {
        this.negateResult = negateResult;
    }


    public int getNegatedResult(){
        int res = getResult();
        if(res == 0){
            return 1;
        }
        else return 0;
    }
}
