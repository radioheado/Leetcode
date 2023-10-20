class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        modulo = 10 ** 9 + 7

        @cache
        def dp(pos: int, step: int) -> int:
            # no more steps remaining
            if step == 0:
                # reach to the goal
                if pos == 0:
                    return 1
                return 0

            ans = dp(pos, step - 1)
            if pos > 0:
                ans = (ans + dp(pos - 1, step - 1)) % modulo

            if pos < arrLen - 1:
                ans = (ans + dp(pos + 1, step - 1)) % modulo

            return ans

        return dp(0, steps)