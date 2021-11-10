class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min = max = 0
        ans = 0
        
        for i in range(1, len(prices)):
            if prices[i] >= prices[i-1]:
                max = i
            else:
                if max > min:
                    ans += prices[max]-prices[min]
                min = i
                
        if max>min:
            ans += prices[max]-prices[min]
            
        return ans
                
        