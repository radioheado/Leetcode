class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        zero = False
        for c in s:
            if c == '0':
                zero = True
            else:
                if zero:
                    return False

        return True