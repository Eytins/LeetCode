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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



class Result3 {

    /*
     * Complete the 'getQueryAnswers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY cache_entries
     *  2. 2D_STRING_ARRAY queries
     */
    public static int compareTimeStrings(String timeStr1, String timeStr2) {
        // Split the time strings into hours, minutes, and seconds
        String[] parts1 = timeStr1.split(":");
        String[] parts2 = timeStr2.split(":");

        int hour1 = Integer.parseInt(parts1[0]);
        int minute1 = Integer.parseInt(parts1[1]);
        int second1 = Integer.parseInt(parts1[2]);

        int hour2 = Integer.parseInt(parts2[0]);
        int minute2 = Integer.parseInt(parts2[1]);
        int second2 = Integer.parseInt(parts2[2]);

        // Compare the time components
        if (hour1 < hour2) {
            return -1;
        } else if (hour1 > hour2) {
            return 1;
        } else if (minute1 < minute2) {
            return -1;
        } else if (minute1 > minute2) {
            return 1;
        } else if (second1 < second2) {
            return -1;
        } else if (second1 > second2) {
            return 1;
        } else {
            return 0;
        }
    }


    public static List<Integer> getQueryAnswers(List<List<String>> cache_entries, List<List<String>> queries) {
        // Write your code here
        List<List<String>> commands = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int a = 0;
        int b = 0;
        int entrySize = cache_entries.size();
        int querySize = queries.size();

        cache_entries.sort((x, y) -> {
            String xTime = x.get(0);
            String yTime = y.get(0);

            return compareTimeStrings(xTime, yTime);
        });

        queries.sort((x, y) -> {
            String xTime = x.get(1);
            String yTime = y.get(1);

            return compareTimeStrings(xTime, yTime);
        });

        while (a != entrySize && b != querySize) {
            if (a == entrySize) {
                List<String> query = queries.get(b);
                commands.add(query);
                b++;
                continue;
            } else if (b == querySize) {
                List<String> entry = cache_entries.get(a);
                commands.add(entry);
                a++;
                continue;
            }
            List<String> entry = cache_entries.get(a);
            List<String> query = queries.get(b);
            String entryTime = entry.get(0);
            String queryTime = query.get(1);

            int comparisonResult = compareTimeStrings(entryTime, queryTime);

            if (comparisonResult < 0) {
                commands.add(entry);
                a++;
            } else if (comparisonResult > 0) {
                commands.add(query);
                b++;
            } else {
                commands.add(entry);
                commands.add(query);
                a++;
                b++;
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (List<String> command : commands) {
            if (command.size() == 3) {
                String key = command.get(1);
                Integer value = Integer.parseInt(command.get(2));
                map.put(key, value);
            } else {
                String key = command.get(0);
                result.add(map.get(key));
            }
        }
        return result;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int cache_entriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int cache_entriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> cache_entries = new ArrayList<>();

        IntStream.range(0, cache_entriesRows).forEach(i -> {
            try {
                cache_entries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result3.getQueryAnswers(cache_entries, queries);

        System.out.println(result);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
