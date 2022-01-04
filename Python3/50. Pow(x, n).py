class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # idea: pow(x, n) = (pow(x, n/2))**2
        
        
        def halfPow(x, n):
            if n == 0:
                return 1.0
            
            half = halfPow(x, n//2)
            # n is odd, need to do pow(x, n/2)*pow(x, n/2)*x
            if n%2:
                return half*half*x
            else:
                return half*half
            
        if n < 0:
            x = 1/x
            n = -n
            
        return halfPow(x, n)