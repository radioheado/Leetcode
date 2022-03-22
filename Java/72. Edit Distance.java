class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m*n == 0) {
            return m+n;
        }
        
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int i=0; i<=n; i++) {
            dp[0][i] = i;
        }
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                int prev = Math.min(dp[i][j-1], dp[i-1][j]);
                
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], prev+1);
                } else{
                    dp[i][j] = Math.min(dp[i-1][j-1], prev) + 1;
                }
            }
        }
        
        return dp[m][n];
    }
}