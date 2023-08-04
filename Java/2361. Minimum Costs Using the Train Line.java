class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long reg = 0, exp = expressCost;
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            reg = Math.min(reg + regular[i], exp + express[i]);
            exp = Math.min(reg + expressCost, exp + express[i]);
            ans[i] = Math.min(reg, exp);
        }

        return ans;
    }
}