class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        heapq.heapify(costs)
        bars = 0

        while costs and coins > 0:
            bar = heapq.heappop(costs)
            if bar <= coins:
                bars += 1
                coins -= bar
            else:
                break

        return bars