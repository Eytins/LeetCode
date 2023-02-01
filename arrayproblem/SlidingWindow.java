import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindow {
    /**
     * 209暴力解法
     *
     * @param target 参数
     * @param nums   参数
     * @return 返回值
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum;
        int subLength;
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
     * @param target 参数
     * @param nums   参数
     * @return 返回值
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength;
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
     * @param fruits 参数
     * @return 返回值
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

    /**
     * 76 略麻烦，懒得做，有心情了再做
     *
     * @param s 参数
     * @param t 参数
     * @return 返回值
     */
    public String minWindow(String s, String t) {
        return "";
    }

    /**
     * 59
     *
     * @param n 参数
     * @return 返回值
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0;
        int loop = 0;
        int i, j;
        int count = 1;
        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            for (; j > start; j--) {
                res[i][j] = count++;
            }
            for (; i > start; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }

    /**
     * 54 没对，不过大差不差，最后的判断再改一下就ok
     *
     * @param matrix 参数
     * @return 返回值
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int loop = 0;
        int i = 0, j = 0;
        int start = 0;
        int xLength = matrix[0].length;
        int yLength = matrix.length;
        int n = Math.min(xLength, yLength);
        List<Integer> res = new ArrayList<>();
        while (loop++ < n / 2) {
            for (j = start; j < xLength - start - 1; j++) {
                res.add(matrix[start][j]);
            }
            for (i = start; i < yLength - start - 1; i++) {
                res.add(matrix[i][j]);
            }
            for (; j > start; j--) {
                res.add(matrix[i][j]);
            }
            for (; i > start; i--) {
                res.add(matrix[i][j]);
            }
            start++;
        }
        if (n == xLength) {
            for (i = start; i < yLength - start - 1; i++) {
                res.add(matrix[i][j]);
            }
        } else {
            for (j = start; j < xLength - start - 1; j++) {
                res.add(matrix[i][j]);
            }
        }
        return res;
    }
}
