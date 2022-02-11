class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        
        // add left and right points of each building
        for(int[] b: buildings) {
            points.add(new int[] {b[0], -b[2]});
            points.add(new int[] {b[1], b[2]});
        }
        
        // sort the points
        Collections.sort(points, (a,b) -> {
            if(a[0] != b[0]) {
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        heap.add(0);
        int pre = 0;
        
        for(int[] p: points) {
            if(p[1] < 0) {
                heap.add(-p[1]);
            }else {
                heap.remove(p[1]);
            }
            
            int cur = heap.peek();
            if(cur != pre) {
                ans.add(Arrays.asList(p[0], cur));
                pre = cur;
            }
        }
        
        return ans;
    }
}