class Solution:
    def maxLength(self, ribbons: List[int], k: int) -> int:
        def isValid(length: int) -> bool:
            amount = k
            for ribbon in ribbons:
                amount -= ribbon // length
                if amount <= 0:
                    return True
            return False

        l, r = 0, max(ribbons)
        while l < r:
            m = (l + r + 1) // 2
            if isValid(m):
                l = m
            else:
                r = m - 1

        return l