class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        # edge cases
        if len(nums) < 3:
            return True
        
        # initial state
        up = down = 0
        
        for i, n in enumerate(nums[1:], 1):
            # nothing to do 
            if n == nums[i-1]:
                continue
            
            # increasing
            elif n > nums[i-1]:
                up = 1
            
            # decreasing
            else:
                down = 1
            
            if up + down > 1:
                return False
            
        return True