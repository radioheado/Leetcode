class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 0, r = 0;
        for (int ribbon: ribbons) {
            r = Math.max(r, ribbon);
        }

        while (l < r) {
            int m = (l + r + 1) / 2;
            if (isValid(ribbons, k, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    private boolean isValid(int[] ribbons, int k, int length) {
        for (int ribbon: ribbons) {
            k -= ribbon / length;
            if (k <= 0) {
                return true;
            }
        }
        return false;
    }
}