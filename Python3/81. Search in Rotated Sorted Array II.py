class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums)-1
        
        while left <= right:
            mid = (right-left)//2 + left
            #print(nums[mid])
            # found
            if nums[mid] == target:
                return True
            
            # left to mid is sorted
            elif nums[mid] >= nums[left]:
                # target falls into the left half
                if nums[left] <= target <= nums[mid]:
                    right -= 1
                else:
                    left += 1
            
            # mid to right is sorted
            elif nums[mid] <= nums[right]:
                if nums[mid] <= target <= nums[right]:
                    left += 1
                else:
                    right -= 1
                    
        return False
                
                    
            