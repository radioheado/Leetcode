class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        cur = prev = res = zero = 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                zero = 1
                prev = cur
                cur = 0
            else:
                cur += 1
            
            res = max(res, cur+prev+zero)
            
        return res