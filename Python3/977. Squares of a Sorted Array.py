class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        left, right = 0, len(nums)-1
        ans = [None]*len(nums)
        
        for i in range(len(nums)-1, -1, -1):
            if abs(nums[left]) < abs(nums[right]):
                ans[i] = nums[right]**2
                right -= 1
            else:
                ans[i] = nums[left]**2
                left += 1
                
        return ans
                