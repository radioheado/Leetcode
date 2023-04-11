class Solution:
    def findGCD(self, nums: List[int]) -> int:
        small, large = 1001, -1001
        for n in nums:
            small = min(small, n)
            large = max(large, n)

        while small:
            large, small = small, large % small

        return large