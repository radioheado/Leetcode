class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        answer = []
        n = len(graph)-1
        
        def dfs(node, path):
            if node == n:
                answer.append(list(path))
                return
                
            else:
                for v in graph[node]:
                    path.append(v)
                    dfs(v, path)
                    path.pop()
        
        dfs(0, deque([0]))
        return answer