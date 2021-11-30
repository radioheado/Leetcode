class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        logs.sort(key = lambda x:x[0])
        dsu = DSU(n)
        
        for log in logs:
            dsu.union(log[1], log[2])
            if dsu.getCount() == 1:
                return log[0]
        
        return -1
         
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
                
    def getCount(self):
        return self.count