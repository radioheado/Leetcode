class Solution:
    def countVowelPermutation(self, n: int) -> int:
        MOD = 10**9 + 7
        a = e = i = o = u = 1
        
        for _ in range(1, n):
            ac = (e + i + u) % MOD
            ec = (a + i) % MOD
            ic = (e + o) % MOD
            oc = i % MOD
            uc = (i + o) % MOD
            
            a, e, i, o, u = ac, ec, ic, oc, uc
            
        return (a + e + i + o + u) % MOD