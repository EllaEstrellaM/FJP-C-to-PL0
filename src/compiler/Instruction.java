package compiler;

public class Instruction {
    private EInstrSet instruction;
    private int level;
    private int address;
    private String jmpAddr;

    public Instruction(EInstrSet instr, int first, int second){
        this.instruction = instr;
        this.level = first;
        this.address = second;
    }

    public Instruction(String jmpAddr){
        this.jmpAddr = jmpAddr;
        this.instruction = null;
        this.address = -1;
        this.level = -1;
    }

    public Instruction(Instruction other){
        this.address = other.getAddress();
        this.instruction = other.getInstruction();
        this.level = other.getLevel();
        this.jmpAddr = other.getJmpAddr();
    }

    // getters and setters:
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public EInstrSet getInstruction() {
        return instruction;
    }

    public void setInstruction(EInstrSet instruction) {
        this.instruction = instruction;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getJmpAddr() {
        return jmpAddr;
    }

    public void setJmpAddr(String jmpAddr) {
        this.jmpAddr = jmpAddr;
    }

    @Override
    public String toString() {
        return "" + instruction + " " + level + " " + address;
    }
}
