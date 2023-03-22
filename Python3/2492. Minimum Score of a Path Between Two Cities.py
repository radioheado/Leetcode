class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        dsu = DSU(n)

        for u, v, p in roads:
            dsu.union(u, v, p)

        ans = inf
        for u, v, p in roads:
            if dsu.find(1) == dsu.find(u):
                ans = min(ans, p)

        return ans


class DSU:

    def __init__(self, n: int) -> None:
        self.root = [x for x in range(n+1)]
        self.rank = [0] * (n + 1)

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int, path: int) -> None:
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
    