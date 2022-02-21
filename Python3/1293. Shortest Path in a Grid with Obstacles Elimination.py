class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        directions = [(0,1), (0,-1), (1,0), (-1,0)]
        visited = set([(0, 0, k)])
        m, n = len(grid), len(grid[0])
        
        # enough k to remove obstacles in the worst case
        if k >= m+n-2:
            return m+n-2
        
        q = deque([((0, 0, k), 0)])
        
        while q:
            (x, y, k), step = q.popleft()
            #print(visited)
            # reach the target
            if x == m-1 and y == n-1:
                return step
            
            for i,j in directions:
                if (0 <= x+i < m) and (0 <= y+j < n):
                    newk = k - grid[x+i][y+j]
                
                    if newk >= 0 and (x+i, y+j, newk) not in visited:
                        visited.add((x+i, y+j, newk))
                        q.append(((x+i, y+j, newk), step+1))
                    
        return -1
        
            