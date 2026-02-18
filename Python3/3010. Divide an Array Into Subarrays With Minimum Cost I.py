class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        first = second = 51

        for n in nums[1:]:
            if n <= first:
                first, second = n, first

            elif n < second:
                second = n

        return nums[0] + first + second
