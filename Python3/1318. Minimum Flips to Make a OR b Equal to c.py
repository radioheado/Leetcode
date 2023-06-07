class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        ans = 0

        while a or b or c:
            abit = a & 1
            bbit = b & 1
            cbit = c & 1

            if cbit == 0:
                ans += abit + bbit
            else:
                ans += (abit == 0 and bbit == 0)

            a >>= 1
            b >>= 1
            c >>= 1

        return ans