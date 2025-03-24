class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int ans = 0, prev = 0;

        for (int[] meeting: meetings) {
            int s = meeting[0], e = meeting[1];
            if (s > prev + 1) {
                ans += s - prev - 1;
            }
            prev = Math.max(prev, e);
        }

        ans += days - prev;
        return ans;
    }
}