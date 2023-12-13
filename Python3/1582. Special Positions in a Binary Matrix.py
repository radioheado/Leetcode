class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        rows, cols = len(mat), len(mat[0])
        row_set, col_set = [0] * rows, [0] * cols

        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 1:
                    row_set[r] += 1
                    col_set[c] += 1
        
        ans = 0
        for r in range(rows):
            if row_set[r] == 1:
                for c in range(cols):
                    if mat[r][c] == 1:
                        ans += col_set[c] == 1
                        break

        return ans