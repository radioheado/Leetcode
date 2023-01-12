class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        ans = 0
        adjs = collections.defaultdict(list)

        for p, c in edges:
            adjs[p].append(c)
            adjs[c].append(p)

        def dfs(node = 0, parent = -1):
            if node not in adjs:
                return 0

            total = child = 0
            for nei in adjs[node]:
                if nei == parent:
                    continue

                child = dfs(nei, node)
                if child > 0 or hasApple[nei]:
                    total += child + 2

            return total

        return dfs()
        