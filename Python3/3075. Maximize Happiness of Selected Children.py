class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        ans = 0
        for i, h in enumerate(happiness[:k]):
            if h >= i:
                ans += h - i

        return ans