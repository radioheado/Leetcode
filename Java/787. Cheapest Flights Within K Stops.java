class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjs = new HashMap();
        for (int[] f: flights) {
            adjs.computeIfAbsent(f[0], value -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        } 

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, src, 0});
        int dist, node, stop;

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            dist = cur[0];
            node = cur[1];
            stop = cur[2];

            if (stop > stops[node] || stop > k + 1) {
                continue;
            }

            stops[node] = stop;
            if (node == dst) {
                return dist;
            }

            if (!adjs.containsKey(node)) {
                continue;
            }

            for (int[] nei: adjs.get(node)) {
                heap.offer(new int[]{dist + nei[1], nei[0], stop + 1});
            }
        }
        
        return -1;
    }
}