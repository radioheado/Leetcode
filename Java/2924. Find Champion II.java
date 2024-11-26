class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] champion = new boolean[n];
        Arrays.fill(champion, true);

        for (int[] edge: edges) {
            champion[edge[1]] = false;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (champion[i] == true) {
                if (ans == -1) {
                    ans = i;
                } else {
                    return -1;
                }
            }
        }

        return ans;
    }
}