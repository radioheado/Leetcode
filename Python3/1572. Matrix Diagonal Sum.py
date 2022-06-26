class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        N = len(mat)
        total = sum(mat[i][i] + mat[i][N-i-1] for i in range(N))
        if N%2 == 1:
            total -= mat[N//2][N//2]
            
        return total