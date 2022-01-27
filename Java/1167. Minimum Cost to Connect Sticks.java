class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cost = 0;
        
        for(int s: sticks){
            heap.add(s);
        }
        
        while(heap.size() > 1){
            int first = heap.poll();
            int second = heap.poll();
            cost += first+second;
            heap.add(first+second);
        }
        
        return cost;
    }
}