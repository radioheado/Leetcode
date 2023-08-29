class Solution:
    def bestClosingTime(self, customers: str) -> int:
        cur = m = ans = 0

        for i, c in enumerate(customers):
            if c == 'Y':
                cur -= 1
            else:
                cur += 1

            if cur < m:
                ans = i + 1
                m = cur

        return ans