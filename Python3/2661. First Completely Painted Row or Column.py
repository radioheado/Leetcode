class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        positions = {}
        rows, cols = len(mat), len(mat[0])
        row_count, col_count = [cols] * rows, [rows] * cols

        for r in range(rows):
            for c in range(cols):
                positions[mat[r][c]] = (r, c)

        for i, n in enumerate(arr):
            r, c = positions[n]
            row_count[r] -= 1
            col_count[c] -= 1
            if row_count[r] == 0 or col_count[c] == 0:
                return i

        return -1