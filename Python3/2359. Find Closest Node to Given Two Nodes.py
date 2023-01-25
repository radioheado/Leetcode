class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        N = len(edges)
        q = deque([(node1, 0, 0), (node2, 0, 1)])
        distance = [[inf, inf] for _ in range(N)]
        visited = set()

        while q:
            node, dis, origin = q.popleft()
            distance[node][origin] = min(dis, distance[node][origin])
            
            if node in visited:
                continue
            visited.add(node)
            if edges[node] != -1:
                q.append((edges[node], dis + 1, origin))

        ans = [-1, inf]
        for i, [d1, d2] in enumerate(distance):
            if max(d1, d2) < ans[1]:
                ans = [i, max(d1, d2)]

        return ans[0]