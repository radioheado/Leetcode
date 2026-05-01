class Solution:
    def mirrorDistance(self, n: int) -> int:
        num = 0
        copy_n = n
        while n:
            num = num * 10 + n % 10
            n //= 10
        return abs(copy_n - num)