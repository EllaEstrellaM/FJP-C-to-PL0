package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class constStringDeclaration implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    public constStringDeclaration(){
        setOperationType();
        wholeContent = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.CONST_STRING_DECLARATION;
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
