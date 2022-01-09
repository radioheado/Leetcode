class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        # four directions: 0 -> north, 
        #                  1 -> east,
        #                  2 -> south,
        #                  3 -> west.
        diff = {0: (0, 1),
                1: (1, 0),
                2: (0, -1),
                3: (-1, 0)}
        
        # initial direction is north, coordinate is [0, 0]
        dire = 0
        coor = [0, 0]
        
        # loop one cycle
        for i in instructions:
            # update the coordinate
            if i == 'G':
                coor[0] += diff[dire][0]
                coor[1] += diff[dire][1]
                
            # turn left, direction minus 1
            elif i == 'L':
                dire = (dire-1)%4
                
            # turn right, direction plus 1
            else:
                dire = (dire+1)%4
                    
        return coor == [0, 0] or dire != 0