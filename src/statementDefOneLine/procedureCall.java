package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

public class procedureCall implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    /* relevant statement info to keep - START */
    String arguments; //arguments given in between brackets after procedure name
    /* relevant statement info to keep - END */

    public procedureCall(){
        setOperationType();
        wholeContent = "";

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

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
}
