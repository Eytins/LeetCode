import java.util.*;
import java.util.function.ToIntFunction;

public class Solution {
    /**
     * 242
     *
     * @param s 参数
     * @param t 参数
     * @return 返回值
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 383
     *
     * @param ransomNote 参数
     * @param magazine   参数
     * @return 返回值
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            record[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 49 violent
     *
     * @param strs 参数
     * @return 返回值
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int length = strs.length;
        String[] sortedStrs = new String[length];
        for (int i = 0; i < length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sortedStrs[i] = Arrays.toString(chars);
        }
        for (int i = 0; i < length; i++) {
            List<String> resultItem = new ArrayList<>();
            if (sortedStrs[i] != null) {
                resultItem.add(strs[i]);
                for (int j = i + 1; j < length; j++) {
                    if (sortedStrs[i].equals(sortedStrs[j])) {
                        resultItem.add(strs[j]);
                        sortedStrs[j] = null;
                    }
                }
            }
            if (resultItem.size() != 0) {
                result.add(resultItem);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 438 这种方法超出了时间限制
     *
     * @param s s
     * @param p p
     * @return r
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int pLength = p.length();
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String sortedP = Arrays.toString(pChars);
        for (int i = 0; i < s.length() - pLength; i++) {
            String subS = s.substring(i, i + pLength);
            char[] sChars = subS.toCharArray();
            Arrays.sort(sChars);
            if (sortedP.equals(Arrays.toString(sChars))) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int pLength = p.length();
        int sLength = s.length();
        int[] pHash = new int[26];
        int[] sHash = new int[26];
        for (int i = 0; i < pLength; i++) {
            pHash[p.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pHash, sHash)) {
            result.add(0);
        }
        for (int i = 0; i < sLength - pLength; i++) {
            sHash[s.charAt(i) - 'a']--;
            sHash[s.charAt(i + pLength) - 'a']++;
            if (Arrays.equals(sHash, pHash)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 349
     *
     * @param nums1 n
     * @param nums2 n
     * @return r
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i :
                nums1) {
            set.add(i);
        }
        for (int i :
                nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }

    /**
     * 350
     *
     * @param nums1 n
     * @param nums2 n
     * @return r
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        for (int num :
                nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res.add(num);
                map.put(num, --count);
            }
        }
        return res.stream().mapToInt(value -> value).toArray();
    }

    /**
     * 202
     *
     * @param n n
     * @return r
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            if (n == 1) {
                return true;
            }
            n = getNextNumber(n);
        }
        return false;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    /**
     * 1
     *
     * @param nums   n
     * @param target t
     * @return r
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    /**
     * 454
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int key = i + j;
                int value = map.getOrDefault(key, 0);
                map.put(key, ++value);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int key = i + j;
                if (map.containsKey(-key)) {
                    count+=map.get(-key);
                }
            }
        }
        return count;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        
    }

    public static void main(String[] args) {
        System.out.println(1 % 10);
    }
}