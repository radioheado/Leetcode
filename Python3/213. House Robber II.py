class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        def dp(nums):
            t1, t2 = 0, 0
            for n in nums:
                t1, t2 = max(n+t2, t1), t1
            return t1
        
        return max(dp(nums[:-1]), dp(nums[1:]))