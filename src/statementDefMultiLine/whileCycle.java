package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

/**
 * Represents while cycle.
 */
public class whileCycle implements Istatement, ImultiLineStatement {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;
    int innerLevel;

    /* relevant statement info to keep - START */
    String exprDecBoolCont; //conditions written after while in between brackets
    /* relevant statement info to keep - END */

    public whileCycle(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();
        innerLevel = 0;

        exprDecBoolCont = "";
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
    public ArrayList<Istatement> getInnerStatements() {
        return innerStatementsList;
    }

    public String getExprDecBoolCont() {
        return exprDecBoolCont;
    }

    public void setExprDecBoolCont(String exprDecBoolCont) {
        this.exprDecBoolCont = exprDecBoolCont;
    }

    @Override
    public void setInnerLevel(int level) {
        this.innerLevel = level;
    }

    @Override
    public int getInnerLevel() {
        return innerLevel;
    }
}
