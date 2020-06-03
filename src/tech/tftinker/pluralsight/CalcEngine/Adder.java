package tech.tftinker.pluralsight.CalcEngine;

public class Adder extends CalculateBase{
    public Adder(){}
    public Adder(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public double calculate(){
        double value = getLeftVal() + getRightVal();
        setResult(value);
        return getResult();
    }
}
