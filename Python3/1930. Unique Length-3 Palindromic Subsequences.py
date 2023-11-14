class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        first = [-1] * 26
        last = [-1] * 26
        ans = 0

        for i, c in enumerate(s):
            j = ord(c) - ord('a')
            if first[j] == -1:
                first[j] = i
            last[j] = i

        for i in range(26):
            if first[i] == -1:
                continue

            between = set(s[first[i] + 1: last[i]])
            ans += len(between)

        return ans