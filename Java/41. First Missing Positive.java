class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean one = true;
        for (int n: nums) {
            if (n == 1) {
                one = false;
                break;
            }
        }

        if (one) {
            return 1;
        }

        int m = nums.length;
        for (int i=0; i<m; i++) {
            if (nums[i] <= 0 || nums[i] > m) {
                nums[i] = 1;
            }
        }

        for (int i=0; i<m; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i=0; i<m; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return m + 1;
    }
}