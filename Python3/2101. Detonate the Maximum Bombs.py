class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        n = len(bombs)

        def overlap(i: int, j: int) -> List[bool]:
            x1, y1, d1 = bombs[i]
            x2, y2, d2 = bombs[j]
            dis = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
            return [dis <= d1, dis <= d2]

        def dfs(i: int, visited: set) -> int:
            visited.add(i)
            for adj in graph[i]:
                if adj not in visited:
                    dfs(adj, visited)
            return len(visited)

        graph = collections.defaultdict(list)
        

        # get the adjacency list
        for i in range(n):
            for j in range(i + 1, n):
                b1, b2 = overlap(i, j)
                if b1:
                    graph[i].append(j)
                if b2:
                    graph[j].append(i)

        ans = 0
        # start dfs on each node
        for i in range(n):
            ans = max(ans, dfs(i, set()))

        return ans