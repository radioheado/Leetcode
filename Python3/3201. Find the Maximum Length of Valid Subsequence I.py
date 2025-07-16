class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        # [all_odd, all_even, last_odd, last_even]
        dp = [nums[0] % 2, 1 - nums[0] % 2, nums[0] % 2, 1 - nums[0] % 2]

        for i, n in enumerate(nums[1:], 1):
            if n % 2:
                dp[0] += 1
                dp[2] = dp[3] + 1
            else:
                dp[1] += 1
                dp[3] = dp[2] + 1

        return max(dp)