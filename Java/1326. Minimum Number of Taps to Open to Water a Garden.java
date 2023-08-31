class Solution {
    public int minTaps(int n, int[] ranges) {
        final int inf = (int) 1e9;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            for (int j = left; j <= right; j++) {
                dp[right] = Math.min(dp[right], dp[j] + 1);
            }
        }

        return dp[n] == inf ? -1 : dp[n];
    }
}