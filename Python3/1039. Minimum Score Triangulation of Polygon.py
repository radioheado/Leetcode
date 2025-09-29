class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        dp = [[0] * n for _ in range(n)]

        for length in range(2, n):      # Need at least 3 points
            for i in range(n - length):
                j = i + length
                dp[i][j] = inf
                # Try all possible third vertices k between i and j
                for k in range(i + 1, j):
                    cost = dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]
                    dp[i][j] = min(dp[i][j], cost)

        return dp[0][n - 1]