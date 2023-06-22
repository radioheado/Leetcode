class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n], hold = new int[n];
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i] - fee);
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]);
        }

        return free[n-1];
    }
}