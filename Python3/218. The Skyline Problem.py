class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        # record the answer
        ans = []
        
        # keep track of the points of different buildings
        # pick the left line of the building as "entering"
        # and set the height to negative to indicate this
        # also add the right line of the building as "leaving"
        # and keep the height as positive so we can remove the height
        # which indicates we have finished this building
        points = []
        
        # add the entering and leaving points for each building
        for b in buildings:
            points.append((b[0], -b[2]))
            points.append((b[1], b[2]))
            
        points.sort(key = lambda x: (x[0], x[1]))
        #print(points)
        heap = [0]
        
        # keep track of the previous key point
        pre = 0
        
        # traverse the points
        for x, y in points:
            #print(y, heap)
            # y is negative, means we are "entering" a new building
            # add the height to the max heap
            if y < 0:
                heapq.heappush(heap, y)
            # y is positive, means we are "leaving" an old building
            # remove its height from the max heap so we won't record it anymore
            else:
                #index = bisect.bisect_right(heap, -y)
                heap.remove(-y)
                heapq.heapify(heap)
                #print(index, -y, heap)
            
            cur = heap[0]
            #print(y, cur)
            # meet a key point, add it to ans and update pre
            if cur != pre:
                ans.append([x, -cur])
                pre = cur
                
        return ans
        
            
            
        
        