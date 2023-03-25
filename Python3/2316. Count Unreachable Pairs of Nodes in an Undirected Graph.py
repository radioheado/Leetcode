class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:

        dsu = DSU(n)
        for u, v in edges:
            dsu.union(u, v)

        comps = dsu.components()
        N = len(comps)
        ans = 0

        for c in comps:
            n -= c
            ans += c * n
        
        return ans

class DSU:
    def __init__(self, n) -> None:
        self.root = [x for x in range(n)]
        self.rank = [0] * n

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

    def components(self) -> List[int]:
        comp = defaultdict(int)
        n = len(self.root)
        for x in range(n):
            comp[self.find(x)] += 1
        return list(comp.values())