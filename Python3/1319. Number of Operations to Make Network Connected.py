class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        dsu = DSU(n)
        for u, v in connections:
            dsu.union(u, v)

        edges = len(connections)

        # we need at least n-1 edges to connect the n nodes
        connect_components = dsu.components() - 1

        return connect_components if edges >= n - 1 else -1

class DSU:

    def __init__(self, n: int) -> None:
        self.root = [x for x in range(n)]
        self.rank = [0] * n
        self.count = n

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, x: int, y: int) -> None:
        rootx, rooty = self.find(x), self.find(y)
        rankx, ranky = self.rank[rootx], self.rank[rooty]

        if rootx != rooty:
            if rankx > ranky:
                self.root[rooty] = rootx
            elif rankx < ranky:
                self.root[rootx] = rooty
            else:
                self.root[rooty] = rootx
                self.rank[rootx] += 1
        
            self.count -= 1

    def components(self) -> int:
        return self.count
