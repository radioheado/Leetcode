class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] status = new int[n];
        List<Integer> ans = new ArrayList();

        for (int node = 0; node < n; node++) {
            if (dfs(graph, status, node)) {
                ans.add(node);
            }
        }

        return ans;
    }

    private boolean dfs(int[][] graph, int[] status, int node) {
        if (status[node] == 1) {
            return false;
        } else if (status[node] == 2) {
            return true;
        }
        status[node] = 1;
        for (int child: graph[node]) {
            if (!dfs(graph, status, child)) {
                return false;
            }
        }
        status[node] = 2;
        return true;
    }
}