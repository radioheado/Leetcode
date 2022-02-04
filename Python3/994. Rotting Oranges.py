class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        fresh = 0
        minutes = 0
        q = deque()
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                # rotten start point
                if grid[r][c] == 2:
                    q.append((r, c, 0))
                
                # count fresh oranges
                elif grid[r][c] == 1:
                    fresh += 1
                    
        while q:
            r, c, m = q.popleft()
            minutes = max(minutes, m)
            for i, j in directions:
                x = r+i
                y = c+j
                if self.validMove(grid, x, y):
                    fresh -= 1
                    grid[x][y] = 2
                    q.append((x, y, m+1))
        
        return minutes if fresh == 0 else -1           
                
                
    def validMove(self, grid, r, c):
        return 0 <= r < len(grid) and 0 <= c < len(grid[0]) and grid[r][c] == 1
            
        
        