class Solution:
    def countHomogenous(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        ans = 0
        streak = 0

        for i, c in enumerate(s):
            if i == 0 or c == s[i - 1]:
                streak += 1

            else:
                streak = 1

            ans = (ans + streak) % MOD

        return ans