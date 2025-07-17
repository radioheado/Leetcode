class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        ans = 0

        for c2 in range(k):
            dp = [0] * k
            for c1 in nums:
                c1 %= k
                dp[c1] = dp[(c2 - c1) % k] + 1
                ans = max(ans, dp[c1])

        return ans