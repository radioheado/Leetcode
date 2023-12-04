class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }

        int ans = 0, px = points[0][0], py = points[0][1];
        for (int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(px - points[i][0]), Math.abs(py - points[i][1]));
            px = points[i][0];
            py = points[i][1];
        }

        return ans;
    }
}