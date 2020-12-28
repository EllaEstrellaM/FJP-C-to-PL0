package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class foreachCycle implements Istatement, ImultiLineStatement {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;

    /* relevant statement info to keep - START */
    String identifierVar1;//name of the variable, which will be taken in count (represents one value in array)
    String identifierVar2;//name of the array, which will be traversed
    /* relevant statement info to keep - END */

    public foreachCycle(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();

        identifierVar1 = "";
        identifierVar2 = "";
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.FOREACH_CYCLE;
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

    public String getIdentifierVar1() {
        return identifierVar1;
    }

    public void setIdentifierVar1(String identifierVar1) {
        this.identifierVar1 = identifierVar1;
    }

    public String getIdentifierVar2() {
        return identifierVar2;
    }

    public void setIdentifierVar2(String identifierVar2) {
        this.identifierVar2 = identifierVar2;
    }
}
