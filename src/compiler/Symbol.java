package compiler;

public class Symbol {
    private String name;
    private int lev;
    private int adr;
    private int size;
    private String type; // todo enum?
    private boolean isConst;
    private String value;





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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public void printInfo(){
        System.out.println("--- symbol info ---");
        System.out.println("name: " + name);
        System.out.println("lev: " + lev);
        System.out.println("adr: " + adr);
        System.out.println("size: " + size);
        System.out.println("type: " + type);
        System.out.println("isConst: " + isConst);
        System.out.println("value: " + value);
    }
}
