class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        prev = -1
        cur = 0
        
        while cur < len(flowerbed):
            # a taken plot
            if flowerbed[cur] == 1:
                
                if prev == -1:
                    n -= cur//2
                    
                else:
                    n -= ((cur-prev)//2 - 1)
                    
                #print("prev plot: %d, cur plot: %d, n: %d" %(prev, cur, n))
                # update prev pointer
                prev = cur
                
                # break the loop in advance
                if n <= 0:
                    return True
                
            cur += 1
        
        # a portion of the flowerbed is not investigated
        if flowerbed[cur-1] == 0:
            if prev == -1:
                n -= (cur+1)//2
            else:
                n -= ((cur-prev+1)//2-1)
        
        #print("prev plot: %d, cur plot: %d, n: %d" %(prev, cur, n))
        return True if n <= 0 else False
                    