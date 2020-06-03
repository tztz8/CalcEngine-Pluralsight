package tech.tftinker.pluralsight.CalcEngine;

public class Subtracter extends CalculateBase{
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
}
