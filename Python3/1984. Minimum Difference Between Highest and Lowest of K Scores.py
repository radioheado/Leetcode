class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        l, min_diff = 0, nums[-1] - nums[0]

        for r, num in enumerate(nums):
            if r - l + 1 == k:
                min_diff = min(min_diff, num - nums[l])
                l += 1

        return min_diff