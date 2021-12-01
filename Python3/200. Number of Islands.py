class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # only do union for grid[i][j] == 1 and one of its previous adjacency == 1
        m = len(grid)
        n = len(grid[0])
        dsu = DSU(m, n)
        count = m*n
        
        for i in range(m):
            for j in range(n):
                
                if grid[i][j] == "1":
                    #print("cur: ", [i, j])
                    if i==0 and j==0:
                        continue
                    # current node has both up and left adjacencies    
                    if i-1 >= 0 and grid[i-1][j] == "1":
                        if dsu.union((i-1)*n+j, i*n+j):
                            count -= 1
                    if j-1 >= 0 and grid[i][j-1] == "1":
                        if dsu.union(i*n+j-1, i*n+j):
                            count -= 1
                            
                else:
                    count -= 1
                            
        return count
        
class DSU:
    def __init__(self, m, n):
        # use this list to keep the island each grid belongs to
        # the format is: self.island[i*n+j] = x*n+y, where [i, j] and [x, y] are coordinates
        self.island = []
        for i in range(m):
            for j in range(n):
                self.island.append(i*n+j)
        #print(self.island)
        
        self.rank = [1]*n*m
        #print(self.rank)
        
    # [x, y] is the location of the node
    def find(self, x):
        if x != self.island[x]:
            self.island[x] = self.find(self.island[x])
        return self.island[x]
    
    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        
        # a and b have the same root, which means they are already connected
        # thus, we don't need to update the cost
        if x == y:
            return False
        
        # different roots, merge the two nodes
        if self.rank[x] < self.rank[y]:
            self.island[x] = y
        elif self.rank[x] > self.rank[y]:
            self.island[y] = x
        else:
            self.island[x] = y
            self.rank[y] += 1
        return True