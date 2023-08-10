class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        int l = 0, r = n - 1, m;

        while (l <= r) {
            m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return true;
            }

            if (!binarySearchable(nums, l, nums[m])) {
                l++;
                continue;
            }

            boolean pivot = existsInFirstHalf(nums, l, nums[m]), half = existsInFirstHalf(nums, l, target);
            if (pivot ^ half) {
                if (pivot) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return false;
    }

    private boolean existsInFirstHalf(int[] nums, int l, int n) {
        return nums[l] <= n;
    }

    private boolean binarySearchable(int[] nums, int l, int n) {
        return nums[l] != n;
    }
}