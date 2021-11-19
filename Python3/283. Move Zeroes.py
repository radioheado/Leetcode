class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeros = 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                zeros += 1
            else:
                nums[i-zeros] = nums[i]
        
        while zeros:
            nums[len(nums)-zeros] = 0
            zeros -= 1
            
        
        