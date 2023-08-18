class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees = new int[n];
        boolean[][] exists = new boolean[n][n];

        for (int[] edge: roads) {
            int u = edge[0], v = edge[1];
            degrees[u]++;
            degrees[v]++;
            exists[u][v] = true;
            exists[v][u] = true;
        }

        int ans = 0;
        for (int u = 0; u < n - 1; u++) {
            for (int v = u + 1; v < n; v++) {
                if (exists[u][v]) {
                    ans = Math.max(ans, degrees[u] + degrees[v] - 1);
                } else {
                    ans = Math.max(ans, degrees[u] + degrees[v]);
                }
            }
        }

        return ans;
    }
}