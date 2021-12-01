class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        # use this list to save tuples (weight, house_i, house_j)
        weighted_edges = []
        
        # add weights for making a well for a house
        # using a virtual vertex -> house0 to make a virtual edge
        for i in range(len(wells)):
            weighted_edges.append((wells[i], 0, i+1))
            
        # add the costs for laying pipes between two houses
        for x, y, weight in pipes:
            weighted_edges.append((weight, x, y))
        
        # sort according to the weights
        weighted_edges.sort(key = lambda x:x[0])
        #print(weighted_edges)
        
        dsu = DSU(n)
        costs = 0
        
        for weight, x, y in weighted_edges:
            # if the two houses are not connected, we'll add weight to the total cost
            if dsu.union(x, y):
                costs += weight
                
        return costs
        
        
class DSU:
    def __init__(self, size):
        # we'll use house 0 to 
        self.root = [i for i in range(size+1)]
        self.rank = [1]*(size+1)
        
    def find(self, x):
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        
        # a and b have the same root, which means they are already connected
        # thus, we don't need to update the cost
        if x == y:
            return False
        
        # different roots, merge the two nodes
        if self.rank[x] < self.rank[y]:
            self.root[x] = y
        elif self.rank[x] > self.rank[y]:
            self.root[y] = x
        else:
            self.root[x] = y
            self.rank[y] += 1
        return True