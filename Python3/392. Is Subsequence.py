class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        # special case
        if len(s) > len(t):
            return False
        
        # edge case
        if not s:
            return True
        
        p1 = 0
        
        for c in t:
            if c == s[p1]:
                p1 += 1
                
            if p1 == len(s):
                return True
            
        return p1 == len(s)    