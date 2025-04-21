class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        min_diff, max_diff, cur = 0, 0, 0

        for d in differences:
            cur += d
            min_diff = min(min_diff, cur)
            max_diff = max(max_diff, cur)
            if max_diff - min_diff > upper - lower:
                return 0

        return upper - lower - (max_diff - min_diff) + 1
        