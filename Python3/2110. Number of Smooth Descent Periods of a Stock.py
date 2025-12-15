class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        prev = streak = ans = 0

        for price in prices:
            if price == prev - 1:
                streak += 1
            else:
                streak = 1
            
            prev = price
            ans += streak

        return ans