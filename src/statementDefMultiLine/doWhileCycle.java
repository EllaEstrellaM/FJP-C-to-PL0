package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class doWhileCycle implements Istatement, ImultiLineStatement {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;

    /* relevant statement info to keep - START */
    String exprDecBoolCont; //conditions written in between brackets after while
    /* relevant statement info to keep - END */

    public doWhileCycle(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();
        exprDecBoolCont = "";
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.DO_WHILE_CYCLE;
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
    public ArrayList<Istatement> getInnerStatements() {
        return innerStatementsList;
    }

    public String getExprDecBoolCont() {
        return exprDecBoolCont;
    }

    public void setExprDecBoolCont(String exprDecBoolCont) {
        this.exprDecBoolCont = exprDecBoolCont;
    }
}
