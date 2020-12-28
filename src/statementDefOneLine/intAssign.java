package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class intAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    /* relevant statement info to keep - START */
    String identifierVar; //name of the variable
    boolean minus_sign; //true if value is <= 0, ie minus sign is present ; else false (if ommited or plus sign present)
    int decVal; //value of the variable
    /* relevant statement info to keep - END */

    public intAssign(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        minus_sign = false;
        decVal = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.INT_ASSIGN;
    }

    @Override
    public EoneLineStatementType getOperationType() {
        return operationType;
    }

    @Override
    public void setWholeContent(String content) {
        this.wholeContent = content;
    }

    @Override
    public String getWholeContent() {
        return this.wholeContent;
    }

    public String getIdentifierVar() {
        return identifierVar;
    }

    public void setIdentifierVar(String identifierVar) {
        this.identifierVar = identifierVar;
    }

    public boolean isMinus_sign() {
        return minus_sign;
    }

    public void setMinus_sign(boolean minus_sign) {
        this.minus_sign = minus_sign;
    }

    public int getDecVal() {
        return decVal;
    }

    public void setDecVal(int decVal) {
        this.decVal = decVal;
    }
}
