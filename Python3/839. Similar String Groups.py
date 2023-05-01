class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        N = len(strs)
        dsu = DSU(N)

        def similar(s: str, t: str) -> bool:
            diff = 0
            for c1, c2 in zip(s, t):
                if c1 != c2:
                    diff += 1
            return diff == 0 or diff == 2

        for i in range(N-1):
            s = strs[i]
            for j in range(i+1, N):
                t = strs[j]
                if similar(s, t):
                    dsu.union(i, j)

        return dsu.comps()
  
class DSU:
    def __init__(self, n: int) -> None:
        self.root = [x for x in range(n)]
        self.rank = [0] * n
        self.comp = n

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> None:
        rootx, rooty = self.find(x), self.find(y)
        rankx, ranky = self.rank[rootx], self.rank[rooty]
        if rootx != rooty:
            self.comp -= 1
            if rankx > ranky:
                self.root[rooty] = rootx
            elif rankx < ranky:
                self.root[rootx] = rooty
            else:
                self.root[rooty] = rootx
                self.rank[rankx] += 1

    def comps(self) -> int:
        return self.comp