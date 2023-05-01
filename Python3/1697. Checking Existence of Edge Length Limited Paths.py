class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        dsu = DSU(n)
        Q = len(queries)
        ans = [False] * Q

        # store original indices with all queries
        queries_index = [[] for _ in range(Q)]
        for i in range(Q):
            queries_index[i] = queries[i]
            queries_index[i].append(i)

        # sort all edges in increasing order of weights
        edgeList.sort(key = lambda x: x[2])
        print(edgeList)
        # sort all queries in increasing order of limits
        queries_index.sort(key = lambda x: x[2])
        print(queries_index)

        edge_index = 0

        for u, v, limit, query_index in queries_index:
            while edge_index < len(edgeList) and edgeList[edge_index][2] < limit:
                node1 = edgeList[edge_index][0]
                node2 = edgeList[edge_index][1]
                dsu.union(node1, node2)
                edge_index += 1

            ans[query_index] = dsu.connected(u, v)
        
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
                self.rank[rootx] += 1

    def connected(self, u: int, v: int) -> bool:
        return self.find(u) == self.find(v)
