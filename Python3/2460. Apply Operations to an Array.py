class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        for i, n in enumerate(nums[1:], 1):
            if n == nums[i - 1]:
                nums[i - 1] *= 2
                nums[i] = 0

            
        for cur, n in enumerate(nums):
            if n == 0:
                nxt_p = cur + 1
                while nxt_p < len(nums) and nums[nxt_p] == 0:
                    nxt_p += 1
                
                if nxt_p < len(nums):
                    nums[cur] = nums[nxt_p]
                    nums[nxt_p] = 0
        
        return nums