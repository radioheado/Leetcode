class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True

        for i, n in enumerate(nums[1:], 1):
            if n % 2 + nums[i - 1] % 2 != 1:
                return False
        
        return True