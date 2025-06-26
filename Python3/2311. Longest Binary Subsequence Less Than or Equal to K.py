class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        ans = base = num = 0

        for c in reversed(s):
            if c == '0':
                ans += 1
                base += 1
            else:
                if num + 2 ** base <= k:
                    ans += 1
                    num += 2 ** base
                    base += 1

        return ans