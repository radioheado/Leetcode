class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        cur = 0
        for n in nums:
            cur ^= n
        
        ans = 0
        while k or cur:
            if k % 2 != cur % 2:
                ans += 1
            
            k //= 2
            cur //= 2

        return ans