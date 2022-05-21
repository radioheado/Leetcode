class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        
        cache = [[0] * len(matrix[0]) for _ in range(len(matrix))]
        ans = 0
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                ans = max(ans, self.dfs(matrix, i, j, cache))
                
        return ans
        
        
    def dfs(self, matrix, i, j, cache):
        if cache[i][j] != 0:
            return cache[i][j]
        
        drct = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        for a, b in drct:
            x, y = i+a, j+b
            if 0 <= x < len(matrix) and 0 <= y < len(matrix[0]) and matrix[i][j] < matrix[x][y]:
                cache[i][j] = max(cache[i][j], self.dfs(matrix, x, y, cache))
        
        cache[i][j] += 1
        
        return cache[i][j]