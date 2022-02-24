class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        
        ans = 0
        left= 0
        prod = 1
        
        for i, n in enumerate(nums):
            prod *= n
            while prod >= k:
                prod /= nums[left]
                left += 1
            ans += i-left+1
        
        return ans
        