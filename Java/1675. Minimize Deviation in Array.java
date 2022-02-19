class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int n: nums) {
            if(n%2 == 1) {
                n *= 2;
            }
            heap.offer(n);
            min = Math.min(min, n);
        }
        
        int deviat = Integer.MAX_VALUE;
        
        while(!heap.isEmpty()) {
            int cur = heap.poll();
            deviat = Math.min(deviat, cur-min);
            if(cur%2 == 0) {
                heap.offer(cur/2);
                min = Math.min(min, cur/2);
            }else {
                break;
            }
        }
        
        return deviat;
    }
}