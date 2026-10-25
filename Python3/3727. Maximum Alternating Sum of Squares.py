class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        for i, n in enumerate(nums):
            nums[i] *= n

        nums.sort()
        N = len(nums)
        return -sum(nums[:N//2]) + sum(nums[N//2:])