package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class stringTernarDeclaration implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the variable, which we want to assign value
    String exprDecBoolCont; //conditions written in between brackets before ?
    String exprDecBoolTrueVal; //value, which will be assigned to identifierVar if condition equals TRUE
    String exprDecBoolFalseVal; //value, which will be assigned to identifierVar if condition equals FALSE
    /* relevant statement info to keep - END */

    public stringTernarDeclaration(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        exprDecBoolCont = "";
        exprDecBoolTrueVal =  "";
        exprDecBoolFalseVal = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.STRING_TERNAR_DECLARATION;
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
}
