class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # edge case
        if len(stones) == 1:
            return stones[0]
        
        stones = [-s for s in stones]
        heapq.heapify(stones)
        
        while len(stones) > 1:
            largest = heapq.heappop(stones)
            second = heapq.heappop(stones)
            
            # only push the remains if it's not 0
            if largest != second:
                heapq.heappush(stones, largest-second)
            
        return -stones[0] if stones else 0