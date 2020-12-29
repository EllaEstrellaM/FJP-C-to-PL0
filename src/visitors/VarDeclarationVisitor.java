//package visitors;
//
//import compiler.ESymbolType;
//import compiler.Symbol;
//import generated.*;
//import org.antlr.v4.runtime.ParserRuleContext;
//
//public class VarDeclarationVisitor extends ourCBaseVisitor<Symbol> {
//
//
//    @Override
//    public Symbol visitVar_declaration(ourCParser.Var_declarationContext ctx) {
//        System.out.println("declaration");
//
//        String text = ctx.getText();
//        System.out.println(text);
//
//
//        // parse the text:
//        Symbol s = new Symbol();
//
//        // is it const?
//        if(text.startsWith("const")){
//            s.setConst(true);
//            text = text.replaceFirst("const", "");
//        }
//        else{
//            s.setConst(false);
//        }
//
//        // what type is it:
//        if(text.startsWith("int")){
//            s.setType(ESymbolType.INT);
//            text = text.replaceFirst("int", "");
//        }
//        else if(text.startsWith("bool")){
//            s.setType(ESymbolType.BOOL);
//            text = text.replaceFirst("bool", "");
//        }
//        else if(text.startsWith("string")){
//            s.setType(ESymbolType.STRING);
//            text = text.replaceFirst("string", "");
//        }
//        // todo else if array
//
//        // get the name and the value
//        text = text.replace(";", "");
//
//        String[] splits = text.split("=");
//        s.setName(splits[0]);
//        s.setValue(splits[1]);
//
////        System.out.println(splits[0]);
////        System.out.println(splits[1]);
//
//
//        return s; // todo were does it go?
//    }
//
////    @Override
////    protected Symbol aggregateResult(Symbol aggregate, Symbol nextResult) {
////        if(aggregate == null){
////            return nextResult;
////        }
////        if(nextResult == null){
////            return aggregate;
////        }
////
////        return aggregate;
////    }
//}
