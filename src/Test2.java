import java.util.HashMap;
import java.util.Map;

public class Test2 {
    int solution(String pattern, String source) {
        int pLength = pattern.length();
        int sLength = source.length();
        int res = sLength - pLength + 1;
        boolean flag = true;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('y', 0);

        for (int i = 0; i < sLength - pLength + 1; i++) {
            for (int j = 0; j < pLength; j++) {
                char c = pattern.charAt(j);
                if (c == '0') {
                    if (!map.containsKey(source.charAt(i + j))) {
                        flag = false;
                    }
                } else {
                    if (map.containsKey(source.charAt(i + j))) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                res--;
            }
            flag = true;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}