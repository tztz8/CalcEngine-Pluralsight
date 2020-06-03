package tech.tftinker.pluralsight.CalcEngine;

public class MathEquation {
    private double leftVal, rightVal, result;
    private char opCode;

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public MathEquation(){}

    public MathEquation(char opCode){
        setOpCode(opCode);
    }

    public MathEquation(char opCode, double leftVal, double rightVal){
        this(opCode);
        setLeftVal(leftVal);
        setRightVal(rightVal);
    }

    public double execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        return execute();
    }

    public double execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int) result;
        return result;
    }

    public double execute(){
        switch (opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                result = 0.0d;
                System.out.println("opCode:" + opCode + " does not exist");
                break;
        }
        return result;
    }
}
