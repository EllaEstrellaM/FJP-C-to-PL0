package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class constBoolDeclaration implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    public constBoolDeclaration(){
        setOperationType();
        wholeContent = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.CONST_BOOL_DECLARATION;
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
