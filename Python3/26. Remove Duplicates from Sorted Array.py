class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if len(nums) == 1 or len(nums) == 0:
            return len(nums)
        
        cur = 0
        
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                continue
            nums[cur] = nums[i]
            cur += 1
        
        nums[cur] = nums[len(nums)-1]
        
        return cur+1