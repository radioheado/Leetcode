class Solution:
    def minProductSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        # at each step, pick the largest element in nums2,
        # and pick the smallest element in nums1
        # add their product to the result sum
        ans = 0
        nums2 = [-x for x in nums2]
        heapq.heapify(nums1)
        heapq.heapify(nums2)
        
        while nums1:
            # get the smallest num in nums1
            x = heapq.heappop(nums1)
            # get the largest num in nums2, take negative
            y = -heapq.heappop(nums2)
            
            ans += x*y
            
        return ans