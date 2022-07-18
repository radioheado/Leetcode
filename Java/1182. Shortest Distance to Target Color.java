class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] dp = new int[n][3];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][colors[0]-1] = 0;
        
        // left to right
        for (int i=1; i<n; i++){
            for (int j=0; j<3; j++){
                // distance to this color is 0
                if (colors[i] == j+1)   dp[i][j] = 0;
                    
                // if this color isn't reachable from the last index,
                // it's not reachable at this step either
                else if (dp[i-1][j] == -1)  dp[i][j] = -1;
                    
                // increment the distance if itself is not this color
                else    dp[i][j] = dp[i-1][j] + 1;
            }
        }
        
        // right to left
        for (int i=n-2; i>=0; i--){
            for (int j=0; j<3; j++){
                if (dp[i][j] == -1){
                    dp[i][j] = dp[i+1][j] != -1 ? dp[i+1][j]+1 : dp[i][j];
                }
                else{
                    dp[i][j] = dp[i+1][j] != -1 ? Math.min(dp[i][j], dp[i+1][j]+1) : dp[i][j];
                }
            }
        }        
        
        List<Integer> ans = new ArrayList<>();
        int dis;
        for (int[] q: queries){
            dis = dp[q[0]][q[1]-1];
            ans.add(dis);
        }
        
        return ans;
    }
}