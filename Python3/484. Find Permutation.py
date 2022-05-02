class Solution:
    def findPermutation(self, s: str) -> List[int]:
        n = len(s)+1
        stack = deque()
        ans = []
        
        for i in range(1, n):
            if s[i-1] == 'I':
                stack.append(i)
                while stack:
                    ans.append(stack.pop())
            else:
                stack.append(i)
            
        stack.append(n)
        while stack:
            ans.append(stack.pop())
            
        return ans