class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int modulo = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= modulo;
        }

        for (int i = low + 1; i <= high; i++) {
            dp[i] += dp[i-1];
            dp[i] %= modulo;
        }

        return dp[high];
    }
}