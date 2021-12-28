class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        odd = 0
        
        for i in range(len(nums)):
            # if cur is even, swap it with the odd pointer
            if nums[i]%2 == 0:
                nums[odd], nums[i] = nums[i], nums[odd]
                odd += 1
                
        return nums        
    
            