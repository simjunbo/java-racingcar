package study.calculator.operator;

public class Multiply implements Operator {
    @Override
    public boolean isOperator(String expression) {
        return expression.equals("*");
    }

    @Override
    public int operate(Operand firstArg, Operand secondArg) {
        return firstArg.getValue() * secondArg.getValue();
    }
}
