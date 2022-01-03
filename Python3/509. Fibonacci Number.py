# Recursive Solution
class Solution:
    def fib(self, n: int) -> int:
        
        if n == 0:
            return 0
        elif n == 1:
            return 1
        
        F = [-1] * (n+1)
        F[0], F[1] = 0, 1
        
        def rec(n):
            # F[n] has already been calculated
            if F[n] != -1:
                return F[n]
            
            else:
                return rec(n-1) + rec(n-2)
            
        return rec(n)