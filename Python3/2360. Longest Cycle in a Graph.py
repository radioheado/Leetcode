class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        nodes = len(edges)
        visited = set()
        ans = -1

        def dfs(node: int, dist) -> None:
            visited.add(node)
            nei = edges[node]

            # case 1: the neighbor hasn't been visited
            if nei != -1 and nei not in visited:
                dist[nei] = dist[node] + 1
                dfs(nei, dist)
            
            # case 2: the neighbor has been visited
            #         we can update answer now because reached to a cycle
            elif nei != -1 and nei in dist:
                nonlocal ans
                ans = max(ans, dist[node] - dist[nei] + 1)
            
        for n in range(nodes):
            if n not in visited:
                dist = collections.defaultdict(int)
                dist[n] = 1
                dfs(n, dist)

        return ans