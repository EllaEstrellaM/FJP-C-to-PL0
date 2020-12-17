package visitors;
import generated.ourCBaseVisitor;
import generated.ourCParser;

public class VarAssVisitor extends ourCBaseVisitor {

    @Override
    public Object visitStart(ourCParser.StartContext ctx) {
        System.out.println("start");
        return super.visitStart(ctx);
    }

    @Override
    public Object visitArr_assignment(ourCParser.Arr_assignmentContext ctx) {
        System.out.println("ass");
        return super.visitArr_assignment(ctx);
    }

    @Override
    public Object visitCode_block(ourCParser.Code_blockContext ctx) {
        System.out.println("code block");
        return super.visitCode_block(ctx);
    }
}
