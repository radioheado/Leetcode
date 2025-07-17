class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        for (int c2 = 0; c2 < k; c2++) {
            int[] dp = new int[k];
            for (int c1: nums) {
                c1 %= k;
                dp[c1] = dp[(c2 - c1 + k) % k] + 1;
                ans = Math.max(ans, dp[c1]);
            }
        }
        return ans;
    }
}