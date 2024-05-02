class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        nums.sort()
        l, r = 0, len(nums) - 1

        while l < r:
            # all remaining numbers are negative or positive
            if nums[l] >= 0 or nums[r] <= 0:
                return -1
            elif abs(nums[l]) > nums[r]:
                l += 1
            elif abs(nums[l]) < nums[r]:
                r -= 1
            else:
                return nums[r]

        return -1
