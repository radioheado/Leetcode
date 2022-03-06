class Solution:
    def countOrders(self, n: int) -> int:
        ans = 1
        mod = 10**9 + 7
        
        for i in range(1, n+1):
            ans *= i
            ans *= (2*i-1)
            ans %= mod
            
        return ans