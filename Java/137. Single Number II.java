class Solution {
    public int singleNumber(int[] nums) {
        int loner = 0;

        for (int shift = 0; shift < 32; shift++) {
            int bit_sum = 0;

            for (int n: nums) {
                bit_sum += (n >> shift) & 1;
            }

            int loner_bit = bit_sum % 3;
            loner |= loner_bit << shift;
        }

        return loner;
    }
}