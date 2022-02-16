class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 0: red, 1: white, 2: blue
        
        # sort blue first
        left, right = 0, len(nums)-1
        while left < right:
            # don't swap if right is already red
            if nums[right] == 2:
                right -= 1
                
            elif nums[left] == 2:
                nums[left], nums[right] = nums[right], nums[left]
                right -= 1
                left += 1
            else:
                left += 1
            #print(nums)
            #print(left, right)
        #print(nums)    
        if nums[right] == 2:
            right -= 1
            
        # sort white
        left = 0
        while left < right:
            if nums[right] == 1:
                right -= 1
            
            elif nums[left] == 1:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
                
            else:
                left += 1
        
                
            
                
        