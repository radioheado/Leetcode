class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        flip = 0
        for c in s:
            if c == '0':
                flip += 1

        ans = flip
        for c in s:
            if c == '0':
                flip -= 1
                ans = min(ans, flip)
            else:
                flip += 1

        return ans