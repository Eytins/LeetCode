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


class Result {

    /*
     * Complete the 'countFaults' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY logs
     */

    public static int countFaults(int n, List<String> logs) {
        // Write your code here
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String log : logs) {
            String[] params = log.split(" ");
            int id = Integer.parseInt(params[0].substring(1));
            if (params[1].equals("error")) {
                Integer time = map.getOrDefault(id, 0) + 1;
                map.put(id, time);
            }
        }

        for (int i = 1; i <= n; i++) {
            int time = map.getOrDefault(i, 0);
            int times = time / 3;
            result += times;
        }
        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.countFaults(n, logs);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
