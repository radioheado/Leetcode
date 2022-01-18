# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left, right = 0, 9999
        
        while left <= right:
            mid = (right-left)//2 + left
            num = reader.get(mid)
            
            # found the target
            if num == target:
                return mid
            
            # target resides to the right hand side
            elif num < target:
                left = mid+1
            
            # size out of the boundary or 
            # target resides to the left hand side
            else:
                right = mid-1
                
        return -1
                
        