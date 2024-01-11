class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        pos = [-1] * 26
        ans = -1
        a = ord('a')

        for i, c in enumerate(s):
            p = ord(c) - a
            if pos[p] == -1:
                pos[p] = i
            else:
                ans = max(ans, i - pos[p] - 1)

        return ans