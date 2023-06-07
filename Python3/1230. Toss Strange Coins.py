class Solution:
    def probabilityOfHeads(self, prob: List[float], target: int) -> float:
        dp = [0.0] * (target + 1)
        dp[0] = 1
        n = len(prob)

        for p in prob:
            for t in range(target, 0, -1):
                dp[t] = dp[t - 1] * p + dp[t] * (1 - p)
            dp[0] *= 1 - p

        return dp[target]