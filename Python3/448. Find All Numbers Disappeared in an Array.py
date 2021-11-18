class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
                
        ans = []
        
        for i in range(len(nums)):
            if nums[i] > 0:
                ans.append(i+1)
                
        return ans
        