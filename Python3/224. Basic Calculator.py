class Solution:
    def calculate(self, s: str) -> int:
        # a helper function
        def cal(last, result, cur, operand):
            if operand == '+':
                result += last
                last = cur
            elif operand == '-':
                result += last
                last = -cur
            return last, result
        
        # save the previous results
        pres = deque([0])
        # save the current numbers
        nums = deque([0])
        ops = deque(['+'])
        cur = 0
        op = '+'
        
        for i, c in enumerate(s):
            # get a number
            if c.isdigit():
                cur = cur*10 + int(c)
            
            if c in '+-' or i == len(s)-1:
                pres[-1], nums[-1] = cal(pres[-1], nums[-1], cur, op)
                cur = 0
                op = c
                
            if c == '(':
                pres.append(0)
                nums.append(cur)
                ops.append(op)
                cur = 0
                op = '+'
                
            elif c == ')':
                pres[-1], nums[-1] = cal(pres[-1], nums[-1], cur, op)
                nums[-1] += pres[-1]
                
                # pop out the final result of the parentheses 
                pres.pop()
                cur, op = nums.pop(), ops.pop()
                pres[-1], nums[-1] = cal(pres[-1], nums[-1], cur, op)
                cur = 0
                
                # refresh the operand
                op = ''
        
        return nums[-1] + pres[-1]