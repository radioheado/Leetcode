class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        heap = []
        
        for n in nums:
            # case 1: remove all existing sequences that can no longer 
            #         take new elements
            while heap and heap[0][0] + 1 < n:
                seq = heapq.heappop(heap)
                if seq[1] < 3:
                    return False
                
            # case 2: create a new sub sequence
            if not heap or heap[0][0] == n:
                # format: [end, length]
                heapq.heappush(heap, [n, 1])
                
            # case 3: add n to an existing sequence
            else:
                seq = heapq.heappop(heap)
                seq[0] += 1
                seq[1] += 1
                heapq.heappush(heap, seq)
            #print(heap)
            
        # final check
        while heap:
            seq = heapq.heappop(heap)
            if seq[1] < 3:
                return False
            
        return True
                
                