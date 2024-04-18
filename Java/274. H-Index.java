class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[1001];
        for (int c: citations) {
            counts[c]++;
        }

        for (int i = 1000; i > 0; i--) {
            if (counts[i] >= i) {
                return i;
            }
            counts[i - 1] += counts[i];
        }

        return 0;
    }
}