class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        took = min(need1, need2)
        ans = min(costBoth, cost1 + cost2) * took
        ans += min(costBoth, cost1) * (need1 - took) + min(costBoth, cost2) * (need2 - took)
        return ans
