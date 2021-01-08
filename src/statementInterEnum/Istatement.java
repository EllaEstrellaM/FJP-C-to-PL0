package statementInterEnum;

public interface Istatement {
    void setWholeContent(String content); //sets content of whole code block (one-line: int i = 3; multi-line: if(condtition){commands;} etc)
    String getWholeContent(); //gets content of above

    void setOperationType(); //sets operation type from statementInterEnum.EoneLineStatementType (one-line statement) or statementInterEnum.EmultiLineStatementType (multi-line statement)

    void setInnerLevel(int level); //sets level of inner
    int getInnerLevel(); //gets level of inner
}