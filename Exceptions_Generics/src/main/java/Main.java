import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidOperator {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        Scanner s = new Scanner(System.in);
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Divide divide = new Divide();
        Multiply multiply = new Multiply();

        while (true) {
            System.out.println("Enter the first number");
            Double x = s.nextDouble();
            System.out.println("Enter the second number");
            Double y = s.nextDouble();
            System.out.println("Choose the operation [+,-,*,/]");
            String n = s.next();
            switch (n) {

                case "+":
                    double add = 0;
                    try {
                        add = Operations.ADDITION.calculate(x, y);
                        add = addition.calculate(x, y);
                    } catch (InvalidNumber invalidNumber) {
                        invalidNumber.printStackTrace();
                    }
                    System.out.println("result: " + decimalFormat.format(add));

                    break;

                case "-":
                    double sub = 0;
                    try {
                        sub = Operations.SUBTRACTION.calculate(x, y);
                        sub = multiply.calculate(x, y);
                    } catch (InvalidNumber invalidNumber) {
                        invalidNumber.printStackTrace();
                    }
                    System.out.println("result: " + decimalFormat.format(sub));
                    break;

                case "/":
                    double div = 0;
                    try {
                        div = Operations.DIVIDE.calculate(x, y);
                        div = divide.calculate(x, y);
                    } catch (InvalidNumber invalidNumber) {
                        invalidNumber.printStackTrace();
                    }
                    System.out.println("result: " + decimalFormat.format(div));
                    break;

                case "*":
                    double multi = 0;
                    try {
                        multi = Operations.MULTIPLY.calculate(x, y);
                        multi = multiply.calculate(x, y);
                    } catch (InvalidNumber invalidNumber) {
                        invalidNumber.getMessage();
                    }
                    System.out.println("result: " + decimalFormat.format(multi));
                    break;

                default:
                    throw new InvalidOperator((char) 27 + "\033[1;36mInvalid input,please enter a valid operator {+, -, *, /}");
            }
        }
    }
}

