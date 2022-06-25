class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        # base case
        if len(nums) < 3:
            return True
        
        flag = True
        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                if not flag:
                    return False
                flag = False
                
                if i < 1 or nums[i-1] <= nums[i+1]:
                    nums[i] = nums[i+1]
                else:
                    nums[i+1] = nums[i]
            #print(nums)
        
        return True