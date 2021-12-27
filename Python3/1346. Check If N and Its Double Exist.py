class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        
        # if num == 0, check if there are more than one 0
        # otherwise, search the set for num*2
        sets = set(arr)
        
        for num in arr:
            if num == 0:
                if arr.count(0) > 1:
                    return True
            
            elif num*2 in sets:
                #print(num, num*2)
                return True
            
        return False
            
            
                