class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge: edges) {
            graph.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(s, 0);
        Set<Integer> target = new HashSet<>();
        for (int m: marked) {
            target.add(m);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        heap.offer(new int[] {0, s});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int node = cur[1], cost = cur[0];

            if (target.contains(node)) {
                return distance.get(node);
            }

            
            for (int[] edge: graph.get(node)) {
                int child = edge[0], weight = edge[1];
                int new_cost = weight + cost;
                if (new_cost < distance.getOrDefault(child, Integer.MAX_VALUE)) {
                    distance.put(child, new_cost);
                    heap.offer(new int[]{new_cost, child});
                }
            }           

        }
        return -1;
    }
}