class Solution {
    private static final int[][] directions = 
        new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N-1][N-1] == 1) {
            return -1;
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        grid[0][0] = 1;
        q.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N-1 && cur[1] == N-1) {
                return grid[cur[0]][cur[1]];
            }
            for (int[] d: directions) {
                int r = cur[0]+d[0];
                int c = cur[1]+d[1];
                if (isValid(grid, r, c)) {
                    q.add(new int[] {r, c});
                    grid[r][c] = grid[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }
    
    private boolean isValid (int[][] grid, int r, int c) {
        int n = grid.length;
        return ((r >= 0) && (r < n) && (c >= 0) && (c < n) && grid[r][c] == 0);
    }
}