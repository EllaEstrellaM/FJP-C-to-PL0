package compiler.instructions_generators;

import compiler.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class takes care of generating PL/0 instructions regarding to if condition.
 */
public class IfInstructions {
    public static int resultVal;

    /**
     * Generates beginning of the if condition.
     * @param ifCond object which represents if condition
     * @param cond condition given by user
     * @param globTable global symbol table
     * @param privTable private symbol table
     * @return beginning of if condition
     */
    public static ArrayList<Instruction> generateInstructions(Object ifCond, String cond, HashMap<String, Symbol> globTable, HashMap<String, Symbol> privTable) {
        ArrayList<Instruction> generatedInstructions = new ArrayList<Instruction>();

        // perform arithmetics on the condition and let it store the result at the top of the stack:
        // there will be no strings

        ArrayList<Operation> opOrd = ExpressionParser.parseExprDecBool(cond, globTable, privTable);

        if(opOrd.size() > 0){
            // is expression
            // generate the arithmetic instructions:
            for(int i = 0; i < opOrd.size(); i++){
                Operation oper = opOrd.get(i);
                generatedInstructions.addAll(ArithmeticExpressionInstructions.generateInstructions(oper));
            }
            resultVal = opOrd.get(opOrd.size() - 1).getResult();
            if(opOrd.get(opOrd.size() - 1).isNegateResult()){
                resultVal = opOrd.get(opOrd.size() - 1).getNegatedResult();
            }
        }
        else {
            Symbol retrSymb = ExpressionParser.retrievedSymbol;
            if(retrSymb != null){
                if(retrSymb.getAdr() == -1){
                    if(!retrSymb.isNegateValue()){
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                        resultVal = Integer.parseInt(retrSymb.getValue());
                    }
                    else{
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, Integer.parseInt(retrSymb.getValue())));
                        generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                        generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                        resultVal = retrSymb.negate();
                    }

                }
                else{
                    if(retrSymb.getIndToArray() == -1){
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            resultVal = Integer.parseInt(retrSymb.getValue());
                        }
                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                            resultVal = retrSymb.negate();
                        }

                    }

                    else{
                        if(!retrSymb.isNegateValue()){
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            resultVal = retrSymb.getArrayElements().get(retrSymb.getIndToArray());
                        }
                        else{
                            generatedInstructions.add(new Instruction(EInstrSet.LOD, retrSymb.getLev(), retrSymb.getAdr() + retrSymb.getIndToArray()));
                            generatedInstructions.add(new Instruction(EInstrSet.LIT, 0, 1));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.PLUS.getInstrCode()));
                            generatedInstructions.add(new Instruction(EInstrSet.OPR, 0, EOperator.ODD.getInstrCode()));
                            resultVal = retrSymb.negate();
                        }

                    }

                }
            }
            else{

            }
        }
        generatedInstructions.add(new Instruction(ifCond + "JMC")); //here we should jump to RET

        return generatedInstructions;

    }

    /**
     * Generates end of if condition.
     * @param st object which represents if condition
     * @return end of if condition
     */
    public static ArrayList<Instruction> generateInstructionsEnd(Object st){
        ArrayList<Instruction> generatedInstructions = new ArrayList<>();
        generatedInstructions.add(new Instruction(st + "JMC"));
        return generatedInstructions;
    }
}
