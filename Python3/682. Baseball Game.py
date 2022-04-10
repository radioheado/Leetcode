class Solution:
    def calPoints(self, ops: List[str]) -> int:
        stack = deque()
        
        
        for c in ops:
            if c == 'D':
                stack.append(stack[-1] * 2)
            elif c == 'C':
                stack.pop()
            elif c == '+':
                stack.append(stack[-1] + stack[-2])
            else:
                stack.append(int(c))
                
        return sum(stack)