class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort logic:
        // 1. Compare end times (a[1], b[1]). If different, sort ascending (a[1] - b[1]).
        // 2. If end times are same, compare start times. Sort descending (b[0] - a[0]).
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        int ans = 0, p1 = -1, p2 = -1;
        for (int[] interval: intervals) {
            int s = interval[0], e = interval[1];
            if (s > p2) {
                ans += 2;
                p1 = e - 1;
                p2 = e;
            } else if (s > p1) {
                ans++;
                p1 = p2;
                p2 = e;
            }
        }

        return ans;
    }
}