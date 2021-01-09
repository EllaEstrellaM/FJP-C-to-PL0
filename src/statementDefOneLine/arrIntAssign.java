package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

/**
 * Represents assign to array of ints.
 */
public class arrIntAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the array
    int decNum; //index to array
    int decVal; //value to assign to index
    /* relevant statement info to keep - END */

    public arrIntAssign(){
        setOperationType();
        wholeContent = "";
        identifierVar = "";
        decNum = 0;
        decVal = 0;
        innerLevel = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.ARR_INT_ASSIGN;
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
        return null;
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

    public int getDecVal() {
        return decVal;
    }

    public void setDecVal(int decVal) {
        this.decVal = decVal;
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
