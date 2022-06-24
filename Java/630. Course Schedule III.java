class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int time = 0, dura, end;
        
        for (int[] c: courses) {
            dura = c[0];
            end  = c[1];
            
            if (time + dura <= end) {
                heap.offer(dura);
                time += dura;
            } else if (!heap.isEmpty() && heap.peek() > dura) {
                time += dura - heap.poll();
                heap.offer(dura);
            }
        }
        
        return heap.size();
    }
}