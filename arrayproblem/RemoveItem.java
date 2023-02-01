public class RemoveItem {
    /**
     * 27
     *
     * @param nums 参数
     * @param val 参数
     * @return 返回值
     */
    public int removeElement(int[] nums, int val) {
        int slow, fast = 0;
        for (slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 26
     *
     * @param nums 参数
     * @return 返回值
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast;
        for (fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != nums[fast + 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 283
     *
     * @param nums 参数
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 283
     *
     * @param nums 参数
     */
    public void moveZeroes2(int[] nums) {
        int slow = 0, fast;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 844
     *
     * @param s 参数
     * @param t 参数
     * @return 返回值
     */
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public int[] sortedSquares(int[] nums) {
        int front = 0, end = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = res.length - 1; i >= 0; i--) {
            if (nums[front] * nums[front] > nums[end] * nums[end]) {
                res[i] = nums[front] * nums[front];
                front++;
            } else {
                res[i] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
