class Solution {
    private final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int ans;

    public int getMaximumGold(int[][] grid) {
        ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                backtrack(grid, r, c, new HashSet<>(), 0);
            }
        }
        return ans;
    }

    private void backtrack(int[][] grid, int r, int c, Set<Pair<Integer, Integer>> visited, int gold) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
        || visited.contains(new Pair<>(r, c)) || grid[r][c] == 0) {
            return;
        }

        ans = Math.max(ans, gold + grid[r][c]);
        visited.add(new Pair<>(r, c));

        for (int[] d: dirs) {
            int x = d[0] + r, y = d[1] + c;
            backtrack(grid, x, y, visited, gold + grid[r][c]);
        }

        visited.remove(new Pair<>(r, c));
    }
}