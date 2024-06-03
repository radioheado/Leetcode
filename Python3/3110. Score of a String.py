class Solution:
    def scoreOfString(self, s: str) -> int:
        pre = ord(s[0])
        ans = 0

        for cur in s[1:]:
            ans += abs(ord(cur) - pre)
            pre = ord(cur)

        return ans