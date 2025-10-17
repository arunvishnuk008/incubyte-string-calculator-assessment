import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTests {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void add_returnsZero_whenEmptyStringInArgument() {
        int expected = 0;
        int actual = stringCalculator.add("");
        assertEquals(expected, actual);
    }

    @Test
    void add_returns_input_whenOnlyOneNumberInArgument() {
        int expected = 8;
        int actual = stringCalculator.add("8");
        assertEquals(expected,actual);
    }

    @Test
    void add_returns_input_whenOnlyOneNumberAndNewLinesInArgument() {
        int expected = 12;
        int actual = stringCalculator.add(",\n12,\n,\n,\n,");
        assertEquals(expected,actual);
    }
}
