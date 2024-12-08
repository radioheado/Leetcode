class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> times = new ArrayList<>();
        for (int[] event: events) {
            times.add(new int[] {event[0], 1, event[2]});
            times.add(new int[] {event[1] + 1, 0, event[2]});
        }

        // Sort the times by time and then by type
        // end type before start for the same time
        times.sort((a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1])
                         : Integer.compare(a[0], b[0]));

        int ans = 0, max_val = 0;
        for (int[] time: times) {
            if (time[1] == 1) {
                ans = Math.max(ans, time[2] + max_val);
            } else {
                max_val = Math.max(max_val, time[2]);
            }
        }

        return ans;
    }
}