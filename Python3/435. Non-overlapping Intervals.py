class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: (x[0], x[1]))
        prev = intervals[0]
        ans = 0
        
        for start, end in intervals[1:]:
            # non-overlapping, only update prev 
            if start >= prev[1]:
                prev = [start, end]
                
            # prev covers cur, remove prev
            elif prev[0] <= start and end <= prev[1]:
                ans += 1
                prev = [start, end]
            
            # cur overlaps prev, remove cur
            else:
                ans += 1
        
        return ans
                
                
            