class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        N = len(grid)
        # edge cases
        if grid[0][0] == 1 or grid[N-1][N-1] == 1:
            return -1
        
        target = (N-1, N-1)
        queue = deque([(0, 0)])
        grid[0][0] = 1
        directions = [(0,1), (0,-1), (1,0), (-1,0), (-1,-1), (-1,1), (1,-1), (1,1)]
        
        while queue:
            r, c = queue.popleft()
            # reach the target
            if (r, c) == target:
                return grid[r][c]
            
            # otherwise, search for the 8 directions
            for i, j in directions:
                x = r+i
                y = c+j
                if 0<=x<N and 0<=y<N and grid[x][y]==0:
                    grid[x][y] = grid[r][c]+1
                    queue.append((x, y))
        
        return -1
            
        