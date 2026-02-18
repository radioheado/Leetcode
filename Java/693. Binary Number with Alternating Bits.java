class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n <= 2) {
            return true;
        }

        long base = 2, bit = 1;
        while (base < n) {
            base = base * 2 + bit;
            if (base == n) {
                return true;
            }
            bit ^= 1;
        }
        return false;
    }
}