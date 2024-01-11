class Solution:
    def maxScore(self, s: str) -> int:
        ones = s.count('1')
        zero = 0
        ans = 0

        for c in s[:-1]:
            if c == '0':
                zero += 1
            else:
                ones -= 1

            ans = max(ans, zero + ones)

        return ans