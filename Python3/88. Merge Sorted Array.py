class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i, j = m-1, n-1
        
        for k in range(m+n-1, -1, -1):
            if i >= 0 and j >= 0:
                if nums1[i] >= nums2[j]:
                    nums1[k] = nums1[i]
                    i -= 1
                else:
                    nums1[k] = nums2[j]
                    j -= 1
            
            # be careful of the case that nums2 has not been added to nums1 completely
            # which means there are elements in nums2 that are smaller than the first element in nums1
            # thus, j remains larger than 0
            # we don't need to do this for nums1 when i >= 0
            # that's because those elements are already in nums1
            elif j >= 0:
                nums1[k] = nums2[j]
                j -= 1