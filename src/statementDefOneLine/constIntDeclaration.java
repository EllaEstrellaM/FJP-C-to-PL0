package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class constIntDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW variable
    boolean minus_sign; //true if value of NEW variable is <= 0, ie minus sign is present ; else false (if ommited or plus sign present)
    String decVal; //value of the NEW variable (could be name of the identifier or direct value...)
    /* relevant statement info to keep - END */

    public constIntDeclaration(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        minus_sign = false;
        decVal = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.CONST_INT_DECLARATION;
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

    public String getDecVal() {
        return decVal;
    }

    public void setDecVal(String decVal) {
        this.decVal = decVal;
    }
}
