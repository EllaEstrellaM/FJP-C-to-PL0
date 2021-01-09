package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

/**
 * Represents assign to array (could be of any type)
 */
public class unknownArrAssign implements Istatement, IoneLineStatement {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the array
    boolean minusSign; //true if value is <= 0, ie minus sign is present ; else false (if ommited or plus sign present) ; used just on int arr assign...
    String valueVar; //value of the variable
    int indexToAssign; //index of array to which new value should be inserted
    /* relevant statement info to keep - END */

    public unknownArrAssign(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;

        identifierVar = "";
        minusSign = false;
        valueVar = "";
        indexToAssign = 0;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.UNKNOWN_ARR_ASSIGN;
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
        return this.wholeContent;
    }

    public String getIdentifierVar() {
        return identifierVar;
    }

    public void setIdentifierVar(String identifierVar) {
        this.identifierVar = identifierVar;
    }

    public boolean isMinusSign() {
        return minusSign;
    }

    public void setMinusSign(boolean minusSign) {
        this.minusSign = minusSign;
    }

    public String getValueVar() {
        return valueVar;
    }

    public void setValueVar(String valueVar) {
        this.valueVar = valueVar;
    }

    public int getIndexToAssign() {
        return indexToAssign;
    }

    public void setIndexToAssign(int indexToAssign) {
        this.indexToAssign = indexToAssign;
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
