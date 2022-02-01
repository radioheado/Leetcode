class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1, len2 = len(nums1), len(nums2)
        
        # make nums1 the shorter list 
        if len1 > len2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        # do binary search on nums1
        left, right = 0, len1-1
        total = len1 + len2
        half = total // 2
        
        while True:
            # candidate median index in nums1
            mid = (right-left)//2 + left
            
            # candidate median index in nums2
            # minus 2 because of mid and needs are both 0-indexed 
            needs = half - mid - 2
            
            Aleft = nums1[mid] if mid >= 0 else float('-inf')
            Aright = nums1[mid+1] if mid < len1-1 else float('inf')
            Bleft = nums2[needs] if needs >= 0 else float('-inf')
            Bright = nums2[needs+1] if needs < len2-1 else float('inf')
            
            # partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                
                # total is odd
                if total % 2:
                    return min(Aright, Bright)
                # otherwise
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            
            # too many numbers in the left partition
            elif Aleft > Bright:
                right = mid-1
                
            # too few numbers in the left partition
            else:
                left = mid+1