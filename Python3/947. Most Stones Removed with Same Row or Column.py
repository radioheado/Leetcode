class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        K = 10001
        adj = [[] for _ in range(2 * K + 1)]
        
        # update the adjacency info
        for r, c in stones:
            adj[r].append(c + K)
            adj[c + K].append(r)
            
        ans = 0
        visited = [0] * (2 * K + 1)
        
        
        def dfs(stone):
            visited[stone] = 1
            for a in adj[stone]:
                if visited[a] == 0:
                    dfs(a)
            
        
        for i in range(2 * K + 1):
            # if the stone is not visited and has adjacents
            if visited[i] == 0 and adj[i]:
                ans += 1
                dfs(i)
                
                
        return len(stones) - ans