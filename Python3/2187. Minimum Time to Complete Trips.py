class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:

        def works(t: int) -> bool:
            ans = 0
            for bus in time:
                ans += t // bus
            return ans >= totalTrips

        l, r = 1, max(time) * totalTrips

        while l < r:
            m = (r - l) // 2 + l
            if works(m):
                r = m
            else:
                l = m + 1
        
        return l