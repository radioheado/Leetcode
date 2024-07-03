class Solution:
    def minDifference(self, nums: List[int]) -> int:
        # Special case
        if len(nums) <= 4:
            return 0

        # Only need to sort the smallest and largest 4 numbers
        small4 = sorted(heapq.nsmallest(4, nums))
        large4 = sorted(heapq.nlargest(4, nums))
        diff = inf

        for i in range(4):
            diff = min(diff, large4[i] - small4[i])

        return diff
