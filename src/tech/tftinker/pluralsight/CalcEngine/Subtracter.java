package tech.tftinker.pluralsight.CalcEngine;

public class Subtracter extends CalculateBase implements MathProcessing{
    public Subtracter(){}
    public Subtracter(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public double calculate(){
        double value = getLeftVal() - getRightVal();
        setResult(value);
        return getResult();
    }

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }

    @Override
    public char getOpCode() {
        return 's';
    }
}
