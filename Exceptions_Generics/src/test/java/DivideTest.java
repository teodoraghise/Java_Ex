import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    Divide divide = new Divide();
    private Object DivideByZero;

    @Test
    public void test_divide_by_zero() {
        Exception exception = assertThrows(DivideByZero.class, () -> divide.calculate(5.0, 0.0));
        String executeMessage = "You can not divide by zero ";
    }

    @Test
    public void test_divide() {
        assertEquals(5.0, divide.calculate(30.0, 6.0));
    }

    @Test
    public void test_divide_negative_no() {
        Exception exception = assertThrows(NegativeNumber.class, () -> divide.calculate(5.0, -1.0));
        String executeMessage = "You can use only positive numbers ";
    }
}