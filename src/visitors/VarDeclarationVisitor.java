package visitors;

import compiler.Symbol;
import generated.*;
import org.antlr.v4.runtime.ParserRuleContext;

public class VarDeclarationVisitor extends ourCBaseVisitor<Symbol> {
    @Override
    public Symbol visitVar_declaration(ourCParser.Var_declarationContext ctx) {
        System.out.println("declaration");

        String text = ctx.getText();
        System.out.println(text);


        // parse the text:
        Symbol s = new Symbol();

        // is it const?
        if(text.startsWith("const")){
            s.setConst(true);
            text = text.replaceFirst("const", "");
        }
        else{
            s.setConst(false);
        }

        // what type is it:
        if(text.startsWith("int")){
            s.setType("int");
            text = text.replaceFirst("int", "");
        }
        else if(text.startsWith("bool")){
            s.setType("bool");
            text = text.replaceFirst("bool", "");
        }
        else if(text.startsWith("string")){
            s.setType("string");
            text = text.replaceFirst("string", "");
        }

        // get the name and the value
        text = text.replace(";", "");

        String[] splits = text.split("=");
        s.setName(splits[0]);
        s.setValue(splits[1]);

//        System.out.println(splits[0]);
//        System.out.println(splits[1]);

        return s;
    }
}
