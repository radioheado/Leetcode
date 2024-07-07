class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        if time < n:
            return time + 1

        m = time % (2 * n - 2)
        if m >= n:
            m -= n - 1
            return n - m
        else:
            return m + 1
