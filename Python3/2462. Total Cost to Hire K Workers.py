class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        heap = []
        n = len(costs)

        for l in range(candidates):
            heapq.heappush(heap, (costs[l], 0))

        for r in range(max(candidates, n - candidates), n):   
            heapq.heappush(heap, (costs[r], 1))

        total = 0
        l, r = candidates, n - candidates - 1

        for _ in range(k):
            cand = heapq.heappop(heap)
            total += cand[0]
            if l > r:
                continue

            if cand[1] == 0:
                heapq.heappush(heap, (costs[l], 0))
                l += 1
            else:
                heapq.heappush(heap, (costs[r], 1))
                r -= 1
            
        return total