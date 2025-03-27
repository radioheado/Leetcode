class Solution:
    def minimumDistance(self, n: int, edges: List[List[int]], s: int, marked: List[int]) -> int:
        graph = defaultdict(list)
        marked = set(marked)
        for u, v, cost in edges:
            graph[u].append((v, cost))

        distance = {s: 0}
        queue = [(0, s)]

        while queue:
            cost, node = heappop(queue)
            if node in marked:
                return distance[node]

            for child, edge in graph[node]:
                new_dis = cost + edge
                if new_dis < distance.get(child, inf):
                    heappush(queue, (edge + cost, child))
                    distance[child] = new_dis

        return -1