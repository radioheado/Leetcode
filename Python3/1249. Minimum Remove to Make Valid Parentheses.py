class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = deque()
        ans = [None] * len(s)
        
        for i, c in enumerate(s):
            #print(c, stack)
            # if encountering a '(', increment the balance
            if c == '(':
                stack.append(i)
                
            elif c == ')':
                # if there is no '(', continue for the remaining chars
                if not stack:
                    continue
                else:
                    # get the closed '(', and insert it to the answer
                    # also add ')'
                    index = stack.pop()
                    ans[index] = '('
                    ans[i] = c
            else:
                ans[i] = c
            
        answer = ''
        for a in ans:
            if a:
                answer += a
                
        return answer
                    