import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution8 {
    class Result8 {
        long getMaximumAmount(List<Integer> quantity, int m) {
            long revenue = 0;
            for (int i = 0; i < m; i++) {
                Integer max = Collections.max(quantity);
                revenue += max;
                int maxIndex = quantity.indexOf(max);
                if (maxIndex != -1) {
                    quantity.set(maxIndex, max - 1);
                }
            }

            return revenue;
        }

        List<Integer> getPopularityOrder(List<List<Integer>> song_preferences) {
            List<Integer> result = new ArrayList<>();
            int userSize = song_preferences.size();
            int songSize = song_preferences.get(0).size();
            int[] songScores = new int[songSize];
            for (int i = 0; i < userSize; i++) {
                for (int j = 0; j < songSize; j++) {
                    songScores[j] += song_preferences.get(i).get(j);
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
