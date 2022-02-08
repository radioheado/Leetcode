class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        ord_diff = 0
        a = ord('a')
        
        for i in range(len(s)):
            ord_diff -= (ord(s[i]) - a)
            ord_diff += ord(t[i]) - a
            
        return chr(ord_diff+ord(t[-1]))
        