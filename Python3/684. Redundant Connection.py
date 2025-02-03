class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        dsu = DSU(len(edges) + 1)

        for u, v in edges:
            if not dsu.union(u, v):
                return [u, v]

        return []


class DSU:
    def __init__(self, n: int) -> None:
        self.root = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, x: int, y: int) -> bool:
        rootx, rooty = self.find(x), self.find(y)
        if rootx == rooty:
            return False

        rankx, ranky = self.rank[rootx], self.rank[rooty]
        if rankx > ranky:
            self.root[rooty] = rootx
        elif rankx < ranky:
            self.root[rootx] = rooty
        else:
            self.root[rooty] = rootx
            self.rank[rootx] += 1

        return True