class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        free = [0] * n
        hold = [0] * n
        hold[0] = -prices[0]

        for i, p in enumerate(prices[1:], 1):
            free[i] = max(free[i - 1], hold[i - 1] + p - fee)
            hold[i] = max(hold[i - 1], free[i - 1] - p)

        return free[-1]