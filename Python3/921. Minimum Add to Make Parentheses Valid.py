class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        stack = []
        ans = 0

        for c in s:
            if c == ')':
                if stack and stack[-1] == '(':
                    stack.pop()
                else:
                    ans += 1
            else:
                stack.append('(')

        return ans + len(stack)