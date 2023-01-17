class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        dsu = DSU()
        for c1, c2 in zip(s1, s2):
            dsu.union(c1, c2)
            
        ans = ''
        for c in baseStr:
            ans += dsu.find(c)

        return ans

class DSU:
    def __init__(self) -> None:
        self.root = {}

    def find(self, x: chr) -> chr:
        self.root.setdefault(x, x)
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: chr, y: chr) -> None:
        rootx, rooty = self.find(x), self.find(y)

        if rootx > rooty:
            self.root[rootx] = rooty
        else:
            self.root[rooty] = rootx

            