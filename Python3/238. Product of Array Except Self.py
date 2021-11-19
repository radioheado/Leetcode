class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = [1]*len(nums)
        
        for i in range(1, len(nums)):
            answer[i] = answer[i-1]*nums[i-1]
            
        R = 1
        for i in reversed(range(len(nums))):
            answer[i] *= R
            R *= nums[i]
            
        return answer
        