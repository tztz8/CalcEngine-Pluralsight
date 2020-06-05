package tech.tftinker.pluralsight.CalcApp;

import tech.tftinker.pluralsight.CalcEngine.CalculateHelper;
import tech.tftinker.pluralsight.CalcEngine.DynamicHelper;
import tech.tftinker.pluralsight.CalcEngine.InvalidStatementException;
import tech.tftinker.pluralsight.CalcEngine.MathEquation;
import tech.tftinker.pluralsight.CalcEngine.CalculateBase;
import tech.tftinker.pluralsight.CalcEngine.Adder;
import tech.tftinker.pluralsight.CalcEngine.MathProcessing;
import tech.tftinker.pluralsight.CalcEngine.PowerOf;
import tech.tftinker.pluralsight.CalcEngine.Subtracter;
import tech.tftinker.pluralsight.CalcEngine.Multiplier;
import tech.tftinker.pluralsight.CalcEngine.Divider;

public class Main {

    public static void main(String[] args) {
        originalMain(args);
        System.out.println();
        System.out.println("Using Calculater Helper - enum");
        System.out.println();
        newMain(args);
        System.out.println();
        System.out.println("Using Calculater Helper - Interfaces");
        System.out.println();
        thirdMain(args);
    }

    private static void thirdMain(String[] args) {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "add 25.0 92.0",        // 25.0 + 92.0 = 117.0
                "power 5.0 2.0",        // 5.0 ^ 2.0 = 25.0
                "divide 100.0 50.0",    // 100.0 / 50.0 = 2.0
                "add 25.0 92.0",        // 25.0 + 92.0 = 117.0
                "subtract 225.0 17.0",  // 225.0 - 17.0 = 108.0
                "multiply 11.0 3.0"     // 11.0 * 3.0 = 33.0
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new Subtracter(),
                new Multiplier(),
                new Divider(),
                new PowerOf()
        });

        for(String statement:statements){
            try {
                String output = helper.process(statement);
                System.out.println(output);
            } catch (InvalidStatementException e){
                System.out.println("ERROR");
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("\tOriginal exception: " + e.getCause().getMessage());
                }
                System.out.println();
            }
        }
    }

    private static void newMain(String[] args) {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",    // 100.0 / 50.0 = 2.0
                "add 25.0 92.0",        // 25.0 + 92.0 = 117.0
                "subtract 225.0 17.0",  // 225.0 - 17.0 = 108.0
                "multiply 11.0 3.0"     // 11.0 * 3.0 = 33.0
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement:statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e){
                System.out.println("ERROR");
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("\tOriginal exception: " + e.getCause().getMessage());
                }
                System.out.println();
            }
        }
    }

    public static void originalMain(String[] args){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation: equations){
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());


        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators){
            calculator.calculate();
            System.out.print("result = ");
            System.out.println(calculator.getResult());
        }
    }
}
