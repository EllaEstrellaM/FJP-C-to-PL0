package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class procedureDefinition implements Istatement, ImultiLineStatement {
    @Override
    public void setOperationType() {

    }

    @Override
    public EmultiLineStatementType getOperationType() {
        return null;
    }

    @Override
    public void setWholeContent() {

    }

    @Override
    public String getWholeContent() {
        return null;
    }

    @Override
    public void addInnerStatement(Istatement statement) {

    }

    @Override
    public ArrayList<Istatement> getInnerStatement() {
        return null;
    }
}
