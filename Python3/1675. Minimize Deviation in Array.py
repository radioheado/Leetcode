class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        heap = []
        minimum, deviat = inf, inf
        
        # get the maximum numbers to the heap
        # because even number can not be bigger
        for n in nums:
            if n%2 == 0:
                n = -n
            else:
                n = -n*2
            heap.append(n)  
            minimum = min(minimum, -n)
            
        heapq.heapify(heap)
        
        while heap:
            cur = -heapq.heappop(heap)
            deviat = min(deviat, cur-minimum)
            if cur%2 == 0:
                minimum = min(minimum, cur//2)
                heapq.heappush(heap, -cur//2)
            else:
                # encounter an odd, so break
                break
                
        return deviat
        