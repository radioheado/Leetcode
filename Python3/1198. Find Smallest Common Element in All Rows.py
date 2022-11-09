class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        nums = Counter()
        for row in mat:
            for n in row:
                nums[n] += 1
                
        heap = [(n, c) for n, c in nums.items()]
        heapq.heapify(heap)
        rows = len(mat)
        
        while heap:
            n, c = heapq.heappop(heap)
            if c == rows:
                return n
            
        return -1