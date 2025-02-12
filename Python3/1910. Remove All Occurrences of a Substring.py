class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        p = len(part)
        while part in s:
            i = s.find(part)
            s = s[:i] + s[i + p:]
        return s