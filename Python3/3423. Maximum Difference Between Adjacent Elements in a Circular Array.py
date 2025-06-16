class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        ans = 0
        for i, n in enumerate(nums[1:], 1):
            ans = max(ans, abs(n - nums[i - 1]))

        return max(ans, abs(nums[-1] - nums[0]))