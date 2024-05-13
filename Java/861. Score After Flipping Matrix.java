class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, ans = 0, base = cols - 1;
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] ^= 1;
                }
            }
            ans += Math.pow(2, base);
        }

        for (int c = 1; c < cols; c++) {
            int count = 0;
            base--;
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == 1) {
                    count++;
                }
            }
            count = count > rows - count ? count : rows - count;
            ans += Math.pow(2, base) * count;
        }

        return ans;
    }
}