class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen:
            # add it to the set
            seen.add(n)
            
            # refresh the sum
            s = 0
            
            # calculate the sum of the squares of the digits
            for c in str(n):
                s += int(c)*int(c)
                
            # check if s equals to 1
            if s == 1:
                return True
            
            # update the value of n
            n = s
            
        # the loop ends because n is in seen
        return False