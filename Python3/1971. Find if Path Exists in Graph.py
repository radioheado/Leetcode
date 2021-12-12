class Solution:
    def validPath(self, n: int, edges: List[List[int]], start: int, end: int) -> bool:
        adj = collections.defaultdict(list)
        
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        # use a queue to do dfs
        q = deque([start])    
        
        # use a set to store visited vertices
        visited = set()
        
        while q:
            cur = q.popleft()
            
            if cur == end:
                return True
            
            for a in adj[cur]:
                if a not in visited:
                    visited.add(a)
                    q.append(a)
                    
        return False