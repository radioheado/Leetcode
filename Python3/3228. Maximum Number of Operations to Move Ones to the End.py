class Solution:
    def maxOperations(self, s: str) -> int:
        ans = streak = i = 0

        while i < len(s):
            if s[i] == '1':
                streak += 1
                i += 1
            else:
                while i < len(s) and s[i] == '0':
                    i += 1
                ans += streak

        return ans