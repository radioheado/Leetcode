class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for r in range(1, len(matrix)):
            for c in range(len(matrix[0])):
                m = matrix[r][c]
                m1 = matrix[r - 1][c - 1] if c - 1 >= 0 else inf
                m2 = matrix[r - 1][c]
                m3 = matrix[r - 1][c + 1] if c + 1 < len(matrix[0]) else inf
                matrix[r][c] = min(m1, m2, m3) + m

        return min(matrix[-1])