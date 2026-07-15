class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        if len(cost) < 3:
            return sum(cost)

        cost.sort(reverse=True)
        ans = 0

        for i, c in enumerate(cost):
            if (i + 1) % 3:
                ans += cost[i]

        return ans