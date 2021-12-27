class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        cur, count, nonzero = -1, 0, 0
        
        # firstly, count n numbers including double 0s
        # when stop, the cur pointer points to the last index of the result list
        # also keep track of nonzero numbers to compute for total number of duplicate zeros
        while count < len(arr):
            cur += 1
            if arr[cur] > 0:
                nonzero += 1
                
            # if cur equals to 0, add an extra 1 to the count
            # except for the last zero, if it's the case, 
            # we won't duplicate it because it exceeds the length of the array
            elif arr[cur] == 0 and count < len(arr)-1:
                count += 1
                
            count += 1
            #print("cur = %d, arr[cur] = %d, count = %d" %(cur, arr[cur], count))
        
        zeros = count - nonzero
        
        #print("second while")
        
        # modify the list backwards
        count -= 1
        
        # pre-process the situation where the cur pointer points to a zero
        # and it only counts once because itself already reaches len(arr)-1
        # thus, if zeros is odd, there is a last zero that only counts once
        if zeros%2 == 1:
            arr[count] = 0
            cur -= 1
            count -= 1
        
        while count >= 0:
            
            arr[count] = arr[cur]
            #print("cur = %d, arr[count] = %d, count = %d" %(cur, arr[count], count))
            #print(arr)
            count -= 1
            
            # add an extra 0 to the list
            if arr[cur] == 0:
                arr[count] = 0
                count -= 1
            cur -= 1   
            