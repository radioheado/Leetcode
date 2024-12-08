class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        def isValid(max_balls: int) -> bool:
            max_ops = maxOperations
            for balls in nums:
                max_ops -= ceil(balls / max_balls) - 1
            return max_ops >= 0

        l, r = 1, max(nums)
        while l < r:
            m = (r - l) // 2 + l
            # This number of balls is valid, check if there are any smaller vals
            if isValid(m):
                r = m
            # This number of balls is not valid, l must increment
            else:
                l = m + 1

        return l