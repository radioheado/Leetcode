class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        rows, cols = len(maze), len(maze[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        visited = '#'
        
        def isValid(r, c):
            return 0 <= r < rows and 0 <= c < cols and maze[r][c] == '.'
        
        def isExit(r, c):
            if r == entrance[0] and c == entrance[1]:
                return False
            return r == 0 or r == rows - 1 or c == 0 or c == cols - 1
        
        q = deque([(entrance, 0)])
        maze[entrance[0]][entrance[1]] = visited
        
        while q:
            [r, c], steps = q.popleft() 
            if isExit(r, c):
                return steps
            
            for dr, dc in dirs:
                if isValid(r + dr, c + dc):
                    maze[r + dr][c + dc] = visited
                    q.append(([r + dr, c + dc], steps + 1))
                    
        return -1
            
        
        
        