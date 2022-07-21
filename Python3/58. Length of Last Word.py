class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        for i in range(len(s)-1, -1, -1):
            if s[i] != ' ':
                l = i-1
                while l >= 0 and s[l] != ' ':
                    l -= 1
                return i - l
                    