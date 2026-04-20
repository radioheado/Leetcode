class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        left, right = 0, len(colors) - 1
        ans = 0

        while left < right:
            if colors[left] != colors[right]:
                ans = max(ans, right - left)
                break
            right -= 1

        left, right = 0, len(colors) - 1
        while left < right:
            if colors[left] != colors[right]:
                ans = max(ans, right - left)
                break
            left += 1

        return ans