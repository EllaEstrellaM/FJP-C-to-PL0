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
    public Object visitVar_assignment(ourCParser.Var_assignmentContext ctx) {
        System.out.println("Visited var assignment...");
        return super.visitVar_assignment(ctx);
    }

    @Override
    public Object visitVar_declaration(ourCParser.Var_declarationContext ctx) {
        System.out.println("Visited var declaration...");
        return super.visitVar_declaration(ctx);
    }

    @Override
    public Object visitCode_block(ourCParser.Code_blockContext ctx) {
        System.out.println("code block");
        return super.visitCode_block(ctx);
    }

    @Override
    public Object visitStateStringVal(ourCParser.StateStringValContext ctx) {
        System.out.println("Into state string");
        return super.visitStateStringVal(ctx);
    }
}