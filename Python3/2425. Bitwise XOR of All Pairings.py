class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)

        if n1 % 2 == 0 and n2 % 2 == 0:
            return 0
        elif n1 % 2 == 0:
            ans = 0
            for n in nums1:
                ans ^= n
            return ans
        elif n2 % 2 == 0:
            ans = 0
            for n in nums2:
                ans ^= n
            return ans
        else:
            ans = 0
            for n in nums2:
                ans ^= n
            for n in nums1:
                ans ^= n
            return ans