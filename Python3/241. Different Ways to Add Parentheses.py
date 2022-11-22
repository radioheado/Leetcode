class Solution:
    def diffWaysToCompute(self, expression: str, memo = dict()) -> List[int]:
        if expression in memo:
            return memo[expression]
        
        # base case
        if expression.isdigit():
            return [int(expression)]
        
        ops = {'+': lambda x, y: x + y,
               '-': lambda x, y: x - y,
               '*': lambda x, y: x * y}
        
        res = []
        for i, c in enumerate(expression):
            if c in ops:
                left = self.diffWaysToCompute(expression[:i], memo)
                right = self.diffWaysToCompute(expression[i+1:], memo)
                
                for l in left:
                    for r in right:
                        res.append(ops[c](l, r))
                        
        memo[expression] = res
        return res