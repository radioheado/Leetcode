class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int[] pre: prerequisites) {
            graph.computeIfAbsent(pre[1], v -> new ArrayList<>()).add(pre[0]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(graph, status, c)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] status, int node) {
        if (status[node] == 1) {
            return false;
        } else if (status[node] == 2) {
            return true;
        }
        status[node] = 1;
        for (int child: graph.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(graph, status, child)) {
                return false;
            }
        }
        status[node] = 2;
        return true;
    }
}