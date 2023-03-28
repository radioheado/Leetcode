class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int d = 0, N = days.length;
        int[] dp = new int[366];
        dp[0] = 0;

        for (int i=1; i<366; i++) {
            if (i < days[d]) {
                dp[i] = dp[i-1];
            } else {
                d++;
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
            }
            if (d >= N) {
                break;
            }
        }

        return dp[days[N-1]];
    }
}