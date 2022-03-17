class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        stack = deque([0])
        
        for c in s:
            if c == '(':
                stack.append(0)
            else:
                cur = stack.pop()
                # if current depth has only (), value is 1
                stack[-1] += max(cur*2, 1)
        
        return stack.pop()