class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });
        
        int count = 0, prev = 0;
        for(int[] cur: intervals) {
            if(cur[1] > prev) {
                count++;
                prev = cur[1];
            }
        }
        return count;
    }
}