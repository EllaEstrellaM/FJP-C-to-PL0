import java.util.ArrayList;

public interface ImultiLineStatement {
    EmultiLineStatementType getOperationType(); //gets type of operation (EmultiLineStatement)

    void addInnerStatement(Istatement statement); //adds one inner one-line (instance IoneLineStatement) or multi-line (instance ImultiLineStatement) statement to ArrayList which stores them
    ArrayList<Istatement> getInnerStatement(); //getter for above ArrayList
}
