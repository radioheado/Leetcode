class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] degrees = new int[n + 2];

        for (int[] e: edges) {
            degrees[e[0]]++;
            degrees[e[1]]++;
            if (degrees[e[0]] > 1) {
                return e[0];
            }
            if (degrees[e[1]] > 1) {
                return e[1];
            }
        }

        return 0;
    }
}