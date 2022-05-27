class Solution {
    private int m, n;
    private StringBuilder path;
    private int[][] graph;
    
    public int numDistinctIslands(int[][] grid) {
        graph = grid;
        m = grid.length;
        n = grid[0].length;
        
        Set<String> unique = new HashSet<>();
        
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                path = new StringBuilder();
                dfs(r, c, 'S');
                if (path.length() > 0) {
                    unique.add(path.toString());
                }
            }
        }
        
        return unique.size();
    }
    
    private void dfs (int r, int c, char d) {
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (graph[r][c] == 0)    return;
        
        graph[r][c] = 0;
        path.append(d);
        dfs(r+1, c, 'D');
        dfs(r-1, c, 'U');
        dfs(r, c+1, 'R');
        dfs(r, c-1, 'L');
        
        /* Note: this is a must step */
        path.append('N');
    }
}