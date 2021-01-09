package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class constArrIntDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW array
    int decNum; //size of the NEW array
    /* relevant statement info to keep - END */

    public constArrIntDeclaration(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;

        identifierVar = "";
        decNum = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.CONST_ARR_INT_DECLARATION;
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

    public int getDecNum() {
        return decNum;
    }

    public void setDecNum(int decNum) {
        this.decNum = decNum;
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
