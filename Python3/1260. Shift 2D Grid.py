class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        rows, cols = len(grid), len(grid[0])
        k %= rows*cols
        if k == 0:
            return grid
        
        ans = [[0]*cols for _ in range(rows)]
        rdiff, cdiff = divmod(k, cols)
        
        for i in range(rows):
            for j in range(cols):
                xdiff, y = divmod(j+cdiff, cols)
                x = (i+rdiff+xdiff) % rows
                ans[x][y] = grid[i][j]
                
        return ans