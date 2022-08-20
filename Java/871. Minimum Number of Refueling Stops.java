class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        
        int ans = 0, pre = 0;
        
        for (int[] s: stations) {
            tank -= s[0] - pre;
            while (!heap.isEmpty() && tank < 0) {
                tank += heap.poll();
                ans++;
            }
            
            if (tank < 0) {
                return -1;
            }
            
            heap.offer(s[1]);
            pre = s[0];
        }
        
        tank -= target - pre;
        while (!heap.isEmpty() && tank < 0) {
            tank += heap.poll();
            ans++;
        }
        
        return tank < 0 ? -1 : ans;
    }
}