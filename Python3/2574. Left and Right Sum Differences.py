class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        prefix = []
        p = 0

        for n in nums:
            p += n
            prefix.append(p)

        L = len(nums)
        ans = [0] * L
        
        for i, n in enumerate(nums):
            left = prefix[i - 1] if i > 0 else 0
            right = prefix[L - 1] - prefix[i] if i < L - 1 else 0
            ans[i] = abs(right - left)

        return ans