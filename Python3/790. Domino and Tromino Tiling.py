class Solution:
    def numTilings(self, n: int) -> int:
        MODULO = 10 ** 9 + 7
        if n <= 2:
            return n

        # f(k) = f(k - 1) + f(k - 2) + 2 * p(k - 1)
        # p(k) = p(k - 1) + f(k - 2)
        f1, f2 = 2, 1
        p1 = 1
        for k in range(3, n + 1):
            cur = f1
            f1 = (f1 + f2 + 2 * p1) % MODULO
            p1 = (p1 + f2) % MODULO
            f2 = cur
            
        return f1