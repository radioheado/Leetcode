class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length; 
        int[][] ans = new int[n][m];
        
        for (int c=0; c<n; c++) {
            for (int r=0; r<m; r++) {
                ans[c][r] = matrix[r][c];
            }
        }
        
        return ans;
    }
}