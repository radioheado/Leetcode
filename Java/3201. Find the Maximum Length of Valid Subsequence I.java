class Solution {
    public int maximumLength(int[] nums) {
        int[] dp = new int[4];
        for (int n: nums) {
            if (n % 2 == 1) {
                dp[0]++;
                dp[2] = dp[3] + 1;
            } else {
                dp[1]++;
                dp[3] = dp[2] + 1;
            }
        }
        return max(dp);
    }

    private int max(int[] dp) {
        int ans = 0;
        for (int n: dp) {
            ans = Math.max(ans, n);
        }
        return ans;
    }
}