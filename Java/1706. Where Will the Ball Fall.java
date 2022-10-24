class Solution {
    public int[] findBall(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] ans = new int[cols];
        
        for (int col=0; col<cols; col++) {
            int curc = col;
            
            for (int r=0; r<rows; r++) {
                int nexc = curc + grid[r][curc];
                if (nexc < 0 || nexc > cols-1 || grid[r][curc] != grid[r][nexc]) {
                    ans[col] = -1;
                    break;
                }
                ans[col] = nexc;
                curc = nexc;
            }
        }
        
        return ans;
    }
}