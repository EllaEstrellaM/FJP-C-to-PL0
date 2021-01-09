package compiler;

import java.util.ArrayList;

/**
 * Represents one symbol which is present in symbols table.
 */
public class Symbol {
    private String name;
    private int lev;
    private int adr;
    private int sizeArr;
    private ESymbolType type;
    private boolean isConst;
    private boolean hasBeenDeclared;

    // save everything as a string - all ints, bools, strings and arrays
    private String value;

    private String inProcedure;
    private String procParameters;

    private boolean negateValue;
    private int indToArray;
    private boolean isPartialResult;

    private ArrayList<Integer> arrayElements;

    public Symbol(){
        this.name = "";
        this.lev = 0;
        this.adr = -1;
        this.sizeArr = -1;
        this.type = null;
        this.isConst = false;
        this.value = "0";
        this.inProcedure = "global";
        this.procParameters = "";
        this.negateValue = false;
        this.indToArray = -1;
        this.isPartialResult = false;
    }

    public Symbol(Symbol copy){
        this.name = copy.getName();
        this.lev = copy.getLev();
        this.adr = copy.getAdr();
        this.sizeArr = copy.getSizeArr();
        this.type = copy.getType();
        this.isConst = copy.isConst();
        this.value = copy.getValue();
        this.inProcedure = copy.getInProcedure();
        this.procParameters = copy.getProcParameters();
        this.negateValue = copy.isNegateValue();
        this.indToArray = copy.getIndToArray();
        this.isPartialResult = copy.isPartialResult();
        this.arrayElements = copy.getArrayElements();
    }

    // getters and setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    public int getAdr() {
        return adr;
    }

    public void setAdr(int adr) {
        this.adr = adr;
    }

    public int getSizeArr() {
        return sizeArr;
    }

    public void setSizeArr(int sizeArr) {
        this.sizeArr = sizeArr;
        this.arrayElements = new ArrayList<>(sizeArr);
        for(int i = 0; i < sizeArr; i++){
            this.arrayElements.add(0);
        }
    }

    public ESymbolType getType() {
        return type;
    }

    public void setType(ESymbolType type) {
        this.type = type;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }

    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

    public String getInProcedure() {
        return inProcedure;
    }

    public void setInProcedure(String inProcedure) {
        this.inProcedure = inProcedure;
    }

    public String getProcParameters() {
        return procParameters;
    }

    public void setProcParameters(String procParameters) {
        this.procParameters = procParameters;
    }

    public boolean hasBeenDeclared() {
        return hasBeenDeclared;
    }

    public void setHasBeenDeclared(boolean hasBeenDeclared) {
        this.hasBeenDeclared = hasBeenDeclared;
    }

    public boolean isNegateValue() {
        return negateValue;
    }

    public void setNegateValue(boolean negateValue) {
        this.negateValue = negateValue;
    }

    public int getIndToArray() {
        return indToArray;
    }

    public void setIndToArray(int indToArray) {
        this.indToArray = indToArray;
    }

    public ArrayList<Integer> getArrayElements() {
        return arrayElements;
    }

    public boolean isPartialResult() {
        return isPartialResult;
    }

    public void setPartialResult(boolean partialResult) {
        isPartialResult = partialResult;
    }

    public int negate(){

        int val;
        if(indToArray != -1){
            val = arrayElements.get(indToArray);
        }
        else{
            val = Integer.parseInt(this.value);
        }

        if(val == 0){
            return 1;
        }
        else return 0;


    }
}
