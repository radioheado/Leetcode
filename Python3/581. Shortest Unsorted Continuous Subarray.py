class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        
        stack = deque()
        left, right = len(nums)-1, 0
        
        for i, n in enumerate(nums):
            while stack and nums[stack[-1]] > n:
                left = min(left, stack.pop())
            stack.append(i)
            
        stack.clear()
        for i in range(len(nums)-1, -1, -1):
            while stack and nums[stack[-1]] < nums[i]:
                right = max(right, stack.pop())
            stack.append(i)
            
        return right-left+1 if right > left else 0