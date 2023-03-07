class Solution {
    public long minimumTime(int[] times, int totalTrips) {
        long l = 1, r = 1, m;
        for (int time: times) {
            r = Math.max(r, time);
        }

        r *= totalTrips;
        while (l < r) {
            m = (r - l) / 2 + l;
            if (works(times, totalTrips, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean works(int[] times, int totalTrips, long time) {
        long trips = 0;
        for (int t: times) {
            trips += time / t;
        }
        return trips >= totalTrips;
    }
}