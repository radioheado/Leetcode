# Two-pass with finding pivot first 
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1:
            return 0 if nums[0] == target else -1
        
        
        pivot = self.findPivot(nums)
        if pivot == 0:
            left, right = 0, len(nums)-1
            
        elif target >= nums[0]:
            left, right = 0, pivot-1
            
        else:
            left, right = pivot, len(nums)-1
        
        while left <= right:
            mid = (right-left)//2+left
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
                
        return -1
    
    
    def findPivot(self, nums):
        left, right = 0, len(nums)-1
        if nums[left] < nums[right]:
            return 0
        
        while left <= right:
            pivot = (right-left)//2+left
            #print("left = %d, pivot = %d, right = %d" %(left, pivot, right))
            if nums[pivot] > nums[pivot+1]:
                return pivot+1
            
            else:
                if nums[pivot] < nums[left]:
                    right = pivot-1
                else:
                    left = pivot+1
                    
        