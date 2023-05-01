class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        alice = DSU(n)
        bob = DSU(n)
        needed = 0

        # count type 3 edges first
        for t, u, v in edges:
            if t == 3:
                needed += (alice.union(u, v) + bob.union(u, v) > 0)

        for t, u, v in edges:
            if t == 1:
                needed += alice.union(u, v)
            elif t == 2:
                needed += bob.union(u, v)

        return len(edges) - needed if alice.fullyConnected() and bob.fullyConnected() else -1

class DSU:
    def __init__(self, n: int) -> None:
        self.root = [x for x in range(n + 1)]
        self.rank = [0] * (n + 1)
        self.comp = n

    def find(self, x: int) -> int:
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> int:
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
                self.rank[rootx] += 1
            return 1
        return 0

    def fullyConnected(self) -> bool:
        return self.comp == 1