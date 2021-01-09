package statementDefOneLine;

import statementInterEnum.EoneLineStatementType;
import statementInterEnum.IDeclaration;
import statementInterEnum.IoneLineStatement;
import statementInterEnum.Istatement;

import java.util.ArrayList;

public class constStringDeclaration implements Istatement, IoneLineStatement, IDeclaration {
    EoneLineStatementType operationType;
    String wholeContent;
    int innerLevel;

    /* relevant statement info to keep - START */
    String identifierVar; //name of the NEW variable
    String stringVal; //value of the NEW variable
    ArrayList<String> identifierMulti; //list of multiassign
    /* relevant statement info to keep - END */

    public constStringDeclaration(){
        setOperationType();
        wholeContent = "";
        innerLevel = 0;

        identifierVar = "";
        stringVal = "";
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
        operationType = EoneLineStatementType.CONST_STRING_DECLARATION;
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

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
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
