class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        streak, left, ans = 1, 0, 0

        for i, n in enumerate(nums[1:], 1):
            if n > nums[i - 1]:
                streak += 1
            else:
                left = streak
                streak = 1

            ans = max(ans, min(left, streak), streak // 2)

        return ans