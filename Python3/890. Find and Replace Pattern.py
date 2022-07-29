class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        if len(pattern) == 1:
            return words
        
        m1 = {}
        m2 = {}
        ans = []
        for w in words:
            m1.clear()
            m2.clear()
            for i, c1 in enumerate(w):
                c2 = pattern[i]
                
                if c1 not in m1 and c2 not in m2:
                    m1[c1] = c2
                    m2[c2] = c1
                    
                elif c1 not in m1 or c2 not in m2:
                    break
                    
                elif m1[c1] != c2 or m2[c2] != c1:
                    break
                    
                if i == len(w)-1:
                    ans.append(w)    
        
        return ans