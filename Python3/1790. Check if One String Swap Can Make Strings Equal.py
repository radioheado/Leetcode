class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        pivot = -1
        
        for i, c1 in enumerate(s1):
            c2 = s2[i]
            if c1 != c2:
                if pivot == -1:
                    pivot = i
                else:
                    if s1[pivot] != c2 or s2[pivot] != c1:
                        return False
                    return s1[i+1:] == s2[i+1:]
                
        return pivot == -1