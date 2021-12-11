class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = deque()
        visited = set()
        
        # add all the index with 0 value to queue
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j, 1))
                    visited.add((i, j))
        
        # check for valid moves
        def validMove(r, c):
            return 0<=r<m and 0<=c<n and (r, c) not in visited
        
        # make legal move directions
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        
        while q:
            r, c, d = q.popleft()
            
            # check for its four adjacencies if applicable
            for i, j in directions:
                if validMove(i+r, j+c):
                    mat[i+r][j+c] = d
                    visited.add((i+r, j+c))
                    #print(visited)
                    q.append((i+r, j+c, d+1))
                    
        return mat
                