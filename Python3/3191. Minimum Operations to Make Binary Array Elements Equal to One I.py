class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        N = len(nums)

        for i, n in enumerate(nums):
            if n == 0:
                if i >= N - 2:
                    return -1
                nums[i] = 1
                nums[i + 1] ^= 1
                nums[i + 2] ^= 1
                ans += 1

        return ans