class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        area = 0
                  
        def dfs(r, c, island):
            grid[r][c] = 0
            island += 1
            
            for i, j in directions:
                x = r+i
                y = c+j
                if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y] == 1:
                    island = dfs(x, y, island)
                    
            return island
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    area = max(area, dfs(row, col, 0))
                    
        return area