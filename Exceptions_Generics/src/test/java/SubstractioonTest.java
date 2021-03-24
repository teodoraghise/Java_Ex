import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {
    Subtraction subtraction = new Subtraction();

    @Test
    public void test_addition() {
        assertEquals(1.0,subtraction.calculate (4.0, 3.0));
    }

    @Test
    public void test_addition_negative_no() {
        Exception exception = assertThrows(NegativeNumber.class, () -> subtraction.calculate(5.0,-1.0));
        String executeMessage ="You can use only positive numbers ";
    }
}