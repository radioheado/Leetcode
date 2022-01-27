class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int[] itv: intervals){
            if(!heap.isEmpty() && itv[0] >= heap.peek()){
                heap.poll();
            }
            heap.add(itv[1]);
        }
        
        return heap.size();
    }
}