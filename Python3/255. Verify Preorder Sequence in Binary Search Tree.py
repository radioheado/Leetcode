class Solution:
    def verifyPreorder(self, preorder: List[int]) -> bool:
        if len(preorder) < 3:
            return True
        
        stack = deque()
        low = -inf
        
        for n in preorder:
            if n < low:
                return False
            
            while stack and n > stack[-1]:
                low = stack.pop()
            
            stack.append(n)
            
        return True