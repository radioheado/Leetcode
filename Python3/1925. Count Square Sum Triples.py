class Solution:
    def countTriples(self, n: int) -> int:
        ans = 0

        for a in range(1, n - 1):
            for b in range(a, n):
                c = sqrt(a * a + b * b)
                if c == int(c) and c <= n:
                    ans += 1
                    if a != b:
                        ans += 1

        return ans