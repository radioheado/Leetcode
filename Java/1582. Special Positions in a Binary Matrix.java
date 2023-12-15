class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] row_count = new int[rows], col_count = new int[cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    row_count[r]++;
                    col_count[c]++;
                }
            }
        }

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            if (row_count[r] == 1) {
                for (int c = 0; c < cols; c++) {
                    if (mat[r][c] == 1 && col_count[c] == 1) {
                        ans++;
                        break;
                    }
                }
            }
        } 
        return ans;
    }
}