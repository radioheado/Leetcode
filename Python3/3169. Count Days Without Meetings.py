class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: (x[0], x[1]))
        prev = 0
        ans = 0

        for s, e in meetings:
            if s > prev + 1:
                ans += s - prev - 1

            prev = max(prev, e)

        ans += days - prev
        return ans