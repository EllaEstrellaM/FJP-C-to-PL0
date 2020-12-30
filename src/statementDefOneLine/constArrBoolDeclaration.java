package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class constArrBoolDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW array
    int decNum; //size of the NEW array
    /* relevant statement info to keep - END */

    public constArrBoolDeclaration(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        decNum = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.CONST_ARR_BOOL_DECLARATION;
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

    public int getDecNum() {
        return decNum;
    }

    public void setDecNum(int decNum) {
        this.decNum = decNum;
    }
}
