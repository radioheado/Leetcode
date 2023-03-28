class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        d = 0
        dp = [0] * 366

        for i in range(1, 366):
            # this day is not in days
            if i < days[d]:
                dp[i] = dp[i - 1]
            else:
                d += 1
                dp[i] = min(dp[i-1] + costs[0], dp[max(0, i-7)] + costs[1], dp[max(0, i-30)] + costs[2])

            # reach to the end of the days
            if d >= len(days):
                break

        return dp[days[-1]]