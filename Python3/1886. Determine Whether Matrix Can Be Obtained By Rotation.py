class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        for _ in range(4):
            self.transpose(mat)
            self.reflect(mat)
            if mat == target:
                return True
        
        return False
        
        
    def transpose(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for i in range(n):
            for j in range(i+1, n):
                matrix[j][i], matrix[i][j] = matrix[i][j], matrix[j][i]
                
    def reflect(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for i in range(n):
            for j in range(n//2):
                matrix[i][j], matrix[i][-j-1] = matrix[i][-j-1], matrix[i][j]
        