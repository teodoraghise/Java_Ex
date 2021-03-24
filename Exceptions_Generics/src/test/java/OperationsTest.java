import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    public void test_Addition() throws InvalidNumber {
        Double actual = Operations.ADDITION.calculate(2.0, 2.0);
        Double expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_Subtraction() throws InvalidNumber {
        Double actual = Operations.SUBTRACTION.calculate(5.0, 2.0);
        Double expected = 3.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_Multiple() throws InvalidNumber {
        Double actual = Operations.MULTIPLY.calculate(5.0, 2.0);
        Double expected = 10.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_Divide() throws InvalidNumber {
        Double actual = Operations.DIVIDE.calculate(8.0, 2.0);
        Double expected = 4.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_invalid_number() {
        Exception exception = assertThrows(InvalidNumber.class, () -> Operations.MULTIPLY.calculate(5.0, 10000000000.0));
        String executeMessage = "You cannot have more then 10 digits ";
    }

}