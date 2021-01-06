package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class procedureCall implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the called procedure
    String arguments; //arguments given in between brackets after procedure name
    /* relevant statement info to keep - END */

    public procedureCall(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;

        identifierVar = "";
        arguments = "";
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.PROCEDURE_CALL;
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

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
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
