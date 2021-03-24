import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    Addition addition = new Addition();

    @Test
    public void test_addition() {
        assertEquals(7.0,addition.calculate (4.0, 3.0));
    }

    @Test
    public void test_addition_negative_no() {
        Exception exception = assertThrows(NegativeNumber.class, () -> addition.calculate(5.0,-1.0));
        String executeMessage ="You can use only positive numbers ";
    }
}