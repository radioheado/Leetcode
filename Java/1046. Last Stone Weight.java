class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s: stones){
            heap.add(s);
        }
        
        while(heap.size() > 1){
            int largest = heap.poll();
            int second = heap.poll();
            
            if(largest != second){
                heap.add(largest-second);
            }
        }
        
        return heap.isEmpty() ? 0 : heap.poll();
    }
}