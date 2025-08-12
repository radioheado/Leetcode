class Solution {
    public int numberOfWays(int n, int x) {
        List<Integer> xpowers = new ArrayList<>();
        xpowers.add(0);
        for (int i = 1; i <= n; i++) {
            int val = (int)Math.pow(i, x);
            if (val > n) {
                break;
            }
            xpowers.add(val);
        }

        int MOD = 1_000_000_007, max_single = xpowers.size();
        int[][] dp = new int[max_single][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < max_single; i++) {
            int val = xpowers.get(i);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - val]) % MOD;
                }
            }
        }

        return dp[max_single - 1][n];
    }
}