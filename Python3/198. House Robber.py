class Solution:
    def rob(self, nums: List[int]) -> int:
        #edge case
        if not nums:
            return 0
        
        robNext = nums[-1]
        robPlus = 0
        
        for i in range(len(nums)-2, -1, -1):
            robNext, robPlus = max(robNext, robPlus + nums[i]), robNext
        
        return robNext