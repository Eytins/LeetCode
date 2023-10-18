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


class Result1 {

    /*
     * Complete the 'subsetA' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int getScoreDifference(List<Integer> numSeq) {
        int firstScore = 0;
        int secondScore = 0;
        boolean isFirstPlayerTurn = true;

        while (!numSeq.isEmpty()) {
            int currentNumber = numSeq.remove(0);
            if (isFirstPlayerTurn) {
                firstScore += currentNumber;
            } else {
                secondScore += currentNumber;
            }

            if (currentNumber % 2 == 0) {
                Collections.reverse(numSeq);
            }

            isFirstPlayerTurn = !isFirstPlayerTurn;
        }

        return firstScore - secondScore;
    }
}

public class Solution4 {
    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(6);
        a.add(2);
        a.add(3);
        a.add(5);
        System.out.println(Result1.getScoreDifference(a));
    }
}
