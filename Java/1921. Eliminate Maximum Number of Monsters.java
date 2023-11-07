class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length, ans = 0;
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(times);

        for (int i = 0; i < n; i++) {
            if (times[i] <= i) {
                break;
            }
            ans++;
        }

        return ans;
    }
}