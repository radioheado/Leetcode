class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        # the base case
        if n == 1:
            return 0
        
        # get the result from n-1 using recursion
        prev = self.kthGrammar(n-1, (k+1)//2)
        
        # compute current digit
        if prev == 1:
            if k%2 == 1:
                return 1
            else:
                return 0
            
        else:
            if k%2 == 1:
                return 0
            else:
                return 1 
        