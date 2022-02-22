class Solution {
    public long maxPoints(int[][] points) {
        long res = Integer.MIN_VALUE;
        int m = points.length, n = points[0].length;
        
        long[] dp = new long[n];
        
        for(int r=0; r<m; r++) {
            dp[0] += points[r][0];
            
            for(int c=1; c<n; c++) {
                dp[c] = Math.max(dp[c]+points[r][c], dp[c-1]-1);
            }
            
            for(int c=n-2; c>=0; c--) {
                dp[c] = Math.max(dp[c], dp[c+1]-1);
            }
            
        }
        
        for(long d: dp) res = Math.max(res, d);
        return res;
    }
}