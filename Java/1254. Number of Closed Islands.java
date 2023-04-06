class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int closedIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int c=0; c<cols; c++) {
            if (grid[0][c] == 0) {
                dfs(grid, 0, c);
            }
            if (grid[rows-1][c] == 0) {
                dfs(grid, rows-1, c);
            }
        }

        for (int r=0; r<rows; r++) {
            if (grid[r][0] == 0) {
                dfs(grid, r, 0);
            }
            if (grid[r][cols-1] == 0) {
                dfs(grid, r, cols-1);
            }
        }

        int ans = 0;
        for (int r=1; r<rows-1; r++) {
            for (int c=1; c<cols-1; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 1;
        for (int[] d: dirs) {
            int r = x + d[0], c = y + d[1];
            if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 0) {
                dfs(grid, r, c);
            }
        }
    }
}