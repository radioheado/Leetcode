class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        cur = sum(nums)
        ans = inf
        l = 0
        N = len(nums)
        
        for r, n in enumerate(nums):
            cur -= n
            
            while cur < x and l <= r:
                cur += nums[l]
                l += 1
                
            if cur == x:
                ans = min(ans, N-1-r+l)
                
        return ans if ans != inf else -1