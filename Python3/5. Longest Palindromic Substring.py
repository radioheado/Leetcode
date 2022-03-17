class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans = ''
        for i in range(len(s)):
            ans = max(self.checkPalindrome(s, i, i), self.checkPalindrome(s, i, i+1), ans, key = len)
        return ans
        
    
    def checkPalindrome(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return s[l+1: r]    