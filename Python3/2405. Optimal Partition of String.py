class Solution:
    def partitionString(self, s: str) -> int:
        ans, l= 0, 0
        seen = set()

        for r, c in enumerate(s):
            if c in seen:
                ans += 1
                while l < r:
                    seen.discard(s[l])
                    l += 1
            seen.add(c)

        return ans + 1