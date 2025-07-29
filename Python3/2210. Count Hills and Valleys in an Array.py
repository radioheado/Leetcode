class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        ans, pre = 0, 0

        for i, n in enumerate(nums[1:], 1):
            if i == len(nums) - 1:
                break

            if nums[i + 1] == n:
                continue

            # normal peak or valley
            if nums[pre] < n and n > nums[i + 1] or \
               nums[pre] > n and n < nums[i + 1]:
                ans += 1
                pre = i

        return ans