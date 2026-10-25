class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        smaller, occur = 0, 0
        for n in nums:
            if n < target:
                smaller += 1
            elif n == target:
                occur += 1

        return list(range(smaller, smaller + occur))