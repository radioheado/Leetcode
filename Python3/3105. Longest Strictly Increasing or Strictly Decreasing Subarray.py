class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        ans = inc = dec = 1

        for i, n in enumerate(nums[1:], 1):
            if n > nums[i - 1]:
                dec = 1
                inc += 1

            elif n < nums[i - 1]:
                inc = 1
                dec += 1

            # Identical numbers, start over
            else:
                inc = 1
                dec = 1

            ans = max(ans, inc, dec)

        return ans