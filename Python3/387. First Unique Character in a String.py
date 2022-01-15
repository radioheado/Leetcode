class Solution:
    def firstUniqChar(self, s: str) -> int:
        chars = collections.Counter(s)
            
        index = len(s)
        # traverse the dict
        for i, c in enumerate(s):
            if chars[c] == 1:
                return i
        
        return -1