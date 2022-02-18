class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = deque()
        
        for n in num:
            # encounter a smaller number
            while stack and int(n) < int(stack[-1]) and k:
                stack.pop()
                k -= 1
            stack.append(n)
                
            # check leading zeros
            if len(stack) == 1 and stack[-1] == '0':
                stack.pop()
                
        while k and stack:
            stack.pop()
            k -= 1
            
        return ''.join(stack) if stack else '0'
                
            
                