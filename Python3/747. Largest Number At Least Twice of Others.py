# onepass
class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        # run this check first, because we want to make it onepass
        if len(nums) == 1:
            return 0
        
        if nums[0] > nums[1]:
            first, second = 0, 1
        else:
            second, first = 0, 1
        
        for i in range(2, len(nums)):
            if nums[i] > nums[first]:
                second = first
                first = i
            elif nums[i] > nums[second]:
                second = i
                
        #print(first, second)        
        return first if nums[first]/2 >= nums[second] else -1
                