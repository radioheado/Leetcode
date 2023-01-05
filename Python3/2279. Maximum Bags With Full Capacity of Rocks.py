class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        for i, r in enumerate(rocks):
            capacity[i] -= r

        heapq.heapify(capacity)
        ans = 0

        while additionalRocks and capacity:
            cur = capacity[0]
            if cur <= additionalRocks:
                additionalRocks -= cur 
                ans += 1
                heapq.heappop(capacity)
            else:
                break

        return ans