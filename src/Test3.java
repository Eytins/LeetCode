import java.util.HashMap;
import java.util.Map;

public class Test3 {


    long solution(String[] queryType, int[][] query) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queryType.length; i++) {
            if (queryType[i].equals("insert")) {
                map.put(query[i][0], query[i][1]);
            } else if (queryType[i].equals("get")) {
                sum += map.get(query[i][0]);
            } else if (queryType[i].equals("addToKey")) {
                Map<Integer, Integer> temp = new HashMap<>();
                int num = query[i][0];
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    temp.put(entry.getKey() + num, entry.getValue());
                }
                map = temp;
            } else if (queryType[i].equals("addToValue")) {
                int num = query[i][0];
                map.replaceAll((k, v) -> v + num);
            }
        }
        return sum;
    }
}
