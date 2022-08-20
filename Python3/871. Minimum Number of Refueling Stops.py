class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        L = len(stations)
        dp = [startFuel] + [0] * L
        
        for i, (loc, fuel) in enumerate(stations):
            for j in range(i, -1, -1):
                if dp[j] >= loc:
                    dp[j+1] = max(dp[j+1], dp[j] + fuel)
        
        for i, d in enumerate(dp):
            if d >= target:
                return i
            
        return -1