class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle:
            return 0
        
        l = len(needle)
        le = len(haystack)
        
        for i in range(le):
            if haystack[i] == needle[0] and i <= le-l:
                if haystack[i:i+l] == needle:
                    return i
                
        return -1