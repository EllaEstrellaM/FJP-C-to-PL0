package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class unknownAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the variable
    boolean minusSign; //true if value is <= 0, ie minus sign is present ; else false (if ommited or plus sign present) ; used just on int assign...
    String valueVar; //value of the variable
    /* relevant statement info to keep - END */

    public unknownAssign(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        minusSign = false;
        valueVar = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.UNKNOWN_ASSIGN;
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

    public boolean isMinusSign() {
        return minusSign;
    }

    public void setMinusSign(boolean minusSign) {
        this.minusSign = minusSign;
    }

    public String getValueVar() {
        return valueVar;
    }

    public void setValueVar(String valueVar) {
        this.valueVar = valueVar;
    }
}