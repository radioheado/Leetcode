class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        ans = 0
        for i, n1 in enumerate(nums):
            for j, n2 in enumerate(nums[i + 1:], i + 1):
                if n1 == n2 and i * j % k == 0:
                    ans += 1

        return ans