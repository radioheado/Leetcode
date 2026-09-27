class Solution:
    def reverseDegree(self, s: str) -> int:
        ans = 0

        for i, c in enumerate(s):
            val = (26 - ord(c) + ord('a')) * (i + 1)
            ans += val
        
        return ans