class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, s = 0, e = 0;
        int[] bit_count = new int[32];

        while (e < nums.length) {
            updateBitCounts(bit_count, nums[e], 1);
            while (s <= e && convertBitsToNum(bit_count) >= k) {
                ans = Math.min(ans, e - s + 1);
                updateBitCounts(bit_count, nums[s], -1);
                s++;
            }
            e++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void updateBitCounts(int[] bit_count, int num, int delta) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) != 0) {
                bit_count[i] += delta;
            }
        }
    }

    private int convertBitsToNum(int[] bit_count) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bit_count[i] > 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}