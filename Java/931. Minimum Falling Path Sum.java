class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m1, m2, m3, m, R = matrix.length, C = matrix[0].length, ans = Integer.MAX_VALUE;
        for (int r=1; r<R; r++) {
            for (int c=0; c<C; c++) {
                m  = matrix[r][c];
                m1 = c - 1 >= 0 ? matrix[r - 1][c - 1] : Integer.MAX_VALUE;
                m2 = matrix[r - 1][c];
                m3 = c + 1 < C  ? matrix[r - 1][c + 1] : Integer.MAX_VALUE;
                matrix[r][c] = Math.min(Math.min(m1, m2), m3) + m;

                
            }
        }

        for (int c=0; c<C; c++) {
            ans = Math.min(ans, matrix[R - 1][c]);
        }
        return ans;
    }
}