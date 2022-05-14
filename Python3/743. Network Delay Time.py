class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        neighbors = collections.defaultdict(list)
        for out, inn, t in times:
            neighbors[out].append((inn, t))
        
        #print(neighbors)    
        
        queue = deque()
        signal = [inf] * (n+1)
        signal[k] = 0
        ans = -1
        queue.append((k, 0))
        
        while queue:
            node, time = queue.popleft()
            
            for nei, t in neighbors[node]:
                arrival = signal[node] + t
                if signal[nei] > arrival:
                    signal[nei] = arrival
                    queue.append((nei, time+t))
            
        
        ans = max(signal[1:])
            
        return ans if ans != inf else -1
            
        
        