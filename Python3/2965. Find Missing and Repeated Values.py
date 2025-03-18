class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid) * len(grid)
        total_sum = 0
        square_sum = 0

        for row in grid:
            for num in row:
                total_sum += num
                square_sum += num * num

        sum_diff = total_sum - n * (n + 1) // 2
        sqr_diff = square_sum - n * (n + 1) * (2 * n + 1) // 6

        repeat = (sqr_diff // sum_diff + sum_diff) // 2
        missing = (sqr_diff // sum_diff - sum_diff) // 2

        return [repeat, missing]