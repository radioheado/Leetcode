class Solution:
    def concatenatedBinary(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        
        s = ''.join(bin(i)[2:] for i in range(n+1))
        
        return int(s, 2) % MOD