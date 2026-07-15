class Solution {
    public int minimumCost(int[] cost) {
        int ans = 0, N = cost.length - 1;
        Arrays.sort(cost);

        for (int i = N; i >= 0; i--) {
            if ((N - i) % 3 != 2) {
                ans += cost[i];
            }
        }

        return ans;
    }
}