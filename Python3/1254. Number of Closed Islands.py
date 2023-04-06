class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        rows, cols = len(grid), len(grid[0])

        def dfs(x: int, y: int) -> None:
            grid[x][y] = 1
            for i, j in dirs:
                r, c = x+i, y+j
                if 0 <= r < rows and 0 <= c < cols and grid[r][c] == 0:
                    dfs(r, c)
            
        for c in range(cols):
            if grid[0][c] == 0:
                dfs(0, c)
            if grid[rows-1][c] == 0:
                dfs(rows-1, c)

        for r in range(rows):
            if grid[r][0] == 0:
                dfs(r, 0)
            if grid[r][cols-1] == 0:
                dfs(r, cols-1)
        
        ans = 0
        for r in range(1, rows - 1):
            for c in range(1, cols - 1):
                if grid[r][c] == 0:
                    dfs(r, c)
                    ans += 1

        return ans