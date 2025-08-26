class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0, longest = 0;
        for (int[] d: dimensions) {
            int diagonal = d[0] * d[0] + d[1] * d[1];
            if (diagonal > longest) {
                ans = d[0] * d[1];
                longest = diagonal;
            } else if (diagonal == longest) {
                ans = Math.max(ans, d[0] * d[1]);
            }
        }
        return ans;
    }
}