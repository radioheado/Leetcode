class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low, high = 1, max(piles)
        
        while low < high:
            mid = (high-low)//2+low
            
            hours = 0
            for p in piles:
                hours += math.ceil(p/mid)
                
                # break in advance
                if hours > h:
                    break
            
            if hours > h:
                low = mid+1
            else:
                high = mid
            
        return low
            