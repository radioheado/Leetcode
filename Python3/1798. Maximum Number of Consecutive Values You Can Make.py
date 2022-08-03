class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        coins.sort()
        cur = 0
        
        for n in coins:
            if n <= cur+1:
                cur += n
                
        return cur+1