class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        # IMPORTANT formula:
        # N = K*x + R, where R is the remainder
        # the next number to investigate is N*10 + 1
        # N*10 + 1 = (K*x + R)*10 + 1 = (K*x*10) + R*10 + 1
        # recall that K*x is divisible by K
        # then (N*10 + 1) % K = (K*x*10)%K + (R*10)%K + 1%K
        #                     = 0 + (R*10)%K + 1
        #                     = (R*10)%K + 1
        # that is, current%K = (prev_Remainder*10 + 1)%K
        # 
        # Also, we only need to loop K times because 
        # we'll definitely get a repeated remainder starting from the K+1-th iteration
        
        rem = 0
        
        for i in range(1, k+1):
            rem = (rem*10+1) % k
            if rem == 0:
                return i
        
        return -1
        
        