class Solution {
    public int maxAscendingSum(int[] nums) {
        int prefix = nums[0], ans = prefix;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                prefix += nums[i];
            } else {
                prefix = nums[i];
            }
            ans = Math.max(ans, prefix);
        }

        return ans;
    }
}