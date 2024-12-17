class Solution:
    def maximumLengthOfRanges(self, nums: List[int]) -> List[int]:
        stack = deque()
        N = len(nums)
        left = [0] * N
        right = [0] * N

        for i, n in enumerate(nums):
            while stack and nums[stack[-1]] < n:
                stack.pop()
            
            left[i] = -1 if not stack else stack[-1] 
            stack.append(i)

        stack = deque()
        for i in range(N - 1, -1, -1):
            while stack and nums[stack[-1]] < nums[i]:
                stack.pop()
            
            right[i] = N if not stack else stack[-1]
            stack.append(i)

        ans = [0] * N
        for i in range(N):
            ans[i] = right[i] - left[i] - 1

        return ans