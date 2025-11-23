class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = [0, -inf, -inf]

        for n in nums:
            g = dp[:]
            for i in range(3):
                j = (i + n % 3) % 3
                g[j] = max(g[j], dp[i] + n)
            dp = g

        return dp[0]