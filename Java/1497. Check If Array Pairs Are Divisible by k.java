class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainders = new int[k];
        for (int n: arr) {
            remainders[remainder(n, k)]++;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i && remainders[i] % 2 != 0) {
                return false;
            }

            if (remainders[i] != remainders[k - i]) {
                return false;
            }
        }

        return remainders[0] % 2 == 0;
    }

    private int remainder(int n, int k) {
        return ((n % k) + k) % k;
    }
}