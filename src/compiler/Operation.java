package compiler;

import java.util.ArrayList;

public class Operation {

    // todo if we want the symbol to not be an actual variable, but only a number, the address will be -1

    // symbols must always have a value assigned
    private Symbol symbol1;
    private Symbol symbol2;
    private EOperator operator;


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

        switch (operator){
            case UNARY_MINUS: break;
            case PLUS: res = s1 + s2; break;
            case MINUS: res = s1 - s2; break;
            case MULT: res = s1 * s2; break;
            case DIV: res = s1 / s2; break;
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
        }

        return res;
    }
}
