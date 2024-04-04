class Solution:
    def maxDepth(self, s: str) -> int:
        ans = 0
        depth = 0

        for c in s:
            # a new nesting depth
            if c == '(':
                depth += 1
            elif c == ')':
                depth -= 1
                
            ans = max(ans, depth)

        return ans