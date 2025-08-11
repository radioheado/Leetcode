class Solution {
    private static final int MOD = 1_000_000_007;

    private static int pow2Mod(int exp) {
        long base = 2L, res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return (int) res;
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> exps = new ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) exps.add(bit);
            bit++;
            n >>= 1;
        }

        // prefix sums of exponents
        int m = exps.size();
        int[] pref = new int[m];
        for (int i = 0; i < m; i++) {
            pref[i] = exps.get(i) + (i > 0 ? pref[i - 1] : 0);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int sum = pref[r] - (l > 0 ? pref[l - 1] : 0); // sum of exponents
            ans[i] = pow2Mod(sum);
        }
        return ans;
    }
}
