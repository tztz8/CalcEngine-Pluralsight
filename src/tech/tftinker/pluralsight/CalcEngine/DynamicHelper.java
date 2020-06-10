package tech.tftinker.pluralsight.CalcEngine;

public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers){
        this.handlers = handlers;
    }

    public String process(char opCode, double leftVal, double rightVal) throws InvalidStatementException{
        MathProcessing theHandler = null;

        for(MathProcessing handler:handlers){
            if(opCode == handler.getOpCode()){
                theHandler = handler;
                break;
            }
        }

        if(theHandler == null){
            throw new InvalidStatementException("Invalid opCode", Character.toString(opCode));
        }

        double result;
        try {
            result = theHandler.doCalculation(leftVal, rightVal);
        }catch (InvalidValException e){
            String statement = opCode + " " + leftVal + " " + rightVal;
            throw new InvalidStatementException("Can not do calculation with given values: ", statement, e);
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

    public String process(String statement) throws InvalidStatementException{
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0];

        if (parts.length != 3){
            throw new InvalidStatementException("Incorrect number of fields", statement);
        }

        MathProcessing theHandler = null;

        for(MathProcessing handler:handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }

        if(theHandler == null){
            throw new InvalidStatementException("Invalid command", statement);
        }

        double leftVal;
        double rightVal;

        try {
            leftVal = Double.parseDouble(parts[1]);
            rightVal = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e){
            throw new InvalidStatementException("Non-numeric data (Ex. \"two\" does not work)", statement, e);
        }

        double result;
        try {
            result = theHandler.doCalculation(leftVal, rightVal);
        } catch (InvalidValException e) {
            throw new InvalidStatementException("Can not do calculation with given values: ", statement, e);
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
}
