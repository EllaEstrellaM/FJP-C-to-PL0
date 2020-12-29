package statementDefMultiLine;

import statementInterEnum.EmultiLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.ImultiLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class procedureDefinition implements Istatement, ImultiLineStatement, IDeclaration {
    EmultiLineStatementType operationType;
    String wholeContent;
    ArrayList<Istatement> innerStatementsList;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW procedure
    String parameters; //contains parameters (content in brackets after procedure name)
    /* relevant statement info to keep - END */

    public procedureDefinition(){
        setOperationType();
        wholeContent = "";
        innerStatementsList = new ArrayList<Istatement>();

        identifierVar = "";
        parameters = "";
    }

    @Override
    public void setOperationType() {
        operationType = EmultiLineStatementType.PROCEDURE_DEFINITION;
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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
