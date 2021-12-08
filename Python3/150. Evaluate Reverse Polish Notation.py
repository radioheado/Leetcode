class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = deque()
        
        # keep the operands for quicker operation
        operands = {
            "+": lambda a, b: a + b,
            "-": lambda a, b: a - b,
            "/": lambda a, b: int(a/b),
            "*": lambda a, b: a * b
        }
        
        for token in tokens:
            # we must do this check first because there are negative numbers
            # in the tokens list that will not pass isdigit()
            if token in operands:    
                second = stack.pop()
                first = stack.pop()
                operand = operands[token]
                stack.append(operand(first, second))
            else:
                stack.append(int(token))
                
        return stack.pop()
            
        