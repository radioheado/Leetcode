class Solution:
    def minimumPushes(self, word: str) -> int:
        ans, L, base = 0, len(word), 1
        while L > 0:
            ans += base * min(L, 8)
            L -= 8
            base += 1

        return ans