package tech.tftinker.pluralsight.CalcEngine;

public class Multiplier extends CalculateBase{
    public Multiplier(){}
    public Multiplier(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public double calculate(){
        double value = getLeftVal() * getRightVal();
        setResult(value);
        return getResult();
    }
}
