class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        prefix = sum(nums[:2 * k])
        
        for i in range(2 * k, n):
            prefix += nums[i]
            ans[i - k] = prefix // (2 * k + 1)
            prefix -= nums[i - 2*k]

        return ans