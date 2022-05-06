class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        if len(s) < k:
            return s
        
        stack = deque()
        
        for c in s:
            #print(stack)
            if not stack or c != stack[-1][0]:
                stack.append(c)
                
            elif c == stack[-1][-1]:
                stack[-1] += c
                if len(stack[-1]) == k:
                    stack.pop()
            
        return ''.join(stack)
        