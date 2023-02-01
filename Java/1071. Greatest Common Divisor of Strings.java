class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""

        l1, l2 = len(str1), len(str2)
        if l1 < l2:
            return self.gcdOfStrings(str2, str1)

        for i in range(l2, 0, -1):
            if l1 % i or l2 % i:
                continue

            gcd = str2[:i]
            if gcd * (l1 // i) == str1 and gcd * (l2 // i) == str2:
                return gcd

        return ""