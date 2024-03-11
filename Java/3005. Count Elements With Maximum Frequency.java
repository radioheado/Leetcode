class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] counts = new int[101];
        int maxf = 0, totalf = 0;

        for (int n: nums) {
            counts[n]++;
            int curf = counts[n];
            if (curf > maxf) {
                maxf = curf;
                totalf = curf;
            } else if (curf == maxf) {
                maxf = curf;
                totalf += curf;
            }
        }

        return totalf;
    }
}