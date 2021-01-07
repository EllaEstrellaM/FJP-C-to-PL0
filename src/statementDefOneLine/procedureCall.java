package statementDefOneLine;

import compiler.ESymbolType;
import compiler.Symbol;
import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class procedureCall implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the called procedure
    String arguments; //arguments given in between brackets after procedure name
    /* relevant statement info to keep - END */

    public procedureCall(){
        setOperationType();
        wholeContent = "";

        identifierVar = "";
        arguments = "";
    }

    public ArrayList<String> getIndivArguments(){
        String[] splits = arguments.split(",");
        ArrayList<String> values = new ArrayList<>(splits.length);


        System.out.println("params:");
        for(int i = 0; i < splits.length; i++){
            System.out.println(splits[i]);

            values.add(splits[i]);
        }

        return values;
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
}
