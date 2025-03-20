class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:
        dsu = DSU(n)
        walks = [-1] * n

        for u, v, cost in edges:
            dsu.union(u, v)

        for u, v, cost in edges:
            walks[dsu.find(u)] &= cost

        ans = []
        for u, v in query:
            if not dsu.connected(u, v):
                ans.append(-1)
            else:
                ans.append(walks[dsu.find(u)])

        return ans

class DSU:
    def __init__(self, n: int):
        self.root = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> int:
        rootx, rooty = self.find(x), self.find(y)
        if rootx != rooty:
            rankx, ranky = self.rank[rootx], self.rank[rooty]
            if rankx > ranky:
                self.root[rooty] = rootx
            elif rankx < ranky:
                self.root[rootx] = rooty
            else:
                self.root[rooty] = rootx
                self.rank[rootx] += 1

    def connected(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)