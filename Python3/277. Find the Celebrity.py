# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        # if knows(a, b) = True, then a cannot be the celebrity,
        # and b can be the celebrity
        # if knows(a, b) = False, then a can be the celebrity,
        # and b cannot be the celebrity
        cand = 0
        for i in range(1, n):
            # if current candidate knows i, 
            # then i can be the celerity while candidate no longer can
            if knows(cand, i):
                cand = i
        
        if self.isCelebrity(n, cand):
            return cand
        
        return -1
                
        
    def isCelebrity(self, n: int, i: int) -> bool:
        for j in range(n):
            if i == j:
                continue
                
            # i knows j or j doesn't know i
            if knows(i, j) or not knows(j, i):
                return False
            
        return True