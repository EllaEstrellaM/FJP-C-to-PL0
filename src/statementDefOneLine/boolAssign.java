package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class boolAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

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
}
