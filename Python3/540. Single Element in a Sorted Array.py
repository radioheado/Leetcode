class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            m = (r - l) // 2 + l
            # m is odd
            if m % 2:
                if nums[m + 1] == nums[m]:
                    r = m - 2
                elif nums[m - 1] == nums[m]:
                    l = m + 1
                else:
                    return nums[m]
            
            else:
                if nums[m + 1] == nums[m]:
                    l = m + 2
                elif nums[m - 1] == nums[m]:
                    r = m - 1
                else:
                    return nums[m]

        return nums[l]