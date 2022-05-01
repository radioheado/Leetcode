class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        color = {}
        for node in range(len(graph)):
            # node is not visited, color it as '0'
            if node not in color:
                stack = [node]
                color[node] = 0
                while stack:
                    node = stack.pop()
                    for nei in graph[node]:
                        if nei not in color:
                            stack.append(nei)
                            color[nei] = color[node] ^ 1
                        # node and its neighbor are in the same side, it's impossible to partition them
                        elif color[nei] == color[node]:
                            return False
                        
        return True