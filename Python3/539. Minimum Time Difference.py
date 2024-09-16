class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        time = []
        for t in timePoints:
            h, m = t[:2], t[3:]
            time.append(int(h) * 60 + int(m))

        time.sort()
        ans = 780
        for i, t in enumerate(time[1:], 1):
            ans = min(ans, t - time[i - 1])

        return min(ans, 24 * 60 - time[-1] + time[0])

        preh, prem = time[0]
        #ans = min(ans, (curh - preh) * 60 + curm - perm)
        return ans