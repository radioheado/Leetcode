class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList();
        int start = newInterval[0], end= newInterval[1], i = 0, N = intervals.length;
        
        /* add all old intervals that are before newInterval */
        while (i < N && start > intervals[i][0]) {
            res.add(intervals[i++]);
        }
        
        /* add newInterval to res, no overlap */
        if (res.isEmpty() || res.getLast()[1] < start) {
            res.add(newInterval);
        } 
        /* overlap */
        else {
            newInterval = res.pollLast();
            newInterval[1] = Math.max(newInterval[1], end);
            res.add(newInterval);
        }
        
        /* add all old remaining intervals */
        while (i < N) {
            start = intervals[i][0];
            end   = intervals[i++][1];
            /* no overlap */
            if (res.getLast()[1] < start) {
                res.add(intervals[i-1]);
            } else {
                newInterval = res.pollLast();
                newInterval[1] = Math.max(newInterval[1], end);
                res.add(newInterval);
            }
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}