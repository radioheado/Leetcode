class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 0, m, n = dist.length;
        if (n > Math.ceil(hour)) {
            return -1;
        }

        for (int d: dist) {
            r = Math.max(r, d);
        }

        if (hour > (int)hour) {
            r = (int)Math.ceil((double)r / (hour - (int)hour));
        }

        while (l < r) {
            m = (r - l) / 2 + l;
            if (feasible(dist, m, hour)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean feasible(int[] dist, int speed, double hour) {
        double ans = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            ans += Math.ceil((double)dist[i] / (double)speed);
        }
        ans += (double)dist[dist.length-1] / (double)speed;
        return ans <= hour;
    }
}