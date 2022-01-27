class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x:x[0])
        count = 0
        freed = []
        for i in intervals:
            freed.append(i[1])
            
        heapq.heapify(freed)
        
        for itv in intervals:
            #print(itv, freed[0])
            if itv[0] >= freed[0]:
                heapq.heappop(freed)
            else:
                count += 1
                
        return count