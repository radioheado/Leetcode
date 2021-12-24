class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // use merge to keep track of the merged intervals
        int[] merge = intervals[0];
        List<int[]> result = new ArrayList<>();
        int[] cur = new int[2];
        
        for(int i=1; i<intervals.length; i++){
            cur = intervals[i];
            if(cur[0] <= merge[1]){
                merge[1] = Math.max(cur[1], merge[1]);
            }else{
                result.add(merge);
                merge = cur;
            }
        }
        
        //System.out.println(merge);
        //System.out.println(cur);
        result.add(merge);
        
        
        return result.toArray(new int[result.size()][]);
    }
}