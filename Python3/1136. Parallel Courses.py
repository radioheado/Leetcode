class Solution:
    def minimumSemesters(self, n: int, relations: List[List[int]]) -> int:
        indegrees = [0] * n
        adj = collections.defaultdict(list)
        
        # record the adjacency info
        for pre, cur in relations:
            indegrees[cur-1] += 1
            adj[pre].append(cur)
            
        q = deque()
        visited = set()
        
        # add the start nodes
        for node in range(n):
            if indegrees[node] == 0:
                q.append(node+1)
        
        ans = studied = 0
        while q:
            size = len(q)
            ans += 1
            
            for _ in range(size):
                studied += 1
                for nei in adj[q.popleft()]:
                    indegrees[nei-1] -= 1
                    
                    # all pres are learnt
                    if indegrees[nei-1] == 0:
                        q.append(nei)
                
        return ans if studied == n else -1
        