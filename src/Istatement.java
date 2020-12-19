public interface Istatement {
    void setWholeContent(); //sets content of whole code block (one-line: int i = 3; multi-line: if(condtition){commands;} etc)
    String getWholeContent(); //gets content of above

    void setOperationType(); //sets operation type from EoneLineStatementType (one-line statement) or EmultiLineStatementType (multi-line statement)
}
