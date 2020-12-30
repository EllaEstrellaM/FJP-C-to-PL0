package statementInterEnum;

import java.util.ArrayList;

public interface ImultiLineStatement {
    EmultiLineStatementType getOperationType(); //gets type of operation (EmultiLineStatement)

    void addInnerStatement(Istatement statement); //adds one inner one-line (instance statementInterEnum.IoneLineStatement) or multi-line (instance statementInterEnum.ImultiLineStatement) statement to ArrayList which stores them
    ArrayList<Istatement> getInnerStatements(); //getter for above ArrayList
}