package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

/**
 * Represents int declaration.
 */
public class intDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW variable
    boolean minus_sign; //true if value of NEW variable is <= 0, ie minus sign is present ; else false (if ommited or plus sign present)
    String decVal; //value of the NEW variable (could be name of the identifier or direct value...)
    ArrayList<String> identifierMulti; //list of multiassign
    /* relevant statement info to keep - END */

    public intDeclaration(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;

        identifierVar = "";
        minus_sign = false;
        decVal = "";
        identifierMulti = new ArrayList<>();
    }

    public void addToIdentifMulti(String ident){
        identifierMulti.add(ident);
    }

    public ArrayList<String> getIdentifierMulti(){
        return identifierMulti;
    }

    @Override
    public void setOperationType() {
        operationType = EoneLineStatementType.INT_DECLARATION;
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

    public boolean isMinus_sign() {
        return minus_sign;
    }

    public void setMinus_sign(boolean minus_sign) {
        this.minus_sign = minus_sign;
    }

    public String getDecVal() {
        return decVal;
    }

    public void setDecVal(String decVal) {
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
