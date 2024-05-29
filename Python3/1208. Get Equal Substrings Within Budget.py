class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        l, cost, ans = 0, 0, 0
        for r, c in enumerate(s):
            cost += abs(ord(c) - ord(t[r]))
            while cost > maxCost:
                cost -= abs(ord(s[l]) - ord(t[l]))
                l += 1
            ans = max(r - l + 1, ans)

        return ans