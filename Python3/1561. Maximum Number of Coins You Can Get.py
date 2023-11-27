class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        ans = 0

        while piles:
            piles.pop()
            ans += piles.pop()
            piles.pop(0)

        return ans