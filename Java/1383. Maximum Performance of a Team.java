class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) Math.pow(10, 9) + 7;
        List<Pair<Integer, Integer>> cands = new ArrayList();
        
        for (int i=0; i<n; ++i) {
            cands.add(new Pair(efficiency[i], speed[i]));
        }
        
        Collections.sort(cands, Comparator.comparing(o -> -o.getKey()));
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        
        long speeds = 0, ans = 0;
        for (Pair<Integer, Integer> pair: cands) {
            Integer e = pair.getKey();
            Integer s = pair.getValue();
            
            if (heap.size() > k - 1) {
                speeds -= heap.poll();
            }
            
            heap.add(s);
            speeds += s;
            ans = Math.max(ans, speeds * e);
        }
        
        return (int) (ans % MOD);
    }
}