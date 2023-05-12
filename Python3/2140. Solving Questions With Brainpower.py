class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        N = len(questions)
        dp = [0] * N
        dp[-1] = questions[-1][0]

        for i in range(N - 2, -1, -1):
            dp[i] = questions[i][0]
            skip = questions[i][1]

            if i + skip + 1 < N:
                dp[i] += dp[i + skip + 1]

            dp[i] = max(dp[i], dp[i + 1])

        return dp[0]