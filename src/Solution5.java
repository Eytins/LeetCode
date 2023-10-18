import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result5 {

    /*
     * Complete the 'countSignals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY frequencies
     *  2. 2D_INTEGER_ARRAY filterRanges
     */

    public static int countSignals(List<Integer> frequencies, List<List<Integer>> filterRanges) {
        int res = 0;
        int leftRange = Integer.MIN_VALUE;
        int rightRange = Integer.MAX_VALUE;
        for (List<Integer> range : filterRanges) {
            leftRange = Math.max(range.get(0), leftRange);
            rightRange = Math.min(range.get(1), rightRange);
        }
        for (Integer i : frequencies) {
            if (i >= leftRange && i <= rightRange) {
                res++;
            }
        }
        return res;
    }

}

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int frequenciesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> frequencies = IntStream.range(0, frequenciesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int filterRangesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int filterRangesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> filterRanges = new ArrayList<>();

        IntStream.range(0, filterRangesRows).forEach(i -> {
            try {
                filterRanges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result5.countSignals(frequencies, filterRanges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
