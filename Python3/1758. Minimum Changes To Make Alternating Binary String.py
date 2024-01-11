class Solution:
    def minOperations(self, s: str) -> int:
        n = len(s)
        s1 = '01' * (n // 2)
        if len(s1) < n:
            s1 = s1 + '0'

        s2 = '10' * (n // 2)
        if len(s2) < n:
            s2 = s2 + '1'

        a1 = a2 = 0
        for i, c in enumerate(s):
            if c != s1[i]:
                a1 += 1
            if c != s2[i]:
                a2 += 1

        return min(a1, a2)