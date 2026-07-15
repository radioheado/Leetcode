class Solution:
    def processStr(self, s: str) -> str:
        ans = deque()

        for c in s:
            if c.isalpha():
                ans.append(c)
            elif c == '#':
                ans.extend(ans)
            elif c == '*' and ans:
                ans.pop()
            else:
                ans.reverse()

        return ''.join(ans)