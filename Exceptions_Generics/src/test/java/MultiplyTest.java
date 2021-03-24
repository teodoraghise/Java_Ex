import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
    Multiply multiply = new Multiply();

    @Test
    public void test_addition() {
        assertEquals(12.0, multiply.calculate(4.0, 3.0));
    }

    @Test
    public void test_multiply_negative_no() {
        Exception exception = assertThrows(NegativeNumber.class, () -> multiply.calculate(5.0, -1.0));
        String executeMessage = "You can use only positive numbers ";
    }
}