class Solution {
    // Class-level constants (shared by all instances)
    public static final int UNGUARDED = 0;
    public static final int GUARDED = 1;
    public static final int GUARD = 2;
    public static final int WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard: guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }

        for (int[] wall: walls) {
            grid[wall[0]][wall[1]] = WALL;
        }

        // Horizontal passes
        for (int row = 0; row < m; row++) {
            boolean is_guarded = grid[row][0] == GUARD ? true : false;
            for (int col = 1; col < n; col++) {
                is_guarded = updateCell(m, n, grid, row, col, is_guarded);
            }

            is_guarded = grid[row][n - 1] == GUARD ? true : false;
            for (int col = n - 2; col >= 0; col--) {
                is_guarded = updateCell(m, n, grid, row, col, is_guarded);
            }
        }

        // Vertical passes
        for (int col = 0; col < n; col++) {
            boolean is_guarded = grid[0][col] == GUARD ? true : false;
            for (int row = 1; row < m; row++) {
                is_guarded = updateCell(m, n, grid, row, col, is_guarded);
            }

            is_guarded = grid[m - 1][col] == GUARD ? true : false;
            for (int row = m - 2; row >= 0; row--) {
                is_guarded = updateCell(m, n, grid, row, col, is_guarded);
            }
        }

        int cells = 0;
        for (int[] row: grid) {
            for (int cell: row) {
                if (cell == UNGUARDED) {
                    cells++;
                }
            }
        }

        return cells;
    }

    private boolean updateCell(int m, int n, int[][] grid, int row, int col, boolean is_guarded) {
        if (grid[row][col] == GUARD) {
            return true;
        }

        if (grid[row][col] == WALL) {
            return false;
        }

        if (is_guarded) {
            grid[row][col] = GUARDED;
        }
        return is_guarded;
    }
}