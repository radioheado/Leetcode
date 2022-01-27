class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        # pop two sticks from the heap
        # add them up and push the sum back to the heap
        # stop condition: len(heap) == 1
        heapq.heapify(sticks)
        cost = 0
        
        while len(sticks) > 1:
            first = heapq.heappop(sticks)
            second = heapq.heappop(sticks)
            #print("first = %d, second = %d" %(first, second))
            cost += first+second
            heapq.heappush(sticks, first+second)
        
        return cost
        