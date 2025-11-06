class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        dsu = DSU(c)
        components = defaultdict(SortedList)
        on = set()

        for u, v in connections:
            dsu.union(u, v)

        for node in range(1, c + 1):
            root = dsu.find(node)
            components[root].add(node)
            on.add(node)

        ans = []
        for q, node in queries:
            root = dsu.find(node)
            if q == 2:
                components[root].discard(node)
                on.discard(node)
            else:
                if node in on:
                    ans.append(node)
                elif components[root]:
                    ans.append(components[root][0])
                else:
                    ans.append(-1)

        return ans


class DSU:
    def __init__(self, x: int):
        self.root = [i for i in range(x + 1)]
    
    def find(self, x: int) -> int:
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]

    def union(self, x: int, y: int) -> int:
        rx, ry = self.find(x), self.find(y)
        if rx != ry:
            self.root[rx] = ry
        return ry