class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        post_max = prices[-1]
        profit = 0
        
        # calculate the local max for days after the current date
        for i in range(len(prices)-2, -1, -1):
            
            # update the profit if applicable
            profit = max(profit, post_max - prices[i])
            post_max = max(prices[i], post_max)
            
        return profit