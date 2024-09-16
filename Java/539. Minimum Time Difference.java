class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] time = new boolean[24 * 60];
        for (String t: timePoints) {
            int min = Integer.parseInt(t.substring(0, 2)) * 60 + 
                      Integer.parseInt(t.substring(3));
            if (time[min]) {
                return 0;
            }
            time[min] = true;
        }

        int prev = -1, ans = 780, first = -1, last = -1;
        for (int i = 0; i < 24 * 60; i++) {
            if (time[i]) {
                if (prev != -1) {
                    ans = Math.min(ans, i - prev);
                }
                prev = i;

                // Update the index of the first valid time
                if (first == -1) {
                    first = i;
                }

                // Update the index of the last valid time every roll
                last = i;
            }
        }

        return Math.min(ans, 24 * 60 - last + first);
    }
}