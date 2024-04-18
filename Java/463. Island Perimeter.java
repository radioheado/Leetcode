class Solution {
    public int islandPerimeter(int[][] grid) {
        int R = grid.length, C = grid[0].length, ans = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    ans += 4;
                    if (r > 0 && grid[r-1][c] == 1) {
                        ans -= 2;
                    }
                    if (c > 0 && grid[r][c-1] == 1) {
                        ans -= 2;
                    }
                }
            }
        }

        return ans;
    }
}