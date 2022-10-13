class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        L = len(palindrome)
        if L == 1:
            return ''
        
        for i in range(L//2):
            if palindrome[i] != 'a':
                return palindrome[:i] + 'a' + palindrome[i+1:]
        
        return palindrome[:-1] + 'b'