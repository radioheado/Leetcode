class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        
        if s[-1] == "1":
            return False
        
        far = 0
        q = deque([0])
        
        while q:
            i = q.popleft()
            start = max(i+minJump, far+1)
            for j in range(start, min((i+maxJump+1), len(s))):
                if s[j] == '0':
                    q.append(j)
                    if j == len(s)-1:
                        return True
            far = i+maxJump
            
        return False
        
       