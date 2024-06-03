class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        p = 0
        for i, c in enumerate(s):
            if c == t[p]:
                p += 1
                if p == len(t):
                    return 0
            
        return len(t) - p