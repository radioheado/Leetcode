class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for (int[] c: connections) {
            adj.computeIfAbsent(c[0], value -> new ArrayList()).add(new int[]{c[1], 1});
            adj.computeIfAbsent(c[1], value -> new ArrayList()).add(new int[]{c[0], 0});
        }

        Queue<Integer> q = new LinkedList();
        q.add(0);
        Set<Integer> visited = new HashSet();
        visited.add(0);
        int ans = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!adj.containsKey(node)) {
                continue;
            }

            for (int[] p: adj.get(node)) {
                if (!visited.contains(p[0])) {
                    visited.add(p[0]);
                    q.offer(p[0]);
                    ans += p[1];
                }
            }
        }

        return ans;
    }
}