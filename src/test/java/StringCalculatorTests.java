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
}
