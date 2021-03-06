class Solution {
    
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    
    public int longestIncreasingPath(int[][] matrix) {
        /* special case: empty matrix */
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        
        return ans;
    }
    
    private int dfs (int[][] matrix, int i, int j, int[][] cache) {
        /* skip dfs from this coordinate if it is already computed */
        if (cache[i][j] != 0)   return cache[i][j];
        
        for (int[] d: dir) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[i][j] < matrix[x][y]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        
        return ++cache[i][j];
    }
}