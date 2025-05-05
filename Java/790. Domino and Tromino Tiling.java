class Solution {
    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }

        int MOD = 1_000_000_007;
        long f_pre = 1, f_cur = 2, p_cur = 1;
        for (int k = 3; k <= n; k++) {
            long cur = f_cur;
            f_cur = (f_pre + f_cur + 2 * p_cur) % MOD;
            p_cur = (f_pre + p_cur) % MOD;
            f_pre = cur;
        }

        return (int)f_cur;
    }
}