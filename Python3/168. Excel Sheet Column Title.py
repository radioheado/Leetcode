class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        A = ord('A')
        ans = ''

        while columnNumber:
            rem, cur = divmod(columnNumber - 1, 26)
            ans = chr(cur + A) + ans
            columnNumber = rem

        return ans