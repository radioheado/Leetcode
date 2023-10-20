class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps)   ;
        int[] dp = new int[arrLen];
        int[] prev = new int[arrLen];
        prev[0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            dp = new int[arrLen];
            for (int cur = arrLen - 1; cur >= 0; cur--) {
                int ans = prev[cur];
                if (cur > 0) {
                    ans = (ans + prev[cur-1]) % MOD;
                }
                if (cur < arrLen - 1) {
                    ans = (ans + prev[cur+1]) % MOD;
                }
                dp[cur] = ans;
            }
            prev = dp;
        }

        return dp[0];
    }
}