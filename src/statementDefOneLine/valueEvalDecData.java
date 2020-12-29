package statementDefOneLine;

public class valueEvalDecData {
    int firstVal;
    int secondVal;
    char oper;

    public valueEvalDecData(){
        this.firstVal = 0;
        this.secondVal = 0;
        oper = '+';
    }

    public int getFirstVal() {
        return firstVal;
    }

    public void setFirstVal(int firstVal) {
        this.firstVal = firstVal;
    }

    public int getSecondVal() {
        return secondVal;
    }

    public void setSecondVal(int secondVal) {
        this.secondVal = secondVal;
    }

    public char getOper() {
        return oper;
    }

    public void setOper(char oper) {
        this.oper = oper;
    }
}
