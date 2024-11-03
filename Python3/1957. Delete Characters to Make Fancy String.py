class Solution:
    def makeFancyString(self, s: str) -> str:
        ans = []
        for c in s:
            if len(ans) >= 2:
                if c == ans[-1] == ans[-2]:
                    continue
            ans.append(c)

        return ''.join(ans)