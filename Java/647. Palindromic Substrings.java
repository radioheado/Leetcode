class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];
        
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                /* case 1: one char */
                if (i == j) dp[i][j] = true;
                
                /* case 2: two identical chars */
                else if (j-i == 1)  dp[i][j] = s.charAt(i) == s.charAt(j);
                
                /* case 3: a palindrome with surrounding two identical chars */
                else    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                
                if (dp[i][j] == true)  ans++;
            }
        }
        
        return ans;
    }
}