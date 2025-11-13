class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        stack = [0]

        for n in nums:
            while stack and stack[-1] > n:
                stack.pop()

            if not stack or stack[-1] < n:
                if n > 0:
                    ans += 1
                stack.append(n)

        return ans