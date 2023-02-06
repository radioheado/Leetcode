class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        rows = [''] * numRows
        backwards = True
        row = 0

        for c in s:
            rows[row] += c
            if row == 0 or row == numRows - 1:
                backwards = not backwards
            
            if backwards:
                row -= 1
            else:
                row += 1
            
        return ''.join(rows)