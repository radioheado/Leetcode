class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        m, n = len(rooms), len(rooms[0])
        
        # make legal move directions
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        
        # check for valid moves
        def validMove(r, c):
            return 0<=r<m and 0<=c<n and rooms[r][c] == (2**31-1)
        
        # first add all gates to the queue, along with the distance
        # start from distance 1
        q = deque()
        for i in range(m):
            for j in range(n):
                if rooms[i][j] == 0:
                    q.append((i, j, 1))
        
        
        while q:
            r, c, d = q.popleft()
            
            # check for its four adjacencies if applicable
            for i, j in directions:
                if validMove(i+r, j+c):
                    rooms[i+r][j+c] = d
                    q.append((i+r, j+c, d+1))
                    
        
            
            
        