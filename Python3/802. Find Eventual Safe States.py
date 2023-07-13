class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        status = [0] * n

        def dfs(node: int) -> bool:
            if status[node] == 1:
                return False
            elif status[node] == 2:
                return True

            status[node] = 1
            
            for child in graph[node]:
                if not dfs(child):
                    return False

            status[node] = 2
            return True

        ans = []
        for node in range(n):
            if dfs(node):
                ans.append(node)

        return ans