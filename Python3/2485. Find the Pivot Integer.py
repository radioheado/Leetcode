class Solution:
    def pivotInteger(self, n: int) -> int:
        left = (1 + n) * n // 2
        right = 0

        for cur in range(n, -1, -1):
            right += cur
            left -= cur

            if left + cur == right:
                return cur

        return -1