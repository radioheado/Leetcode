class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        neg = ans = 0
        min_abs = 10 ** 5 + 1

        for row in matrix:
            for num in row:
                ans += abs(num)
                if num < 0:
                    neg = (neg + 1) % 2
                min_abs = min(min_abs, abs(num))

        if neg:
            ans -= 2 * min_abs
        
        return ans
