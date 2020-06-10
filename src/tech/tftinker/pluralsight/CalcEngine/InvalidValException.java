package tech.tftinker.pluralsight.CalcEngine;

public class InvalidValException extends Exception{
    public InvalidValException (String reason, double leftVal, double rightVal){
        super(reason + ": leftVal(" + leftVal + ") rightVal(" + rightVal + ")");
    }

    public InvalidValException (String reason, double leftVal, double rightVal, Throwable cause){
        super(reason + ": leftVal(" + leftVal + ") rightVal(" + rightVal + ")", cause);
    }
}
