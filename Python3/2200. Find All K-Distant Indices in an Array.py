class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        ans = []
        pre = -1
        l = len(nums) - 1

        for i, n in enumerate(nums):
            if n == key:
                left = max(0, pre, i - k)
                right = min(l, i + k)
                ans.extend(list(range(left, right + 1, 1)))

                pre = right + 1

        return ans
