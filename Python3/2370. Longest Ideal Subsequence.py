class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        dp = [0] * 26

        ans = 0
        for i, c in enumerate(s):
            cur = ord(c) - ord('a')
            best = 0
            for p in range(26):
                if abs(p - cur) <= k:
                    best = max(best, dp[p])

            dp[cur] = max(dp[cur], best + 1)
            ans = max(ans, dp[cur])

        return ans