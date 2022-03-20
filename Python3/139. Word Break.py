class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        L = len(s)
        q = deque([0])
        visited = set()
        
        while q:
            start = q.popleft()
            if start in visited:
                continue
            
            visited.add(start)
            for end in range(start, L):
                if s[start: end+1] in words:
                    #print(s[start:end+1])
                    if end == L-1:
                        return True
                    q.append(end+1)
        
        return False
        