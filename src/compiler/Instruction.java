package compiler;

/**
 * Each instance represents one PL/0 instruction.
 */
public class Instruction {
    private EInstrSet instruction;
    private int level;
    private int address;
    private String jmpAddr;
    public String jmpRecurTag = "";

    /**
     * Constructor accepts instruction type, level and address.
     * @param instr type of instruction
     * @param first level
     * @param second address
     */
    public Instruction(EInstrSet instr, int first, int second){
        this.instruction = instr;
        this.level = first;
        this.address = second;
    }

    /**
     * Used for tagging instructions (address which should be changed afterwards).
     * @param jmpAddr unique identifier
     */
    public Instruction(String jmpAddr){
        this.jmpAddr = jmpAddr;
        this.instruction = null;
        this.address = -1;
        this.level = -1;
    }

//    public Instruction(EInstrSet instr, int first, int second, String jmpAddr){
//        this.instruction = instr;
//        this.level = first;
//        this.address = second;
//        this.jmpAddr = jmpAddr;
//    }

    /**
     * Used for creating "deep copy".
     * @param other another instance of this class
     */
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

//        if(jmpAddr != null){
//            return jmpAddr;
//        }
        return "" + instruction + " " + level + " " + address;// + " " + jmpRecurTag;
    }
}
