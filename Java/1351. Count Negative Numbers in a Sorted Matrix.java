class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid[0].length, ans = 0, idx = n - 1;

        for (int[] g: grid) {
            while (idx >= 0 && g[idx] < 0) {
                idx--;
            }
            ans += n - idx - 1;
        }

        return ans;
    }
}