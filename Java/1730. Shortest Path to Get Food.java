class Solution {
    // Possible moves: right, left, up, down
    private final int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int getFood(char[][] grid) {
        int steps = 1, rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '*') {
                    queue.add(new int[]{r, c});
                    grid[r][c] = 'X';
                }
            }
        }

        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level-- > 0) {
                int[] cur = queue.poll();
                for (int[] d: dir) {
                    int r = cur[0] + d[0], c = cur[1] + d[1];
                    if (isValid(grid, r, c)) {
                        if (grid[r][c] == '#') {
                            return steps;
                        }
                        grid[r][c] = 'X';
                        queue.add(new int[]{r, c});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] != 'X';
    }
}