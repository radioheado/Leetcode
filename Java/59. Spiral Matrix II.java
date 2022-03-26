class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0, row = 0, col = 0;
        
        while (count <= n*n) {
            ans[row][col] = count++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);
            if (ans[r][c] != 0) {
                d = (d+1)%4;
            }
            row += dir[d][0];
            col += dir[d][1];
        }
        
        return ans;
    }
}