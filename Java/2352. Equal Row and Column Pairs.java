class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap();
        for (int[] row: grid) {
            StringBuilder sb = new StringBuilder();
            for (int r: row) {
                sb.append(String.valueOf(r) + ",");
            }
            rows.put(sb.toString(), rows.getOrDefault(sb.toString(), 0) + 1);
        }

        int ans = 0;
        for (int c = 0; c < grid[0].length; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < grid.length; r++) {
                sb.append(String.valueOf(grid[r][c]) + ",");
            }
            ans += rows.getOrDefault(sb.toString(), 0);
        }

        return ans;
    }
}