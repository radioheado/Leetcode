class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        min_num = inf
        max_diff = -1
        for n in nums:
            if n > min_num:
                max_diff = max(max_diff, n - min_num)

            min_num = min(min_num, n)

        return max_diff