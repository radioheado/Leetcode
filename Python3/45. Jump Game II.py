class Solution:
    def jump(self, nums: List[int]) -> int:
        
        jump, end, farthest = 0, 0, 0
        
        for i in range(len(nums)-1):
            farthest = max(farthest, i+nums[i])
            if i == end:
                jump += 1
                end = farthest
            
        return jump
        