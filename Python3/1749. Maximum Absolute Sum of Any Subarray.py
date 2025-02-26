class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        max_ending = min_ending = 0
        ans = 0

        for n in nums:
            max_ending = max(n, max_ending + n)
            min_ending = min(n, min_ending + n)

            ans = max(ans, max_ending, abs(min_ending))

        return ans