class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        total = (1 + n) * n // 2
        divisible = 0

        for i in range(1, n // m + 1):
            divisible += i * m

        return total - 2 * divisible