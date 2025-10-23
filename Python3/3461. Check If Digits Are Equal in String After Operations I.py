class Solution:
    def hasSameDigits(self, s: str) -> bool:
        while len(s) > 2:
            cur = ''
            for i in range(len(s) - 1):
                digit = (int(s[i]) + int(s[i + 1])) % 10
                cur += str(digit)
            s = cur
        return cur[0] == cur[1]