class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        left = -1
        right = 0
        dis = 0
        
        while right < len(seats):
            
            if seats[right] == 1:
                # this is the first occupied seat 
                if left == -1:
                    dis = right 
                
                # not the first occupied seat
                else:
                    dis = max(dis, (right-left)//2)
                    
                left = right
            right += 1
        
        # if last seat is not occupied
        if seats[right-1] == 0:
            dis = max(dis, (right-left-1))
        else:
            dis = max(dis, (right-left)//2)
        
        return dis
        