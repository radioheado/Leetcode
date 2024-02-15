class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        for i, n in enumerate(nums[1:], 1):
            nums[i] += nums[i - 1]

        for i in range(len(nums) - 1, 1, -1):
            if nums[i] - nums[i-1] < nums[i-1]:
                return nums[i]

        return -1