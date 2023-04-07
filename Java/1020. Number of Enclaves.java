class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numEnclaves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int c=0; c<cols; c++) {
            if (grid[0][c] == 1) {
                dfs(grid, 0, c, 0);
            }
            if (grid[rows-1][c] == 1) {
                dfs(grid, rows-1, c, 0);
            }
        }

        for (int r=0; r<rows; r++) {
            if (grid[r][0] == 1) {
                dfs(grid, r, 0, 0);
            }
            if (grid[r][cols-1] == 1) {
                dfs(grid, r, cols-1, 0);
            }
        }

        int ans = 0;
        for (int r=1; r<rows-1; r++) {
            for (int c=1; c<cols-1; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, 2);
                }
            }
        }

        for (int r=0; r<rows-1; r++) {
            for (int c=0; c<cols-1; c++) {
                if (grid[r][c] == 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int val) {
        grid[x][y] = val;
        for (int[] d: dirs) {
            int r = x + d[0], c = y + d[1];
            if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1) {
                dfs(grid, r, c, val);
            }
        }
    }
}