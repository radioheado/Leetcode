class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        
        while left < right:
            mid = (right-left)//2+left
            #print("left = %d, mid = %d, right = %d" %(left, mid, right))
            # Case 1: n[mid] < n[right], the pivot resides to the left half
            #         note n[mid] is also possible for being the pivot
            if nums[mid] < nums[right]:
                right = mid
                
            # Case 2: n[mid] > n[left], the pivot resides to the right half
            #         in this case, n[mid] cannot be the pivot
            elif nums[mid] > nums[right]:
                left = mid+1
                
            # Case 3: n[mid] == n[right], we are not sure which half the pivot resides in
            #         so it's safe to move upper bound by one
            else:
                right -= 1
                
        return nums[right]