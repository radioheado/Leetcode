class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for (String s: strs) {
            int[] counts = count(s);
            
            for (int z=m; z>=counts[0]; z--) {
                for (int o=n; o>=counts[1]; o--) {
                    dp[z][o] = Math.max(1 + dp[z-counts[0]][o-counts[1]], dp[z][o]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] count(String s) {
        int[] ans = new int[2];
        int n = 0;
        for (char c: s.toCharArray()) {
            ans[c-'0']++;
        }
        return ans;
    }
}