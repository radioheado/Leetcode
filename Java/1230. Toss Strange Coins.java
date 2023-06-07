class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[] dp = new double[target + 1];
        dp[0] = 1;

        for (double p: prob) {
            for (int t = target; t >= 1; t--) {
                dp[t] = dp[t - 1] * p + dp[t] * (1 - p);
            }
            dp[0] *= 1 - p;
        }

        return dp[target];
    }
}