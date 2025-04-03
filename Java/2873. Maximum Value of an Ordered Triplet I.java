class Solution {
    public long maximumTripletValue(int[] nums) {
        long max_i = 0, max_diff = 0;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, max_diff * nums[i]);
            max_diff = Math.max(max_diff, max_i - nums[i]);
            max_i = Math.max(max_i, nums[i]);
        }

        return ans;
    }
}