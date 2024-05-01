class Solution:
    def countPairs(self, nums1: List[int], nums2: List[int]) -> int:
        # rewrite as (nums1[i] - nums2[i]) + (nums1[j] - nums2[j]) > 0  
        N = len(nums1)
        diff = [0] * N

        for i, n1 in enumerate(nums1):
            diff[i] = n1 - nums2[i]

        diff.sort()

        l, r, ans = 0, N-1, 0
        while l < r:
            if diff[l] + diff[r] > 0:
                ans += r - l
                r -= 1
            else:
                l += 1

        return ans