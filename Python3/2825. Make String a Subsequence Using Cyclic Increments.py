class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        if len(str1) < len(str2):
            return False

        a = ord('a')

        i1 = i2 = 0
        while i1 < len(str1) and i2 < len(str2):
            c1, c2 = str1[i1], str2[i2]
            if c1 == c2 or (ord(c1) + 1 - a) % 26 == ord(c2) - a:
                i2 += 1
            i1 += 1

        return i2 == len(str2)