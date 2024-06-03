class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int n: nums) {
            bitmask ^= n;
        }

        int x = 0, diff = bitmask & (-bitmask);
        for (int n: nums) {
            if ((diff & n) != 0) {
                x ^= n;
            }
        }

        return new int[]{x, x ^ bitmask};
    }
}