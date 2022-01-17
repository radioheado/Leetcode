class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewels = set(jewels)
        
        ans = 0
        
        for s in stones:
            if s in jewels:
                ans += 1
                
        return ans