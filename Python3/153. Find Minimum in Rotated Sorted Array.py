class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        if nums[left] < nums[right] or right == 0:
            return nums[0]
        
        while left <= right:
            mid = (right-left)//2+left
            
            # pivot requirement
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            
            else:
                # pivot falls into the left half
                if nums[mid] < nums[left]:
                    right = mid-1
                    
                # pivot falls into the right half
                else:
                    left = mid+1
                    
        
        