class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        minheap = []
        for p in points:
            heapq.heappush(minheap, (-self.distance(p), p))
            if len(minheap) > k:
                heapq.heappop(minheap)
                
        return [mh[1] for mh in minheap]
        
        
    def distance(self, p) -> int:
        x, y = p[0], p[1]
        return math.sqrt(x*x + y*y)