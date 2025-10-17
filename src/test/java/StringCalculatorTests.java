import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTests {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void add_returnsZero_whenEmptyStringArgument() {
        int expected = 0;
        int actual = stringCalculator.add("");
        assertEquals(expected, actual);
    }

    @Test
    void add_returns_input_whenOnlyOneNumberArgument() {
        int expected = 8;
        int actual = stringCalculator.add("8");
        assertEquals(expected,actual);
    }
}
