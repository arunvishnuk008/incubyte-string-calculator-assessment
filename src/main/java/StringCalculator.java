import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        if (numbers != null && !numbers.isBlank()) {
            // extract the delimiter if it is present
            String delimiter = ",";
            List<Integer> numbersList = extractNumbers(numbers, delimiter, numbers);
            // check for negatives first
            List<Integer> negatives = numbersList.stream().filter(num -> num < 0)
                    .toList();
            if (!negatives.isEmpty()) {
                throw new RuntimeException(String.format("negative numbers not allowed %s", negatives));
            }
            result = numbersList.stream()
                    .reduce(Integer::sum).orElse(0);
        }
        return result;
    }

    private static List<Integer> extractNumbers(String numbers, String delimiter, String numbersLine) {
        if (numbers.startsWith("//")) {
            int endIndex = 0;
            boolean notFound = true;
            int index = 0;
            while (notFound) {
                if (numbers.charAt(index) == '\n') {
                    endIndex = index;
                    notFound = false;
                }
                index += 1;
            }
            // we found index of first newline, construct the delimiter. substring starts at 2 to strip off the // at the beginning
            delimiter = "\\" + numbers.substring(2, endIndex);
            numbersLine = numbers.substring(endIndex);
        }
        return Arrays.stream(numbersLine.split(delimiter))
                .map(str -> str.replace("\n", ""))
                .filter(str -> !str.isBlank())
                .map(Integer::parseInt)
                .filter(num -> num <= 1000)
                .toList();
    }


    public static void main(String[] args) {
        System.out.println(new StringCalculator().add("1,2"));
    }

}
