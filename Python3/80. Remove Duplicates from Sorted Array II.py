class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        count, dup = 1, 1
        
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                dup += 1
            else:
                dup = 1
                
            if dup <= 2:
                nums[count] = nums[i]
                count += 1
                
        return count