class Solution {
    public int maxProfit(int[] prices) {
        int post_max = prices[prices.length-1];
        int profit = 0;
        
        for(int i=prices.length-2; i>=0; i--){
            profit = Math.max(profit, post_max - prices[i]);
            post_max = Math.max(post_max, prices[i]);
        }
        
        return profit;
    }
}