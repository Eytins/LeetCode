import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
    /**
     * 209暴力解法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    res = Math.min(res, subLength);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 209滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 904
     *
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1); // 右边界
            while (map.size() > 2) { // 不符合条件：水果种类大于2
                // left一定被放置过了
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++; // 左边界
            }
            maxLen = Math.max(maxLen, i - left + 1); // 更新结果
        }
        return maxLen;
    }

    public int totalFruit2(int[] fruits) {
        int left = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    /**
     * 76 略麻烦，懒得做，有心情了再做
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        return "";
    }

}
