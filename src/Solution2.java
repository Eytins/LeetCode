import java.io.*;

import static java.util.stream.Collectors.joining;


class Result2 {

    /*
     * Complete the 'findMinimumInefficiency' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING serverType as parameter.
     */

    public static boolean dif (char a, char b) {
        if (a == '1' && b == '0') {
            return true;
        } else if (a == '0' && b == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static int findMinimumInefficiency(String serverType) {
        // Write your code here
        char[] array = serverType.toCharArray();
        int i = 0, j = 0;
        int result = 0;
        for (int k = 0; k < array.length - 1; k++) {
            if (serverType.startsWith("01", k) || serverType.startsWith("10", k)) {
                result++;
            }
        }
        while (i < array.length - 1) {
            if (array[i + 1] == '?') {
                j = i + 1;
                while (j < array.length - 1 && array[j] == '?') {
                    j++;
                }
                if (dif(array[i], array[j])) {
                    result++;
                }
                i = j;
            }
            i++;
            j++;
        }
        return result;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        String serverType = bufferedReader.readLine();

        int result = Result2.findMinimumInefficiency(serverType);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
