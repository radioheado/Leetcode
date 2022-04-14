class Solution:
    def largestPerimeter(self, A: List[int]) -> int:
        A.sort(reverse=True)
        
        def test(a,b,c):
            if a+b>c and a+c>b and b+c>a:   return True
            else:   return False
            
        for i in range(len(A)-2):
            if test(A[i], A[i+1], A[i+2]):  return A[i]+A[i+1]+A[i+2]
            
        return 0
        
        
        