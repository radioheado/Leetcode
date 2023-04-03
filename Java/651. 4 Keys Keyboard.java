class Solution {
    public int maxA(int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = i;
        }

        for (int i=7; i<n+1; i++) {
            dp[i] = max(2*dp[i-3], 3*dp[i-4], 4*dp[i-5]);
        }

        return dp[n];
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}