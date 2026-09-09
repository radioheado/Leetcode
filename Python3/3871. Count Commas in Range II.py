class Solution:
    def countCommas(self, n: int) -> int:
        bound, ans = 1000, 0
        while bound <= n:
            ans += n - bound + 1
            bound *= 1000
        return ans