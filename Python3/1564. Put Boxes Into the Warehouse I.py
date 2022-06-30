class Solution:
    def maxBoxesInWarehouse(self, boxes: List[int], warehouse: List[int]) -> int:
        limit = inf
        
        for i, w in enumerate(warehouse):
            limit = min(limit, w)
            warehouse[i] = limit
            
        heapq.heapify(boxes)
        L = len(boxes)
        
        for w in reversed(warehouse):
            # current top fits in, push it to the warehouse
            if boxes and boxes[0] <= w:
                heapq.heappop(boxes)
            
        
        return L - len(boxes)