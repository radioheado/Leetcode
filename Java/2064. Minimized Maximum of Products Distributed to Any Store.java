class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = quantities[0];
        for (int q: quantities) {
            r = Math.max(r, q);
        }

        while (l < r) {
            int m = (r - l) / 2 + l;
            if (isValid(n, quantities, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private boolean isValid(int n, int[] quantities, int p) {
        for (int q: quantities) {
            int stores = Math.ceilDiv(q, p);
            if (n >= stores) {
                n -= stores;
            } else {
                return false;
            }
        }
        return true;
    }
}