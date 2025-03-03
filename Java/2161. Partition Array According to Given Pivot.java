class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0, equal = 0;
        for (int n: nums) {
            if (n < pivot) {
                less++;
            } else if (n == pivot) {
                equal++;
            }
        }

        int[] ans = new int[nums.length];
        int less_i = 0, equal_i = less, greater_i = less + equal;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < pivot) {
                ans[less_i++] = n;
            } else if (n > pivot) {
                ans[greater_i++] = n;
            } else {
                ans[equal_i++] = n;
            }
        }

        return ans;
    }
}