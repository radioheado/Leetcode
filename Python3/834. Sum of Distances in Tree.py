class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        adjs = defaultdict(list)
        for u, v in edges:
            adjs[u].append(v)
            adjs[v].append(u)

        count = [1] * n
        ans = [0] * n

        def dfs1(node = 0, parent = None) -> None:
            for child in adjs[node]:
                if child != parent:
                    dfs1(child, node)
                    count[node] += count[child]
                    ans[node] += ans[child] + count[child]

        def dfs2(node = 0, parent = None) -> None:
            for child in adjs[node]:
                if child != parent:
                    ans[child] = ans[node] - count[child] + n - count[child]
                    dfs2(child, node)

        dfs1()
        dfs2()
        return ans