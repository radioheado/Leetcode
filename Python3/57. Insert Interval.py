class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        start, end = newInterval
        i, N = 0, len(intervals)
        
        # step 1: add all old intervals before newInterval
        while i < N and start > intervals[i][0]:
            ans.append(intervals[i])
            i += 1
            
        # step 2: add the newInterval
        #         case 1: no overlap
        if not ans or ans[-1][1] < start:
            ans.append(newInterval)
            
        #         case 2: overlap
        else:
            ans[-1][1] = max(ans[-1][1], end)
            
        # step 3: add the remaining old intervals
        while i < N:
            start, end = intervals[i]
            i += 1
            
            # case 1: no overlap
            if ans[-1][1] < start:
                ans.append([start, end])
            # case 2: overlap
            else:
                ans[-1][1] = max(ans[-1][1], end)
            
        return ans