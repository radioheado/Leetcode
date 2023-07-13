class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        visited = [0] * numCourses

        for c, p in prerequisites:
            graph[p].append(c)
            
        def dfs(c: int) -> bool:
            if visited[c] == 2:
                return True
            elif visited[c] == 1:
                return False

            visited[c] = 1
            for n in graph[c]:
                if not dfs(n):
                    return False
            visited[c] = 2
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False

        return True