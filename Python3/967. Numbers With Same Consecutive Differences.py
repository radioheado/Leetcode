class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        q = deque()
        for i in range(1, 10):
            q.append([i])
            
        for i in range(1, n):
            level = len(q)
            for _ in range(level):
                cur = q.popleft()
                last = cur[-1]
                if last - k >= 0:
                    q.append(cur + [last - k])
                    
                if k != 0 and last + k < 10:
                    q.append(cur + [last + k])
                    
        ans = []
        for cur in q:
            n = 0
            for c in cur:
                n = n*10 + c
                
            ans.append(n)
        
        return ans