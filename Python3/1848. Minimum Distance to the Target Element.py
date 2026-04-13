class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        N = len(nums)

        for i in range(N):
            if start - i >= 0 and nums[start - i] == target:
                return i

            if start + i < N and nums[start + i] == target:
                return i

        return -1