class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        L = len(s)
        for i in range(1, L//2 + 1):
            pattern = s[:i]
            #print(pattern, pattern* (L//(i)))
            if pattern * (L//(i)) == s:
                return True
            
        return False
        