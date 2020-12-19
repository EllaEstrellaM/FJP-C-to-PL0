package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class whileCycle implements Istatement, ImultiLineStatement {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;

    public whileCycle(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.WHILE_CYCLE;
    }

    @Override
    public EmultiLineStatementType getOperationType() {
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

    @Override
    public void addInnerStatement(Istatement statement) {
        this.innerStatementsList.add(statement);
    }

    @Override
    public ArrayList<Istatement> getInnerStatement() {
        return innerStatementsList;
    }
}
