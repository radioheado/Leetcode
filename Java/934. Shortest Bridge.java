class Solution {
    private Queue<int[]> q;
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        q = new LinkedList();
        int x = -1, y = -1, n = grid.length;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    x = r;
                    y = c;
                    break;
                }
            }
        }
        dfs(grid, x, y);

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z=0; z<size; z++) {
                int[] cur = q.poll();
                for (int[] d: dirs) {
                    x = cur[0] + d[0];
                    y = cur[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n) {
                        if (grid[x][y] == 1) {
                            return distance;
                        } else if (grid[x][y] == 0) {
                            grid[x][y] = -1;
                            q.offer(new int[]{x, y});
                        }
                    } 
                }
            }
            distance++;
        }
        return distance;
    }

    private void dfs(int[][] grid, int r, int c) {
        grid[r][c] = 2;
        q.offer(new int[]{r, c});
        int n = grid.length;

        for (int[] d: dirs) {
            int x = d[0] + r, y = d[1] + c;
            if (0 <= x && x < n && 0 <= y && y < n && grid[x][y] == 1) {
                dfs(grid, x, y);
            }
        }
    }
}