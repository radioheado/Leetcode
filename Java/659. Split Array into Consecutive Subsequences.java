class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] seq1, int[] seq2) -> {
            if (seq1[1] == seq2[1]) {
               return (seq1[1] - seq1[0]) - (seq2[1] - seq2[0]);
            } 
            return (seq1[1] - seq2[1]);
        });
        
        for (int n: nums) {
            // case 1: remove all existing sequences that can 
            //         no longer take elements
            while (!heap.isEmpty() && heap.peek()[1] + 1 < n) {
                int[] seq = heap.poll();
                if (seq[1] - seq[0] < 2) {
                    return false;
                }
            }
            
            // case 2: create a new sequence
            if (heap.isEmpty() || heap.peek()[1] == n) {
                heap.add(new int[] {n, n});
            } 
            // case 3: add to existing sequence
            else {
                int[] seq = heap.poll();
                heap.add(new int[] {seq[0], n});
            }
        }
        
        // final check
        while (!heap.isEmpty()) {
            int[] seq = heap.poll();
            if (seq[1] - seq[0] < 2) {
                return false;
            }
        }
        
        return true;
    }
}