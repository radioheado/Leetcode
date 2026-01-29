class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        graph = defaultdict(dict)
        a = ord('a')

        for s, t, c in zip(original, changed, cost):
            graph[s][t] = min(c, graph[s].get(t, inf))

        shortest = [[inf] * 26 for _ in range(26)]
        for start in range(26):
            shortest[start][start] = 0
            heap = [(0, start)]
            visited = [False] * 26

            while heap:
                path_cost, node = heappop(heap)
                if visited[node]:
                    continue

                visited[node] = True
                node_char = chr(node + a)

                for c in graph[node_char]:
                    child = ord(c) - a
                    total_cost = path_cost + graph[node_char][c]
                    if total_cost < shortest[start][child]:
                        shortest[start][child] = total_cost
                        heappush(heap, (total_cost, child))

        ans = 0
        for start, end in zip(source, target):
            if shortest[ord(start) - a][ord(end) - a] == inf:
                return -1

            ans += shortest[ord(start) - a][ord(end) - a]
        
        return ans
