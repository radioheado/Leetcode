class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        #return A.index(max(A))
        
        left, right = 0, len(A)-1
        
        while left < right:
            tar = (right+left)//2 
            if A[tar] < A[tar+1]:
                left = tar + 1
            else:
                right = tar 
            
        return left