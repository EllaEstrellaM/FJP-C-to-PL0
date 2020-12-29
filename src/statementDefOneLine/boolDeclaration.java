package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class boolDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW variable
    String boolVal; //value of the NEW variable
    /* relevant statement info to keep - END */

    public boolDeclaration(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        boolVal = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.BOOL_DECLARATION;
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

    public String getBoolVal() {
        return boolVal;
    }

    public void setBoolVal(String boolVal) {
        this.boolVal = boolVal;
    }
}
