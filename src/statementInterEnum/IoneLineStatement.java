package statementInterEnum;

import java.util.ArrayList;

public interface IoneLineStatement {
    EoneLineStatementType getOperationType(); //gets type of operation (EoneLineStatement)
    ArrayList<String> getIdentifierMulti();
}