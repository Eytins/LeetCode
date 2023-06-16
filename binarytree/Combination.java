import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Combination {
    List<String> result = new ArrayList<>();

    List<char[]> numsMap = new ArrayList<>();

    byte[] nums;

    StringBuilder temp = new StringBuilder();

    String globalDigits;

    public List<String> letterCombinations(String digits) {
        numsMap.add(new char[]{});
        numsMap.add(new char[]{});
        numsMap.add(new char[]{'a', 'b', 'c'});
        numsMap.add(new char[]{'d', 'e', 'f'});
        numsMap.add(new char[]{'g', 'h', 'i'});
        numsMap.add(new char[]{'j', 'k', 'l'});
        numsMap.add(new char[]{'m', 'n', 'o'});
        numsMap.add(new char[]{'p', 'q', 'r', 's'});
        numsMap.add(new char[]{'t', 'u', 'v'});
        numsMap.add(new char[]{'w', 'x', 'y', 'z'});
        globalDigits = digits;
        backtrace(0);
        return result;
    }

    private void backtrace(int layer) {
        if (layer == globalDigits.length()) {
            result.add(temp.toString());
            return;
        }
        char[] letters = numsMap.get(globalDigits.charAt(layer) - '0');
        for (int i = 0; i < letters.length; i++) {
            temp.append(letters[i]);
            backtrace(layer + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
        int[] a = new int[1];
        List<Integer> list = Arrays.stream(a).boxed().toList();
        Collections.sort(list);
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.letterCombinations("23"));
    }
}
