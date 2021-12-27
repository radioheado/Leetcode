class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        ans = 0
        
        for n in nums:
            digits = 0
            
            while n:
                # be careful of / and //
                n //= 10
                digits += 1
            
            if digits%2 == 0:
                ans += 1
                
        return ans