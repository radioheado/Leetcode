class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        
        if len(arr) < 3:
            return False
        
        climbing = False
        turn = False
        
        for i in range(len(arr)-1):
            # not a strict mountain
            if arr[i] == arr[i+1]:
                return False
            
            # climbing, turn is False
            elif arr[i] < arr[i+1]:
                climbing = True
                if turn:
                    return False
                
            # starting to decrease
            else:
                turn = True
                
        return climbing and turn
                    
                