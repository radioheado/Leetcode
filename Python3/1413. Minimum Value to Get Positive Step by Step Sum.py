class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        m = nums[0]
        i = 1
        last = nums[0]
        #print(last)
        
        while i < len(nums):
            m = min(m, nums[i]+last)
            last += nums[i]
            i += 1
            #print(m)
        
        return 1-m if m<0 else 1
        