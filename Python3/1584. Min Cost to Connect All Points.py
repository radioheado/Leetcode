class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        dsu = DSU(len(points))
        edges = []
        
        # add all n(n-1) edges 
        for i in range(len(points)):
            x1, y1 = points[i]
            
            for j in range(i+1, len(points)):
                x2, y2 = points[j]    
                cost = abs(x1-x2) + abs(y1-y2)
                edge = Edge(i, j, cost)
                edges.append(edge)
                
        # min heap to sort the edges
        heapq.heapify(edges)
        
        costs = 0
        # only need n-1 edges
        count = len(points)-1
        
        while edges and count:
            edge = heapq.heappop(edges)
            # only add it if the two points are not connected
            if not dsu.connected(edge.point1, edge.point2):
                costs += edge.cost
                dsu.union(edge.point1, edge.point2)
                count -= 1
        
        return costs
                
        
        
# maintain the attribution of edges and add comparator rule    
class Edge:
    def __init__(self, point1, point2, cost):
        self.point1 = point1
        self.point2 = point2
        self.cost = cost
        
    def __lt__(self, other):
        return self.cost < other.cost

    
# use DSU to check connectivity between two points
class DSU:
    def __init__(self, n):
        self.root = [x for x in range(n)]
        self.rank = [0]*n
        
    def find(self, x):
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, x, y):
        rx = self.find(x)
        ry = self.find(y)
        
        if rx != ry:
            if self.rank[rx] < self.rank[ry]:
                self.root[rx] = ry
            elif self.rank[rx] > self.rank[ry]:
                self.root[ry] = rx
            else:
                self.root[rx] = ry
                self.rank[ry] += 1
        
    def connected(self, x, y):
        return self.find(x) == self.find(y)
    