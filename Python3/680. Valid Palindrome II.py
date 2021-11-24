class Solution:
    def validPalindrome(self, s: str) -> bool:
        if s == s[::-1]:
            return True
        
        for i in range(len(s)//2):
            if s[i] != s[len(s)-i-1]:
                temp1 = s[:i]+s[i+1:]
                temp2 = s[:len(s)-i-1]+s[len(s)-i:]
                return temp1==temp1[::-1] or temp2==temp2[::-1]
            