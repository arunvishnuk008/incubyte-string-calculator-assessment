import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        if (numbers != null && !numbers.isBlank()) {
            result = Arrays.stream(numbers.split(","))
                    .map(str -> str.replace("\n", ""))
                    .filter( str -> !str.isBlank() )
                    .map(Integer::parseInt)
                    .reduce(Integer::sum).orElse(0);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
