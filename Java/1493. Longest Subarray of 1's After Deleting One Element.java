class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, l = 0, zero = -1;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = zero + 1;
                zero = r;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}