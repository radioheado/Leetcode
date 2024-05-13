class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        ans, base = 0, cols - 1

        # flip the rows so that every num in first column is 1
        for r in range(rows):
            if grid[r][0] == 0:
                for c in range(cols):
                    grid[r][c] ^= 1
            ans += 2 ** base
        
        for c in range(1, cols):
            base -= 1
            count = 0
            for r in range(rows):
                if grid[r][c] == 1:
                    count += 1

            count = count if count > rows - count else rows - count
            ans += 2 ** base * count
        
        return ans