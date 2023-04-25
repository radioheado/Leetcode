class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if 1 not in nums:
            return 1

        m = len(nums)

        for i, n in enumerate(nums):
            if n <= 0 or n > m:
                nums[i] = 1

        for n in nums:
            idx = abs(n)
            if nums[idx - 1] > 0:
                nums[idx - 1] *= -1
        
        for i, n in enumerate(nums):
            if n > 0:
                return i + 1
        
        return m + 1