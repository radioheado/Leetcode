class DSU:
    def __init__(self, size):
        self.parent = [i for i in range(size)]
        self.rank = [1]*size
        self.count = size
    
    # find the root of x
    def find(self, x):
        # if x is its own root, return itself
        # else, find its root recursively
        if x == self.parent[x]:
            return x
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    # union two sets
    def union(self, x, y):
        rootx = self.find(x)
        rooty = self.find(y)
        # different roots, need to merge one to another who has larger rank
        if rootx != rooty:
            # if the roots are different, 
            self.count -= 1
            if self.rank[rootx] < self.rank[rooty]:
                self.parent[rootx] = rooty
            elif self.rank[rootx] > self.rank[rooty]:
                self.parent[rooty] = rootx
            else:
                # x and y have the same rank
                # merge x to y, and increment y's rank
                self.parent[rootx] = rooty
                self.rank[rooty] += 1
                
    # get the total number of provinces            
    def getCount(self):
        return self.count

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        length = len(isConnected)
        dsu = DSU(length)
        for i in range(length):
            for j in range(i+1, length):
                if isConnected[i][j]:
                    dsu.union(i, j)
        
        return dsu.getCount()
        
        
        
        
        