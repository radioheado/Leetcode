class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x: x[0])
        
        result = []
        i = 0
        merge = intervals[0]
        
        for i in range(1, len(intervals)):
            cur = intervals[i]
            # if the start of the current interval is smaller than
            # the previously merged interval, merge again
            # else, add merge to result and start a new merge from cur
            if cur[0] <= merge[1]:
                merge[1] = max(cur[1], merge[1])
            else:
                result.append(merge)
                merge = cur
        
        
        result.append(merge)
            
        return result
        