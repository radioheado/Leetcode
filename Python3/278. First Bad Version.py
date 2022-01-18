# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> int:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left, right = 1, n+1
        
        while left < right:
            mid = (right-left)//2+left
            
            if not isBadVersion(mid):
                # check for the next version
                if isBadVersion(mid+1):
                    return mid+1
                else:
                    left = mid+1
            
            else:
                right = mid
                
        return left