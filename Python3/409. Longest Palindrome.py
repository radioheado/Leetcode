class Solution:
    def longestPalindrome(self, s: str) -> int:
        chars = Counter(s)
        length = 0
        
        for count in chars.values():
            if count%2 == 0:
                length += count
            elif count > 1:
                length += count-1
                
        return length+1 if length<=len(s)-1 else length
        