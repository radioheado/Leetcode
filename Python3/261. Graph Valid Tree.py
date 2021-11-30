class DSU:
    def __init__(self, size):
        self.root = [i for i in range(size)]
        self.rank = [1]*size
        self.count = size
        
    def find(self, x):
        if x == self.root[x]:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]
        
    def union(self, a, b):
        x = self.root[a]
        y = self.root[b]
        
        if x != y:
            self.count -= 1
            if self.rank[x] < self.rank[y]:
                self.root[x] = y
            elif self.rank[x] > self.rank[y]:
                self.root[y] = x
            else:
                self.root[x] = y
                self.rank[y] += 1
    
    # if two nodes are already connected
    # adding an edge between them will introduce a cycle
    def connected(self, x, y):
        return self.find(x) == self.find(y)
    
    # if self.count == 1, it means there's only one root for all the nodes
    def singleRoot(self):
        return True if self.count == 1 else False
    

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        dsu = DSU(n)
        
        for edge in edges:
            u, v = edge[0], edge[1]
            if dsu.connected(u, v):
                return False
            
            # merge the two nodes
            dsu.union(u, v)
            
        return dsu.singleRoot()