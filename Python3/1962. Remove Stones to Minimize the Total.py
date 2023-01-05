class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        total = sum(piles)
        piles = [-x for x in piles]
        heapq.heapify(piles)

        while k > 0 and piles:
            pile = -heapq.heappop(piles)
            k -= 1
            total -= pile // 2

            if pile % 2 == 0:
                pile //= 2
            else:
                pile = pile // 2 + 1

            # don't process 1's    
            if pile > 1:
                heapq.heappush(piles, -pile)

        return total