class Solution:
    def leadsToDestination(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = collections.defaultdict(list)
        
        for u, v in edges:
            graph[u].append(v)
        
        seen = set()
        
        return self.dfs(source, destination, graph, seen)
    
    
    def dfs(self, node, dest, graph, seen):
        
        # found a leaf node
        if node not in graph:
            return node == dest
        
        for nei in graph[node]:
            # found a cycle
            if nei in seen:
                return False
            
            seen.add(nei)
            
            if not self.dfs(nei, dest, graph, seen):
                return False
            
            seen.remove(nei)
            
        return True
            
        