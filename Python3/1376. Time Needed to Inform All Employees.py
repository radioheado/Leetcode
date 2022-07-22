class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        sub = defaultdict(list)
        for i, m in enumerate(manager):
            if m != -1:
                sub[m].append(i)
            
        q = deque([(headID, 0)])
        ans = 0
        
        while q:
            p, t = q.popleft()
            time = informTime[p]
            
            # push all p's subordinates
            for m in sub[p]:
                q.append((m, t+time))
            
            ans = max(ans, t+time)
            
        return ans
        