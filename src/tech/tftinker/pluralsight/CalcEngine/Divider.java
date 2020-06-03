package tech.tftinker.pluralsight.CalcEngine;

public class Divider extends CalculateBase{
    public Divider(){}
    public Divider(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public double calculate(){
        double value = getLeftVal() / getRightVal();
        setResult(value);
        return getResult();
    }
}
