class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        N = len(nums)
        stack = deque()

        for i, n in enumerate(nums):
            if not stack or nums[stack[-1]] > n:
                stack.append(i)

        ans = 0
        for r in range(N - 1, -1, -1):
            while stack and nums[stack[-1]] <= nums[r]:
                ans = max(ans, r - stack.pop())
            if ans >= r:
                break

        return ans