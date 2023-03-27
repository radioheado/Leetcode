class Solution {
    private int ans = -1;
    
    public int longestCycle(int[] edges) {
        Set<Integer> visited = new HashSet();
        for (int i=0; i<edges.length; i++) {
            if (!visited.contains(i)) {
                Map<Integer, Integer> dist = new HashMap();
                dist.put(i, 1);
                dfs(edges, i, dist, visited);
            }
        }

        return ans;
    }

    private void dfs(int[] edges, int node, Map<Integer, Integer> dist, Set<Integer> visited) {
        visited.add(node);
        int nei = edges[node];

        if (nei != -1 && !visited.contains(nei)) {
            dist.put(nei, dist.get(node) + 1);
            dfs(edges, nei, dist, visited);
        } else if (nei != -1 && dist.containsKey(nei)) {
            ans = Math.max(ans, dist.get(node) - dist.get(nei) + 1);
        }
    }
}