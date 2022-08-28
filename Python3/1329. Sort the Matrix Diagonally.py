class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        diagonals = defaultdict(list)
        R, C = len(mat), len(mat[0])
        
        for r in range(R):
            for c in range(C):
                diagonals[r - c].append(mat[r][c])
                
        for d in diagonals.values():
            heapq.heapify(d)
            
        for r in range(R):
            for c in range(C):
                mat[r][c] = heapq.heappop(diagonals[r - c])
                
        return mat