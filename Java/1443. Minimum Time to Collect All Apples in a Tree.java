class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adjs = new HashMap();
        for (int[] edge: edges) {
            adjs.computeIfAbsent(edge[0], value -> new ArrayList<Integer>()).add(edge[1]);
            adjs.computeIfAbsent(edge[1], value -> new ArrayList<Integer>()).add(edge[0]);
        }

        return dfs(0, -1, hasApple, adjs);
    }

    private int dfs(int node, int parent, List<Boolean> hasApple, Map<Integer, List<Integer>> adjs) {
        if (!adjs.containsKey(node)) {
            return 0;
        }

        int total = 0, child = 0;
        for (int nei: adjs.get(node)) {
            if (nei == parent) {
                continue;
            }
            child = dfs(nei, node, hasApple, adjs);
            if (child > 0 || hasApple.get(nei)) {
                total += child + 2;
            }
        }

        return total;
    }
}