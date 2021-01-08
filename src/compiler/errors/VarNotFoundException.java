package compiler.errors;

public class VarNotFoundException extends Exception{

    private final String name;
    public VarNotFoundException(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
