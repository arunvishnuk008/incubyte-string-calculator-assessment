import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        if (numbers != null && !numbers.isBlank()) {
            // extract the delimiter if it is present
            String delimiter = ",";
            String numbersLine = numbers;
            int endIndex = 0;
            if (numbers.startsWith("//")) {
                boolean notFound = true;
                int index = 0;
                while (notFound) {
                    if (numbers.charAt(index) == '\n') {
                        endIndex = index;
                        notFound = false;
                    }
                    index += 1;
                }
                // we found index, construct the delimiter
                delimiter = "\\" + numbers.substring(2, endIndex);
                numbersLine = numbers.substring(endIndex);
            }
            result = Arrays.stream(numbersLine.split(delimiter))
                    .map(str -> str.replace("\n", ""))
                    .filter(str -> !str.isBlank())
                    .map(Integer::parseInt)
                    .reduce(Integer::sum).orElse(0);
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
