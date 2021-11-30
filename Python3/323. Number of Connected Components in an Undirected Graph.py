class DSU:
    def __init__(self, size):
        self.root = [i for i in range(size)]
        self.rank = [1]*size
        self.count = size
        
    def find(self, x):
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        
        # different roots, merge the two nodes
        # this means we find another component
        if x != y:
            self.count -= 1
            if self.rank[x] < self.rank[y]:
                self.root[x] = y
            elif self.rank[x] > self.rank[y]:
                self.root[y] = x
            else:
                self.root[x] = y
                self.rank[y] += 1
                
    def components(self):
        return self.count


class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        dsu = DSU(n)
        for edge in edges:
            dsu.union(edge[0], edge[1])
            
        return dsu.components()