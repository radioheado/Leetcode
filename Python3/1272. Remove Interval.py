class Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        
        ans = []
        rstart, rend = toBeRemoved
        
        for s, e in intervals:
            # no overlap
            if s > rend or e < rstart:
                ans.append([s, e])
                
            else:
                # keep the left interval
                if s < rstart:
                    ans.append([s, rstart])
                # keep the right interval
                if e > rend:
                    ans.append([rend, e])
                    
        return ans