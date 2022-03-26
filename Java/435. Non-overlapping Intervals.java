class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int[] prev = intervals[0];
        int ans = 0;
        
        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start >= prev[1]) {
                prev[0] = start;
                prev[1] = end;
            } else if (prev[0] <= start && end <= prev[1]) {
                ans++;
                prev[0] = start;
                prev[1] = end;
            } else {
                ans++;
            }
        }
        
        return ans;
    }
}