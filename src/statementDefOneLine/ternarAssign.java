package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class ternarAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the variable, which we want to assign value
    String exprDecBoolCont; //conditions written in between brackets before ?
    String exprDecBoolTrueVal; //value, which will be assigned to identifierVar if condition equals TRUE
    String exprDecBoolFalseVal; //value, which will be assigned to identifierVar if condition equals FALSE

    int index; //index of the array ; (in case of arr ; else -1)
    /* relevant statement info to keep - END */

    public ternarAssign(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;
        index = 0;

        identifierVar = "";
        exprDecBoolCont = "";
        exprDecBoolTrueVal =  "";
        exprDecBoolFalseVal = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.TERNAR_ASSIGN;
    }

    @Override
    public EoneLineStatementType getOperationType() {
        return operationType;
    }

    @Override
    public ArrayList<String> getIdentifierMulti() {
        return null;
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

    public String getExprDecBoolCont() {
        return exprDecBoolCont;
    }

    public void setExprDecBoolCont(String exprDecBoolCont) {
        this.exprDecBoolCont = exprDecBoolCont;
    }

    public String getExprDecBoolTrueVal() {
        return exprDecBoolTrueVal;
    }

    public void setExprDecBoolTrueVal(String exprDecBoolTrueVal) {
        this.exprDecBoolTrueVal = exprDecBoolTrueVal;
    }

    public String getExprDecBoolFalseVal() {
        return exprDecBoolFalseVal;
    }

    public void setExprDecBoolFalseVal(String exprDecBoolFalseVal) {
        this.exprDecBoolFalseVal = exprDecBoolFalseVal;
    }

    @Override
    public void setInnerLevel(int level) {
        this.innerLevel = level;
    }

    @Override
    public int getInnerLevel() {
        return innerLevel;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
