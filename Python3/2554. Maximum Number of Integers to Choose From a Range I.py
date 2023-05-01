class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        banned = set(banned)
        ans = 0

        for i in range(1, n + 1):
            if i not in banned and maxSum - i >= 0:
                ans += 1
                maxSum -= i

            if maxSum <= i:
                break
        return ans