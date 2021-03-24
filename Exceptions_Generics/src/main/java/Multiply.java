public class Multiply implements Calculator<Double>{
    @Override
    public Double calculate(Double num1, Double num2) throws NegativeNumber {
        if (num1 < 0 || num2 < 0) {
            throw new NegativeNumber((char) 27 + "\033[1;33mYou can use only positive numbers ");
        }
        return num1 * num2;
    }
}