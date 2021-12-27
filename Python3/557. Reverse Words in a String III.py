class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.split()
        res = []
        for c in s:
            res.append(self.reverse(c))
            
        return ' '.join(res)
    
    def reverse(self, s):
        start, end = 0, len(s)-1
        s = list(s)
        while start < end:
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1
        return ''.join(s)