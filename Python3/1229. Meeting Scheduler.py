class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        heap = list((filter(lambda x: x[1] - x[0] >= duration, slots1 + slots2)))
        heapq.heapify(heap)
        
        while len(heap) > 1:
            s1, e1 = heapq.heappop(heap)
            s2, e2 = heap[0]
            if e1 >= s2 + duration:
                return [s2, s2 + duration]
            
        return []