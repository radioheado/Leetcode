class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        adjs = defaultdict(dict)
        candidates = [[0, 0]]
        
        # Add the reversed edges to the dict with doubled weights
        for u, v, w in edges:
            adjs[u][v] = min(adjs[u].get(v, inf), w)
            adjs[v][u] = min(adjs[v].get(u, inf), 2 * w)
        
        shortest = [inf] * n
        visited = [False] * n
        shortest[0] = 0

        while candidates:
            cost, u = heappop(candidates)
            if u == n - 1:
                return cost

            if visited[u]:
                continue

            visited[u] = True

            for v in adjs[u]:
                new_cost = cost + adjs[u][v]
                if new_cost < shortest[v]:
                    shortest[v] = new_cost
                    heappush(candidates, [new_cost, v])

        return -1