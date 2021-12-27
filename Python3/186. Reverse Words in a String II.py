class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        # reverse the whole list
        self.reverse(s, 0, len(s)-1)
        start, end = 0, 0
        while end < len(s):
            # if end is space, reverse from start to end-1
            if s[end] == ' ':
                self.reverse(s, start, end-1)
                start = end+1
            # also reverse when end reaches to the end of s    
            elif end == len(s)-1:
                self.reverse(s, start, end)
            end += 1
        
        
    def reverse(self, s, start, end):
        while start < end:
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1