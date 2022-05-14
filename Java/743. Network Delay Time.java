class Solution {
    private Map<Integer, List<Pair<Integer, Integer>>> neighbors = new HashMap<>();
    
    public int networkDelayTime(int[][] times, int n, int k) {
        /* build the adjacency list */
        for (int[] time: times) {
            int src = time[0], dst = time[1], t = time[2];
            neighbors.putIfAbsent(src, new ArrayList<>());
            neighbors.get(src).add(new Pair(t, dst));
        }
        
        int[] signal = new int[n+1];
        Arrays.fill(signal, Integer.MAX_VALUE);
        
        dijkstra(signal, k, n);
        int ans = -1;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, signal[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    
    private void dijkstra (int[] signal, int src, int n) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>  
            (Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0, src));
        
        signal[src] = 0;
        
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();
            int node = pair.getValue(), time = pair.getKey();
            
            if (time > signal[node] || !neighbors.containsKey(node)) continue;
            
            for (Pair<Integer, Integer> edge: neighbors.get(node)) {
                int arrival = edge.getKey(), nei = edge.getValue();
                if (signal[nei] > time+arrival) {
                    signal[nei] = time + arrival;
                    pq.add(new Pair(signal[nei], nei));
                }
            }
        }
    }
}