package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class forCycle implements Istatement, ImultiLineStatement {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;

    /* relevant statement info to keep - START */
    String identifierVar;//name of the variable, from which will cycle begin
    int exprDecBool1;//value of the variable in the beginning of the cycle
    int exprDecBool2;//value of the variable in the end of the cycle (value after TO)
    /* relevant statement info to keep - END */

    public forCycle(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();

        identifierVar = "";
        exprDecBool1 = 0;
        exprDecBool2 = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.FOR_CYCLE;
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

    public String getIdentifierVar() {
        return identifierVar;
    }

    public void setIdentifierVar(String identifierVar) {
        this.identifierVar = identifierVar;
    }

    public int getExprDecBool1() {
        return exprDecBool1;
    }

    public void setExprDecBool1(int exprDecBool1) {
        this.exprDecBool1 = exprDecBool1;
    }

    public int getExprDecBool2() {
        return exprDecBool2;
    }

    public void setExprDecBool2(int exprDecBool2) {
        this.exprDecBool2 = exprDecBool2;
    }
}
