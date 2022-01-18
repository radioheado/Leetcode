class Solution:
    def mySqrt(self, x: int) -> int:
        low, high = 0, x
        
        while low <= high:
            mid = (high-low)//2+low
            if mid*mid > x:
                high = mid-1
            elif mid*mid < x:
                low = mid+1
            else:
                return mid
            
        return mid if mid*mid < x else mid-1