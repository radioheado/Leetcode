class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, connected = 0;
        int[] cols = new int[n], last_server_col = new int[m];
        Arrays.fill(last_server_col, -1);

        for (int r = 0; r < m; r++) {
            int rows = 0;
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    rows++;
                    cols[c]++;
                    last_server_col[r] = c;
                }
            }

            if (rows != 1) {
                connected += rows;
                last_server_col[r] = -1;
            }
        }

        for (int r = 0; r < m; r++) {
            if (last_server_col[r] != -1 && cols[last_server_col[r]] > 1) {
                connected++;
            }
        }

        return connected;
    }
}