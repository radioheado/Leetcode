class Solution {
    public int minCost(int n, int[][] edges) {
        // Use adjacency list instead of matrix
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            // Original edge u -> v with cost w
            graph.computeIfAbsent(u, k -> new HashMap<>()).merge(v, w, Math::min);
            
            // Reversed edge v -> u with cost 2*w
            graph.computeIfAbsent(v, k -> new HashMap<>()).merge(u, 2 * w, Math::min);
        }

        int[] shortest = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[0] = 0;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> candidates = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        candidates.offer(new int[]{0, 0});

        while (!candidates.isEmpty()) {
            int[] cur = candidates.poll();
            int cost = cur[0], node = cur[1];
            
            if (node == n - 1) {
                return cost;
            }

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            // Only iterate over actual neighbors, not all nodes
            if (graph.containsKey(node)) {
                for (Map.Entry<Integer, Integer> entry : graph.get(node).entrySet()) {
                    int neighbor = entry.getKey();
                    int weight = entry.getValue();
                    
                    if (cost > Integer.MAX_VALUE - weight) {
                        continue;
                    }
                    int newCost = cost + weight;
                    if (newCost < shortest[neighbor]) {
                        shortest[neighbor] = newCost;
                        candidates.offer(new int[]{newCost, neighbor});
                    }
                }
            }
        }
        return -1;
    }
}