# Recursive Solution
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        
        elif n == 2:
            return 2
        
        # ways[n] = ways[n-1] + ways[n-2]
        ways = [-1]*(n+1)
        ways[1] = 1
        ways[2] = 2
        
        def rec(n):
            if ways[n] != -1:
                return ways[n]
            
            ways[n-1] = rec(n-1)
            ways[n-2] = rec(n-2)
            
            return ways[n-1] + ways[n-2]
            
        return rec(n)