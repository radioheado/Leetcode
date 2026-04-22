class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        dsu = DSU(len(source))

        for u, v in allowedSwaps:
            dsu.union(u, v)

        groups = defaultdict(Counter)

        for i, n in enumerate(source):
            groups[dsu.find(i)][n] += 1

        ans = 0
        for i, n in enumerate(target):
            root = dsu.find(i)
            if groups[root][n] > 0:
                groups[root][n] -= 1
            else:
                ans += 1

        return ans


class DSU:
    def __init__(self, n: int) -> None:
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
                self.rank[rankx] += 1