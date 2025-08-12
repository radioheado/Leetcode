class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        xpowers = [0]
        for i in range(1, n + 1):
            if i ** x <= n:
                xpowers.append(i ** x)
            else:
                break

        max_single = len(xpowers)
        MOD = 10 ** 9 + 7
        dp = [[0] * (n + 1) for _ in range(max_single)]
        dp[0][0] = 1

        for i in range(1, max_single):
            val = xpowers[i]
            for j in range(n + 1):
                dp[i][j] = dp[i - 1][j]
                if j >= val:
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - val]) % MOD

        return dp[-1][-1]