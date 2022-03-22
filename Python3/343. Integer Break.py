class Solution:
    def integerBreak(self, n: int) -> int:
        if n == 2:
            return 1
        elif n == 3:
            return 2
        
        m, r = divmod(n, 3)
        if r == 0:
            return 3**m
        elif r == 1:
            return 3**(m-1) * 4
        else:
            return 3**m * 2