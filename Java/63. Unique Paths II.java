class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)    return 0;
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        obstacleGrid[0][0] = 1;
        
        for (int c=1; c<n; c++) {
            if (obstacleGrid[0][c] == 0) {
                obstacleGrid[0][c] = obstacleGrid[0][c-1];
            } else {
                obstacleGrid[0][c] = 0;
            }
        }
        
        for (int c=1; c<m; c++) {
            if (obstacleGrid[c][0] == 0) {
                obstacleGrid[c][0] = obstacleGrid[c-1][0];
            } else {
                obstacleGrid[c][0] = 0;
            }
        }
        
        for (int r=1; r<m; r++) {
            for (int c=1; c<n; c++) {
                if (obstacleGrid[r][c] != 1) {
                    obstacleGrid[r][c] = obstacleGrid[r-1][c] + obstacleGrid[r][c-1];
                } else {
                    obstacleGrid[r][c] = 0;
                }
                
            }
        }
        
        return obstacleGrid[m-1][n-1];
    }
}