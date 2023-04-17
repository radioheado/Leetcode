class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        pre = ans = 0
        cur = 1

        for i, c in enumerate(s[1:], 1):
            if c != s[i-1]:
                ans += min(pre, cur)
                pre = cur
                cur = 1
            else:
                cur += 1

        return ans + min(pre, cur)