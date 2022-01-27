class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        diffs = []
        L = ladders
        
        for i in range(1, len(heights)):
            #print(diffs)
            # if and only if we need to climb
            if heights[i] > heights[i-1]:
                diff = heights[i]-heights[i-1]
                
                # directly push the new diff to the heap
                # add use the ladder
                if len(diffs) < L:
                    heapq.heappush(diffs, diff)
                    ladders -= 1
                
                # pop the smallest diff and use bricks instead
                # increment ladders if there are enough bricks
                else:
                    # update the heap if top of the heap is larger
                    if diffs and diff > diffs[0]:
                        brick = heapq.heappop(diffs)
                        heapq.heappush(diffs, diff)
                    else:
                        brick = diff
                        
                    if brick > bricks:
                        return i-1
                    else:
                        bricks -= brick
                        ladders += 1
                        
        return len(heights)-1
                    