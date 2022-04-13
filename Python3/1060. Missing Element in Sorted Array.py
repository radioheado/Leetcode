class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        missing = lambda i: nums[i] - nums[0] - i
        n = len(nums)
        
        # special case: k-th missing number is larger than the last element in nums
        if k > missing(n-1):
            return nums[-1] + k - missing(n-1)
        
        left, right = 0, n-1
        while left < right:
            mid = (right-left)//2 + left
            # in the right side
            if missing(mid) < k:
                left = mid+1
            else:
                right = mid
                
        return nums[left-1] + k - missing(left-1)