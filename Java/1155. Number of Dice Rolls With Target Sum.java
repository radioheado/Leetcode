class Solution {
    private final int MOD = 1000000007;
    private Integer[][] dp;
    
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n+1][target+1];
        return helper(0, 0, n, k, target);
    }
    
    private int helper(int dice, int sum, int n, int k, int target) {
        if (dice == n) {
            return sum == target ? 1 : 0;
        }
        
        if (dp[dice][sum] != null) {
            return dp[dice][sum];
        }
        
        int ways = 0;
        for (int i=1; i<=Math.min(k, target-sum); i++) {
            ways = (ways + helper(dice+1, sum+i, n, k, target)) % MOD;
        }
        return dp[dice][sum] = ways;
    }
}