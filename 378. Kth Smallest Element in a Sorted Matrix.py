class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        minheap = []
        for m in matrix:
            for num in m:
                minheap.append(num) 
                
        heapq.heapify(minheap)
        count = 0
        
        while count < k-1:
            heapq.heappop(minheap)
            count += 1
            
        return heapq.heappop(minheap)