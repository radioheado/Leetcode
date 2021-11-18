class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        len1 = len(s)
        len2 = len(t)
        
        if len1 > len2:
            return self.isOneEditDistance(t, s)
        
        for i in range(len1):
            if s[i] != t[i]:
                if len1==len2:
                    return s[i+1:]==t[i+1:]
                else:
                    return s[i:]==t[i+1:]
                
        return len1+1==len2
                