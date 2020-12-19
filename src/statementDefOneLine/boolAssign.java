package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class boolAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    /* relevant statement info to keep - START */
    String identifierVar; //name of the variable
    boolean boolVal; //value of the variable
    /* relevant statement info to keep - END */

    public boolAssign(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        boolVal = false;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.BOOL_ASSIGN;
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

    public boolean isBoolVal() {
        return boolVal;
    }

    public void setBoolVal(boolean boolVal) {
        this.boolVal = boolVal;
    }
}
