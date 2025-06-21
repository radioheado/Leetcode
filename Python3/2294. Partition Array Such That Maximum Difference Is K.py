class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = 0
        pre = nums[0]

        for n in nums:
            if n - pre > k:
                ans += 1
                pre = n

        return ans + 1