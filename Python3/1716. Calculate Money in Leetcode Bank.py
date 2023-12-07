class Solution:
    def totalMoney(self, n: int) -> int:
        weeks, days = divmod(n, 7)
        total = 0
        monday = 1

        for _ in range(weeks):
            total += (monday * 2 + 6) * 7 // 2
            monday += 1

        total += (monday * 2 + days - 1) * days // 2
        return total