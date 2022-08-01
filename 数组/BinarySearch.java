class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        if (target >= nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        // 情况二
        return new int[]{-1, -1};
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] <= target) {
                left = middle + 1;
                rightBorder = right;
            } else {
                right = middle - 1;
            }
        }
        return rightBorder;
    }

    /**
     * wrong
     * @param x 参数
     * @return 返回值
     */
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if ((middle << 1) < x) {
                left = middle + 1;
            } else if ((middle >> 1) > x) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return left;
    }
}