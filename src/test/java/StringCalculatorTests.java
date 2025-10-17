import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(expected, actual);
    }

    @Test
    void add_returns_input_whenOnlyOneNumberAndNewLinesInArgument() {
        int expected = 12;
        int actual = stringCalculator.add(",\n12,\n,\n,\n,");
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "'9,6',15",
            "'3,4',7",
            "'7,8,0,1,1',17",
            "'0,1,2,5,6',14"
    })
    void add_returns_result_whenMultipleNumbersInArgument(String input, String expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource({
            "'6,6',12",
            "'3,4\n,\n,5',12",
            "'7,8,0,1,2,\n,,,\n,1',19",
            "'0,\n,\n,0,1,,2,,,,5,,,,7,10',25"
    })
    void add_returns_result_whenMultipleNumbersAndNewLinesInArgument(String input, String expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource({
            "'//*\n6*6',12",
            "'//#\n3#4\n#\n#5',12",
            "'//&\n7&8&0&1&2&\n&&&\n&1',19",
            "'//,\n0,\n,\n,0,1,,2,,,,5,,,,7,10',25"
    })
    void add_returns_result_whenMultipleNumbersAndDifferentDelimiterInArgument(String input, String expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, Integer.parseInt(expected));
    }

    @Test
    void add_throws_exception_whenSingleNegativeNumbersInArguments() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> stringCalculator.add("-1,2,3,4,5,7"));
        assertEquals("negative numbers not allowed [-1]", exception.getMessage());
    }

    @Test
    void add_throws_exception_whenMultipleNegativeNumbersInArguments() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> stringCalculator.add("-1,-2,3,4,5,-7"));
        assertEquals("negative numbers not allowed [-1, -2, -7]", exception.getMessage());
    }

    @Test
    void add_ignores_numbersBiggerThanThousand() {
        int expected = 2;
        int actual = stringCalculator.add("2,1001");
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({
            "'//**\n6**6',12",
            "'//###\n3###4\n###\n###5',12",
            "'//&&&\n7&&&8&&&0&&&1&&&2&&&\n&&&\n&&&1',19",
            "'//,,\n0,,\n,,\n,,0,,1,,,,2,,,,5,,,,7,,10',25"
    })
    void add_returns_result_whenMultipleNumbersAndMultiCharacterDelimiterInArgument(String input, String expected) {
        int actual = stringCalculator.add(input);
        assertEquals(actual, Integer.parseInt(expected));
    }
}
