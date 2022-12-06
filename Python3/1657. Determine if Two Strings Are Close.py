class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        n1, n2 = len(word1), len(word2)
        if n1 != n2:
            return False
        
        c1, c2 = [0] * 26, [0] * 26
        a = ord('a')
        
        for w in word1:
            c1[ord(w) - a] += 1
            
        for w in word2:
            c2[ord(w) - a] += 1
            
        for i, j in zip(c1, c2):
            if i == 0 and j > 0 or j == 0 and i > 0:
                return False
            
        c1.sort()
        c2.sort()
        
        return c1 == c2
    