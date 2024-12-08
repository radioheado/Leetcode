class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int n: nums) {
            r = Math.max(r, n);
        }

        while (l < r) {
            int m = (r - l) / 2 + l;
            if (isValid(nums, maxOperations, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean isValid(int[] nums, int max_ops, int max_balls) {
        for (int n: nums) {
            max_ops -= Math.ceilDiv(n, max_balls) - 1;
        }
        return max_ops >= 0;
    }
}