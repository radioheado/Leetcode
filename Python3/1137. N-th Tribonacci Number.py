class Solution:
    def tribonacci(self, n: int) -> int:
        n1, n2, n3 = 0, 1, 1
        if n == 0:
            return n1
        elif n == 1 or n == 2:
            return n2
        
        for i in range(n-2):
            n1, n2, n3 = n2, n3, n1+n2+n3
            
        return n3