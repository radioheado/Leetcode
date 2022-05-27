class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        def dfs(row, col, drc):
            if row < 0 or col < 0 or row >= m or col >= n:
                return
            
            if not grid[row][col]:
                return
            
            grid[row][col] = 0
            path.append(drc)
            dfs(row+1, col, 'D')
            dfs(row-1, col, 'U')
            dfs(row, col+1, 'R')
            dfs(row, col-1, 'L')
            
            # Note: this is a must step to do
            path.append('N')
            
        unique = set()
        for r in range(m):
            for c in range(n):
                if grid[r][c]:
                    path = []
                    dfs(r, c, 'S')
                    if path:
                        unique.add(''.join(path))
                        
        return len(unique)                