package statementDefOneLine;

public class valueEvalDecData {
    String firstVal;
    String secondVal;
    char oper;

    public valueEvalDecData(){
        this.firstVal = "";
        this.secondVal = "";
        oper = '+';
    }

    public String getFirstVal() {
        return firstVal;
    }

    public void setFirstVal(String firstVal) {
        this.firstVal = firstVal;
    }

    public String getSecondVal() {
        return secondVal;
    }

    public void setSecondVal(String secondVal) {
        this.secondVal = secondVal;
    }

    public char getOper() {
        return oper;
    }

    public void setOper(char oper) {
        this.oper = oper;
    }
}
