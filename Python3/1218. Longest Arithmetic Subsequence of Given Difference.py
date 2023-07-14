class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        n = len(arr)
        dp = collections.defaultdict(int)
        ans = 1

        for i, n in enumerate(arr):
            dp[n] = max(dp.get(n - difference, 0) + 1, dp[n])
            ans = max(ans, dp[n])

        return ans