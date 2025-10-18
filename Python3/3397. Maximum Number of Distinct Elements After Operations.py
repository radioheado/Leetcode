class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        pre = nums[0] - k
        ans = 1

        for n in nums[1:]:
            cur = min(max(pre + 1, n - k), n + k)
            if cur > pre:
                ans += 1
                pre = cur

        return ans