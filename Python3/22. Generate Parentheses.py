class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        
        def backtrack(cur = [], open = 0, close = 0):
            # reach the end
            if(len(cur) == 2*n):
                ans.append(''.join(cur))
                return
            
            # enough open parentheses
            if(open < n):
                cur.append('(')
                backtrack(cur, open+1, close)
                cur.pop()
            
            # add close parentheses, but not exceed the open parentheses
            if(close < open):
                cur.append(')')
                backtrack(cur, open, close+1)
                cur.pop()
                
        backtrack()
        return ans