class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // Initialize 2D difference array
        int[][] diff = new int[n][n];

        for (int[] query: queries) {
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];
            
            // Add +1 at the top-left of the rectangle
            // This means: "start adding +1 from here"
            diff[r1][c1]++;

            // Place -1 just to the right of the rectangle
            // This stops horizontal propagation of the +1 beyond column c2
            if (c2 + 1 < n) {
                diff[r1][c2 + 1]--;
            }

            // Place -1 just below the rectangle
            // This stops vertical propagation of the +1 beyond row r2
            if (r2 + 1 < n) {
                diff[r2 + 1][c1]--;
            }

            // The bottom-right boundary cell receives both -1 effects
            // so we add +1 here to counteract the double subtraction.
            // This keeps the outside-bottom-right region unchanged.
            if (c2 + 1 < n && r2 + 1 < n) {
                diff[r2 + 1][c2 + 1]++;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }

        return diff;
    }
}