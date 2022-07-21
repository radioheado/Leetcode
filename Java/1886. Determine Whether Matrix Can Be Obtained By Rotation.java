class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i=0; i<4; i++) {
            transpose(mat);
            reflect(mat);
            if (equal(mat, target)) {
                return true;
            } 
        }
        
        return false;
    }
    
    private boolean equal(int[][] m, int[][] t) {
        for (int r=0; r<m.length; r++) {
            for (int c=0; c<t.length; c++) {
                if (m[r][c] != t[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                swap(matrix, i, j, i, n-j-1);
            }
        }
    }
    
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}