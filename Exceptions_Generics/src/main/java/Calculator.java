public interface Calculator<T extends Number> {
    T calculate(T num1, T num2) throws  InvalidNumber;
}