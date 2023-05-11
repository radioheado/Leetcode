class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        m, n = len(nums1), len(nums2)
        dp = [0] * (n + 1)

        for i in range(1, m + 1):
            cur = [0] * (n + 1)
            for j in range(1, n + 1):
                if nums1[i-1] == nums2[j-1]:
                    cur[j] = max(dp[j-1] + 1, cur[j])
                else:
                    cur[j] = max(cur[j-1], dp[j])
            dp = cur.copy()

        return dp[n]