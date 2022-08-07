class Solution {
    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long ac = a, ec = e, ic = i, oc = o, uc = u;
        int MOD = 1000000007;
        
        for (int k=1; k<n; k++) {
            ac = (e+i+u) % MOD;
            ec = (a+i)   % MOD;
            ic = (e+o)   % MOD;
            oc = (i)     % MOD;
            uc = (i+o)   % MOD;
            
            a = ac;
            e = ec;
            i = ic;
            o = oc;
            u = uc;
        }
        
        long res = (a+e+i+o+u) % MOD;
        return (int)res;
    }
}