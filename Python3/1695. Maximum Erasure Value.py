class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        l = s = ans = 0
        seen = set()
        
        for r, n in enumerate(nums):
            while n in seen:
                s -= nums[l]
                seen.discard(nums[l])
                l += 1
            s += n
            seen.add(n)
            ans = max(ans, s)
            
        return ans