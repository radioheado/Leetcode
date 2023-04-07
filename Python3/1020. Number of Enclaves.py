class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        rows, cols = len(grid), len(grid[0])

        def dfs(x: int, y: int, val: int) -> None:
            grid[x][y] = val
            for i, j in dirs:
                r, c = x+i, y+j
                if 0 <= r < rows and 0 <= c < cols and grid[r][c] == 1:
                    dfs(r, c, val)
            
        for c in range(cols):
            if grid[0][c] == 1:
                dfs(0, c, 0)
            if grid[rows-1][c] == 1:
                dfs(rows-1, c, 0)

        for r in range(rows):
            if grid[r][0] == 1:
                dfs(r, 0, 0)
            if grid[r][cols-1] == 1:
                dfs(r, cols-1, 0)
        
        ans = 0
        for r in range(1, rows - 1):
            for c in range(1, cols - 1):
                if grid[r][c] == 1:
                    dfs(r, c, 2)

        for r in grid:
            for c in r:
                if c == 2:
                    ans += 1

        return ans