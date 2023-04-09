class Solution:
    def anagramMappings(self, nums1: List[int], nums2: List[int]) -> List[int]:
        idx = {}
        for i, n in enumerate(nums2):
            idx[n] = i

        for i, n in enumerate(nums1):
            nums1[i] = idx[n]

        return nums1