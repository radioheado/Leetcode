class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int c=0; c<n; c++) {
            boolean found = true;
            for (int r=1; r<m && found; r++) {
                found = Arrays.binarySearch(mat[r], mat[0][c]) >= 0;
            }
            if (found) {
                return mat[0][c];
            }
        }
        return -1;
    }
}