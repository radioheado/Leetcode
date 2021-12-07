class Solution:
    def isValid(self, s: str) -> bool:
        valids = {')': '(',
                  ']': '[',
                  '}': '{'}
        
        stack = deque()
        
        for p in s:
            if p not in valids:
                stack.append(p)
            else:
                if not stack or stack[-1] != valids[p]:
                    return False
                stack.pop()
                
        return True if not stack else False