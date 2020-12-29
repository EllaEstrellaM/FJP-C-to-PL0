package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class stringDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW variable
    String stringVal; //value of the NEW variable
    /* relevant statement info to keep - END */

    public stringDeclaration(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        stringVal = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.STRING_DECLARATION;
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

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }
}
