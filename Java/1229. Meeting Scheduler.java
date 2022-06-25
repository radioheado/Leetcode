class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);
        
        for (int[] s: slots1) {
            if (s[1] -s[0] >= duration) {
                heap.offer(s);
            }
        }
        
        for (int[] s: slots2) {
            if (s[1] -s[0] >= duration) {
                heap.offer(s);
            }
        }
        
        while (heap.size() > 1) {
            int[] p1 = heap.poll();
            int[] p2 = heap.peek();
            
            if (p1[1] >= p2[0] + duration) {
                return new ArrayList<>(Arrays.asList(p2[0], p2[0] + duration));
            }
        }
        
        return new ArrayList<Integer>();
    }
}