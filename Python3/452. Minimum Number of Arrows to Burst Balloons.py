class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        
        # base case: there is only one balloon
        if len(points) == 1:
            return 1
        
        # sort the list
        points.sort(key = lambda x: x[1])
        #print(points)
        
        # count the shots
        total = 1
        prev = points[0][1]
        for i in range(1, len(points)):
            cur = points[i]
            
            # if current balloon and previous balloon don't overlap
            if prev < cur[0]:
                # update the prev end
                total += 1
                prev = cur[1]
              
        return total