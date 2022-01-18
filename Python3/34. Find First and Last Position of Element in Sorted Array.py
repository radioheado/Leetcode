class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        
        start = self.searchStart(nums, target)
        end = self.searchEnd(nums, target)
        
        if start < len(nums) and start <= end and nums[start] == target:
            return [start, end]
        else:
            return [-1, -1]
        
        
    def searchStart(self, nums, target) -> int:
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (right-left)//2+left
            if nums[mid] >= target:
                right = mid-1
            else:
                left = mid+1
        return left
    
    def searchEnd(self, nums, target) -> int:
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (right-left)//2+left
            if nums[mid] > target:
                right = mid-1
            else:
                left = mid+1
        return right
            
        