class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int) -> int:
        # keep track of (cur_house, cur_neighbor, prev_color)
        @cache
        def dp(h, n, c):
            # termination condition:
            #   1. current neighbors exceed target
            #   2. reach to the last house but not enough neighbors
            if n > target or (h == m and n != target):
                return inf
            
            # satisfied condition: 
            #   reach to the last house with enough neighbors
            if h == m:
                return 0
            
            # current house is painted, check if it has the same color
            if houses[h] != 0:
                return dp(h+1, n + (c != houses[h]), houses[h])
            
            # current house is not painted, try every color
            # add the cost of color picked to the dp value returned
            best = inf
            for i, j in enumerate(cost[h], 1):
                best = min(best, dp(h+1, n + (c != i), i) + j)
            return best
        
        res = dp(0, 0, 0)
        return res if res != inf else -1