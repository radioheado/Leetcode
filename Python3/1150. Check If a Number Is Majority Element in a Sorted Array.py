class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        idx = bisect.bisect_left(nums, target)
        N = len(nums)
        return idx + N // 2 < N and nums[idx + N // 2] == target