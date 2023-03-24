class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # add pseudo path to make each edge bidirected
        # the pseudo paths don't impact on the counting, mark as 0
        # only increment the answer when encounter an actual reversed edge, mark as 1
        adj = collections.defaultdict(list)
        for u, v in connections:
            adj[u].append((v, 1))
            adj[v].append((u, 0))

        q = collections.deque([0])
        ans = 0
        visited = set([0])

        while q:
            node = q.popleft()
            for child, sign in adj[node]:
                if child not in visited:
                    ans += sign
                    q.append(child)
                    visited.add(child)

        return ans