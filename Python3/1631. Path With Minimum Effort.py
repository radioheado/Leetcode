class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        if rows == 1 and cols == 1:
            return 0
        
        edges = []
        for r in range(rows):
            for c in range(cols):
                if r > 0:
                    diff = abs(heights[r][c] - heights[r-1][c])
                    edges.append((diff, r*cols+c, (r-1)*cols+c))
                if c > 0:
                    diff = abs(heights[r][c] - heights[r][c-1])
                    edges.append((diff, r*cols+c, r*cols+c-1))
        
        edges.sort()
        dsu = DSU(rows * cols)
        
        for diff, r, c in edges:
            dsu.union(r, c)
            if dsu.connected():
                return diff
        
        return -1
        
        
class DSU:
    def __init__(self, size):
        self.root = [x for x in range(size)]
        self.rank = [0] * size
        
    def find(self, x):
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, x, y):
        rootx, rooty = self.find(x), self.find(y)
        if rootx != rooty:
            if self.rank[rootx] > self.rank[rooty]:
                self.root[rooty] = rootx
            elif self.rank[rootx] < self.rank[rooty]:
                self.root[rootx] = rooty
            else:
                self.root[rooty] = rootx
                self.rank[rootx] += 1
        
    def connected(self):
        return self.find(0) == self.find(len(self.root)-1)
                          