class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        ans = 0

        for i in range(len(nums) - 2):
            one, two, three = nums[i], nums[i + 1], nums[i + 2]
            if 2 * (one + three) == two:
                ans += 1

        return ans