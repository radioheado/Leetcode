class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        no_rain_count = []
        ans = [1] * len(rains)
        full = {}

        for i, r in enumerate(rains):
            if r == 0:
                no_rain_count.append(i)
                continue
            
            ans[i] = -1
            if r in full:
                p = bisect_left(no_rain_count, full[r])
                if p == len(no_rain_count):
                    return []
                
                ans[no_rain_count[p]] = r
                no_rain_count.pop(p)
            full[r] = i
                
        return ans