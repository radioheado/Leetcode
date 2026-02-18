class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        if n <= 2:
            return True

        base = 2
        bit = 1
        while base < n:
            base = base * 2 + bit
            if base == n:
                return True
            bit ^= 1

        return False