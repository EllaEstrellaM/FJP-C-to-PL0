package compiler;

public class Instruction {
    private EInstrSet instruction;
    private int level;
    private int address;

    public Instruction(EInstrSet instr, int first, int second){
        this.instruction = instr;
        this.level = first;
        this.address = second;
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


    @Override
    public String toString() {
        return "" + instruction + " " + level + " " + address;
    }
}
