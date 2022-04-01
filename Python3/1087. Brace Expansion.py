class Solution:
    def expand(self, s: str) -> List[str]:
        stack = deque()
        
        for c in s:
            if c == ',':
                continue
                
            # start popping chars
            elif c == '}':
                temp = []
                while stack[-1] != '{':
                    bisect.insort_left(temp, stack.pop())
                # pop the '{'
                stack.pop()
                stack.append(''.join(temp))
                
            # add "{" and normal chars to the stack
            else:
                stack.append(c)
            
        ans = []
        def backtrack(start = 0, cur = []):
            #print('start = %d, cur = %s' %(start, cur))
            if len(cur) == len(stack):
                ans.append(''.join(cur))
                return
            
            for i in range(start, len(stack)):
                now = stack[i]
                
                for c in now:
                    cur.append(c)
                    backtrack(i+1)
                    cur.pop()
        
        backtrack()
        return ans