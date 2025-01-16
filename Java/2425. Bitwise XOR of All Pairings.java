class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 % 2 == 1) {
            for (int n: nums2) {
                xor2 ^= n;
            }
        }

        if (n2 % 2 == 1) {
            for (int n: nums1) {
                xor1 ^= n;
            }
        }

        return xor1 ^ xor2;
    }
}