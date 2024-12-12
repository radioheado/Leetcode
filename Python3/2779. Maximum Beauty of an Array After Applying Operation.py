class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums.sort()

        def find(n, l):
            r = len(nums) - 1
            while l < r:
                m = (r - l) // 2 + l + 1
                if n + k * 2 >= nums[m]:
                    l = m
                else:
                    r = m - 1
            return l

        le = ans = 0
        N = len(nums)
        for i, n in enumerate(nums):
            le = find(n, le)
            ans = max(ans, le - i + 1)

        return ans