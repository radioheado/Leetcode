class Solution {
    public int coinChange(int[] coins, int amount) {
        /* special case */
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        Set<Integer> coin = new HashSet();
        for (int c: coins) {
            coin.add(c);
        }
        
        for (int i=1; i<=amount; i++) {
            if (coin.contains(i)) {
                dp[i] = 1;
                continue;
            }
            
            for (int c: coins) {
                if (i-c > 0 && dp[i-c] != amount+1) {
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}