class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i=0; i<points.length; i++) {
            int[] cur = {distance(points[i]), i};
            heap.offer(cur);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for (int i=0; i<k; i++) {
            ans[i] = points[heap.poll()[1]];
        }
        return ans;
    }
    
    private int distance(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}